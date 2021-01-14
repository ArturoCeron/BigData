//Libraries needed for the test
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//Star the spark session
val spark = SparkSession.builder().getOrCreate()

//Load the data from the csv
val data = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/CORSAIR/Desktop/Examen2/iris.csv")

//Shows the columns
data.columns

//Shows the schema
data.printSchema()

//Shows the columns and the first 20 values
data.show()

//Describe the data
data.describe()

//Transform the categorical data to numeric
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedSpecies").fit(data)
val indexed = labelIndexer.transform(data).withColumnRenamed("indexedSpecies", "label") 

//In order to avoid error we need to create 2 new columns label and features
//Here we create them using StringIndexer and VectorAssembler
val labelIndexer2 = new StringIndexer().setInputCol("label").setOutputCol("indexedSpecies").fit(indexed)
val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
val  features = assembler.transform(indexed)

//Splits the characteristics in 70% training and 30% test
val splits = features.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test = splits(1)

//Specify layers for the neural network:
// input layer of size 4 (features), two intermediate of size 5 and 4
// and output of size 3 (classes)
val layers = Array[Int](4, 5, 4, 3)

//Create the trainer and set the specific parameters needed
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

//Train the model from the trainer
val model = trainer.fit(train)

//Get the resulting values of accuracy
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print the results and stop spark
println(s"\n\nTest set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
spark.stop()