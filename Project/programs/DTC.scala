val start = System.currentTimeMillis

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{VectorAssembler, IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.SparkSession

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("C:/Users/CORSAIR/Desktop/proyecto/bank-full.csv")

//Transform the categorical data to numeric, merges the new data with the previous values
//this time with the numeric data and renames the loan column as label to use it in the execution
val labelIndexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).drop("loan").withColumnRenamed("indexedLabel", "label") 
val assembler = (new VectorAssembler().setInputCols(Array("age", "balance", "day", "duration", "previous")).setOutputCol("features"))
val features = assembler.transform(indexed)
val filter = features.withColumnRenamed("loan", "label")

val finalData = filter.select("label", "features")

// Index labels, adding metadata to the label column.
// Fit on whole dataset to include all labels into the index.
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(finalData)
// Automatically identify categorical features and then index them.
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(finalData)
// Split the data into training and test sets (30% held out for testing).
val Array(trainingData, testData) = finalData.randomSplit(Array(0.7, 0.3))

// Train a DecisionTree model.
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

// Convert indexed labels back to original labels.
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Chain indexers and tree in a Pipeline.
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

// Train the model, this also runs the indexers.
val model = pipeline.fit(trainingData)

// Make the predictions.
val predictions = model.transform(testData)

// Select example rows to display. In this case there was only 5 rows to show.
predictions.select("predictedLabel", "label", "features").show(5)

// Select (prediction, true label)
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
// Compute the test error.
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

// Show by stages the classification of the tree model
val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n ${treeModel.toDebugString}")

//Get the total time of the program execution
val totalTime = System.currentTimeMillis - start
println("Elapsed time: %1d ms".format(totalTime))

//Get the total of MB used 
val runtime = Runtime.getRuntime
val mb = 1024*1024
println("Used memory: " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")