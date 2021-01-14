val start = System.currentTimeMillis

//Libraries needed for the test
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Star the spark session
val spark = SparkSession.builder().getOrCreate()

//Load the data from the csv
val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("C:/Users/CORSAIR/Desktop/proyecto/bank-full.csv")

//Transform the categorical data to numeric
val labelIndexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).withColumnRenamed("indexedLabel", "label") 

//In order to avoid error we need to create 2 new columns label and features
//Here we create them using StringIndexer and VectorAssembler
val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","previous")).setOutputCol("features")
val features = assembler.transform(indexed)

//Splits the characteristics in 70% training and 30% test
val splits = features.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test = splits(1)

//Specify layers for the neural network:
// input layer of size 4 (features), two intermediate of size 5 and 4
// and output of size 2 (classes)
val layers = Array[Int](4, 5, 4, 2)

//Create the trainer and set the specific parameters needed
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

//Train the model from the trainer
val model = trainer.fit(train)

//Get the resulting values of accuracy
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Prints the results of accuracy
println(s"\n\nTest set accuracy = ${evaluator.evaluate(predictionAndLabels)}")

val error = 1 - evaluator.evaluate(predictionAndLabels)
println("Error: " + error)

//Get the total time of the program execution
val totalTime = System.currentTimeMillis - start
println("Elapsed time: %1d ms".format(totalTime))

//Get the total of MB used 
val runtime = Runtime.getRuntime
val mb = 1024*1024
println("Used memory: " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")
