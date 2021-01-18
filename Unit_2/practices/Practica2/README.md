#  Logistic regression project

 In this project we will be working with a fake advertising data set, indicating whether or not a particular internet user clicked on an Advertisement. We will try to create a model that will predict whether or not they will click on an ad based off the features of that user.
 This data set contains the following features:
    'Daily Time Spent on Site': consumer time on site in minutes
    'Age': cutomer age in years
    'Area Income': Avg. Income of geographical area of consumer
    'Daily Internet Usage': Avg. minutes a day consumer is on the internet
    'Ad Topic Line': Headline of the advertisement
    'City': City of consumer
    'Male': Whether or not consumer was male
    'Country': Country of consumer
    'Timestamp': Time at which consumer clicked on Ad or closed window
    'Clicked on Ad': 0 or 1 indicated clicking on Ad

### Complete the following tasks that are commented

Import a SparkSession with the Logistic Regression library
// Optional: Utilizar el codigo de  Error reporting

Create a Spark session

Use Spark to read the Advertising csv file.

Print the Schema of the DataFrame

```scala
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")

data.printSchema()
```

### Deploy the data

Print an example line

```scala
data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
```

### Prepare the DataFrame for Machine Learning

Do the next:
- Rename the column "Clicked on Ad" to "label"
- Take the following columns as features "Daily Time Spent on Site", "Age", "Area Income", "Daily Internet Usage", "Timestamp", "Male"
- Create a new column called "Hour" from the Timestamp containing the "Hour of the click"

```scala
val timedata = data.withColumn("Hour",hour(data("Timestamp")))

val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")
```
Import VectorAssembler and Vectors

Create a new VectorAssembler object called assembler for the features

```scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))
```

Use randomSplit to create 70/30 split test and train data

```scala
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
```

### Set up a Pipeline

Pipeline Amount
Create a new LogisticRegression object called lr
Create a new pipeline with the elements: assembler, lr
Fit the pipeline for the training set.
Take the Results in the Test set with transform

```scala
import org.apache.spark.ml.Pipeline

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(assembler, lr))

val model = pipeline.fit(training)

val results = model.transform(test)
```

### Model evaluation

For Metrics and Evaluation import MulticlassMetrics
Convert test results to RDD using .as and .rdd
Initialize a MulticlassMetrics object
Print the Confusion matrix

```scala
import org.apache.spark.mllib.evaluation.MulticlassMetrics

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy
```
 
