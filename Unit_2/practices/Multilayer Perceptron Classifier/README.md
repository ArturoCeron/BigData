Import MultilayerPerceptronClassifier y MulticlassClassificationEvaluator
```scala
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```
 $example off$

Spark session is imported
```scala
import org.apache.spark.sql.SparkSession
```

An example for Multilayer Perceptron Classification.

Creation of the MultilayerPerceptronClassifier object
```scala
object MultilayerPerceptronClassifierExample {
```

The main function is defined which has as a parameter an Array of type string
  def main (): Unit = {
 
 The SparkSession class object is created, and the app is given the name of
MultilayerPerceptronClassifierExample
```scala
    val spark = SparkSession
      .builder
      .appName("MultilayerPerceptronClassifierExample")
      .getOrCreate()
      ```

$example on$
The data is loaded in libsvm format from the file as a DataFrame
```scala
    val data = spark.read.format("libsvm")
      .load("sample_multiclass_classification_data.txt")
 ```
 
 Data is divided into training and testing
```scala
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
```
The layers of the neural network are specified:
The input layer is size 4 (characteristics), two intermediate layers
one size 5 and the other size 4
and 3 out (the classes)
```scala
    val layers = Array[Int](4, 5, 4, 3)
```
Training parameters are set
```scala
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)
```
The model is trained
```scala
    val model = trainer.fit(train)
```
The precision of the test data is calculated
```scala
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator()
      .setMetricName("accuracy")
```
The exactitude of the model is printed
```scala
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```
$example off$
```scala
    spark.stop()
  }
}
```
