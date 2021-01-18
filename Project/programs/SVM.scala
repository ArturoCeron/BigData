val start = System.currentTimeMillis
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.mllib.evaluation.MulticlassMetrics

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)



val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("C:/Users/CORSAIR/Desktop/proyecto/bank-full.csv")

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

//Transform the categorical data to numeric
val labelIndexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).withColumnRenamed("indexedLabel", "label") 

//In order to avoid error we need to create 2 new columns label and features
//Here we create them using StringIndexer and VectorAssembler
val assembler = new VectorAssembler().setInputCols(Array("age", "balance", "day", "duration", "previous")).setOutputCol("features")
val features = assembler.transform(indexed)

val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)

val lsvcModel = lsvc.fit(training)

val results = lsvcModel.transform(test)

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy

val error = 1 - metrics.accuracy

println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")

//Get the total time of the program execution
val totalTime = System.currentTimeMillis - start
println("Elapsed time: %1d ms".format(totalTime))

//Get the total of MB used 
val runtime = Runtime.getRuntime
val mb = 1024*1024
println("Used memory: " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")