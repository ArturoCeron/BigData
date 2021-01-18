We ned the library LinearSVC for this exercise 

```scala
import org.apache.spark.ml.classification.LinearSVC
```

Here we load the data from the txt data file
```scala
val training = spark.read.format("libsvm").load("C:/Users/DELL/Desktop/LSVMExample/sample_libsvm_data.txt")
```
Then we create our model and specify that only 10 iterations an 0.1 of regularization parameter
```scala
val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)
```
The we fit the data of the variable training
```scala
val lsvcModel = lsvc.fit(training)
```
And finally we print the results
```scala
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")
```
