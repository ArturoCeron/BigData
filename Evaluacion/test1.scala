import org.apache.spark.sql.SparkSession

//1. Comienza una simple sesión Spark.
val spark = SparkSession.builder().getOrCreate()

//2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Spark_DataFrame/Netflix_2011_2016.csv")

//3. ¿Cuáles son los nombres de las columnas?
df.columns

//4. ¿Cómo es el esquema?
df.printSchema()

//5. Imprime las primeras 5 columnas.
df.drop("Volume", "Adj Close").show()

//6. Usa describe () para aprender sobre el DataFrame.
df.describe()

//7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).
var hvRatio = df.withColumn("HV Ratio", df("High")/df("Volume"))

//8. ¿Qué día tuvo el pico mas alto en la columna “Close”?
val colDia = df.withColumn("Dia", dayofmonth(df("Date")))

val dias = colDia.groupBy("Dia").max()

val agrupados = dias.select($"Dia", $"max(Close)").sort(desc("max(Close)")).show()

//9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//Esta columna se refiere al precio que tuvo la bolsa o la acción al momento del cierre del día, fue el valor con el que se estuvo vendiendo 

//10. ¿Cuál es el máximo y mínimo de la columna “Volume”?
df.select(max("Volume"), min("Volume")).show()

//11.Con Sintaxis Scala/Spark $ conteste los siguiente:
//◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
//dataframe para contestar algunos de los incisos.

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?
df.filter($"Close" < 600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
val dias = df.filter($"High" > 500).count().toDouble
val porcentaje = ((dias / df.count())*100) // 4.92% aprox

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
df.select(corr("High", "Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?
val colAnio = df.withColumn("Anio", year(df("Date")))

val dfMaximos = colAnio.groupBy("Anio").max()

dfMaximos.select($"Anio", $"max(High)").show()

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?
val colMes = df.withColumn("Mes", month(df("Date")))

val dfProm = colMes.groupBy("Mes").mean() 

dfProm.select($"Mes", $"avg(Close)").show()
