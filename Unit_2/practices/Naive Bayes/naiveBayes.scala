//Importaciones necesarias.
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Cargar los datos guardados en formato LIBSVM como un DataFrame.
val data = spark.read.format("libsvm").load("C:/Users/Sebas/Desktop/sample_libsvm_data.txt")
data.show(2)

//Separar los datos en sets de entrenamiento y de prueba (30% reservado para pruebas)
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)

// Entrenar un modelo Naive Bayes.
val model = new NaiveBayes().fit(trainingData)

// Seleccionar las filas de ejemplo a mostrar.
val predictions = model.transform(testData)
predictions.show()

// Selecciona (prediccion, etiqueta de cierto) y calcular errores de prueba
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)

println(s"Test set accuracy = $accuracy")
