 LINEAR REGRESSION EXERCISE

Complete commented tasks

We import the linear regression library with the code:
// Import LinearRegression
```scala
import org.apache.spark.ml.regression.LinearRegression
```
Optional: Use the following code to configure errors
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
Start a simple Spark Session
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
```

Use Spark for Clean-Ecommerce csv file.
```scala
val data = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/CORSAIR/Desktop/Examen2/Clean-Ecommerce.csv")
```

Print the schema in the DataFrame.
```scala
data.printSchema()
```

Print an example row from the DataFrane.
```scala
data.show(1)

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


   Configure el DataFrame para Machine Learning

Transform the data frame to take the form of
("label","features")

Import VectorAssembler and Vectors

```scala
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```

Rename the column Yearly Amount Spent as "label"
Also from the data take only the numerical column 
Leave all of this as a new DataFrame called df

```scala
val df = data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership")
```
Let the assembler object convert the input values ​​to a vector

```scala
val assembler = new VectorAssembler().setInputCols(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms", "Avg Area Number of Bedrooms", "Area Population")).setOutputCol("features")
```
Use the VectorAssembler object to convert the input columns of the df to a single output column of an array named "features" Set the input columns from which we are supposed to read the values. Call this new assambler.

```scala
val assembler = new VectorAssembler().setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership")).setOutputCol("features")
```
Use the assembler to transform our DataFrame to two columns: label and features

```scala
val  features = assembler.transform(df).select($"label", $"features")
```
Create an object for a linear regression model.

```scala
val lReg = new LinearRegression()
```
Fit the model for the data and call this model lrModel

```scala
val lrModelo = lReg.fit(features)
```
Print the coefficients and intercept for linear regression

Summarize the model on the training set print the output of some metrics!
Use our model's .summary method to create an object
called trainingSummary

```scala
val trainingSummary = lrModelo.summary
```
And we print the residuals, the root meand squared error (RMSE), the mean squared error (MSE) and the r².
```scala
trainingSummary.residuals.show()
trainingSummary.predictions.show()
trainingSummary.r2 //variaza que hay 
trainingSummary.rootMeanSquaredError
trainingSummary.meanSquaredError
```
// Buen trabajo!
 
