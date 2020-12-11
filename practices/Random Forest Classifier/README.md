Importing this libraries is required in order to get the example done.
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.attribute.Attribute
```
Load and parse the data file, converting it to a DataFrame.
val data = spark.read.format("libsvm").load("C:\\Spark\\spark-2.4.7-bin-hadoop2.7\\data\\mllib\\sample_libsvm_data.txt")
```scala
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```

Index labels, adding metadata to the label column.
Fit on whole dataset to include all labels in index.
```scala
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
val indexed =  labelIndexer.transform(data)
```

 Automatically identify categorical features, and index them.
 Set maxCategories so features with > 4 distinct values are treated as continuous.
```scala
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```

 Split the data into training and test sets (30% held out for testing).
```scala
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```

 Train a RandomForest model.
```scala
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)
```

Convert indexed labels back to original labels.
```scala
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels) 
```

  Here mark error <console>:32: error: value labelsArray is not a member of org.apache.spark.ml.feature.StringIndexer
  labelConverter.transform(indexed)
 Chain indexers and forest in a Pipeline.
 ```scala
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))
```
  
 Train model. This also runs the indexers.
```scala
val model = pipeline.fit(trainingData)
```

 Make predictions.
```scala
val predictions = model.transform(testData)
```
 Select example rows to display.
```scala
predictions.select("predictedLabel", "label", "features").show(5)
```

 predictions.select("prediction", "rawPrediction", "indexedFeatures", "label", "features", "indexedLabel", "probability").show(5)
 Select (prediction, true label) and compute test error.
```scala
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]

println(s"Learned classification forest model:\n ${rfModel.toDebugString}")
```
