val start = System.currentTimeMillis
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

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

val logregdata = filter.select("label", "age", "balance", "day", "duration", "previous")

val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(assembler, lr))

val model = pipeline.fit(training)

val results = model.transform(test)

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy

val error = 1 - metrics.accuracy

//Get the total time of the program execution
val totalTime = System.currentTimeMillis - start
println("Elapsed time: %1d ms".format(totalTime))

//Get the total of MB used 
val runtime = Runtime.getRuntime
val mb = 1024*1024
println("Used memory: " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")