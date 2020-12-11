import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

Upload data file.
```scala
var inputData = spark.read.format("libsvm").load("/opt/spark/data/mllib/sample_multiclass_classification_data.txt")
```

Generate the train / test split.
```scala
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))
```

Instantiate base classifier
```scala
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)
```

Create an instance of the One Vs Rest classifier.
```scala
val ovr = new OneVsRest().setClassifier(classifier)
```

Trains the multiclass model.
```scala
val ovrModel = ovr.fit(train)
```

Score the model on the test data.
```scala
val predictions = ovrModel.transform(test)
```

Get evaluator.
```scala
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
```

calculates the classification error in the test data.
```scala
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")
```
