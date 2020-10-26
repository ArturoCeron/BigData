# Test 1

# Answer the following questions with Spark DataFrames using the file "Netflix_2011_2016.csv."

``` scala
import org.apache.spark.sql.SparkSession

//1. Comienza una simple sesión Spark.
val spark = SparkSession.builder().getOrCreate()
``` 

``` scala
//2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Spark_DataFrame/Netflix_2011_2016.csv")
```

``` scala
//3. ¿Cuáles son los nombres de las columnas?
df.columns
```

``` scala
//4. ¿Cómo es el esquema?
df.printSchema()
```

``` scala
//5. Imprime las primeras 5 columnas.
df.drop("Volume", "Adj Close").show()
```

``` scala
//6. Usa describe () para aprender sobre el DataFrame.
df.describe()
```

``` scala
//7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).
var hvRatio = df.withColumn("HV Ratio", df("High")/df("Volume"))
```

## 8.- Which day had the most high peak in the column "Close"? 
First of all, we need the day that had the peak we are looking for, so we added a new column to our dataframe with this

``` scala
//8. ¿Qué día tuvo el pico mas alto en la columna “Close”?
val colDia = df.withColumn("Dia", dayofmonth(df("Date")))
```
The next step was to use a groupBy to order them with by maximum values

``` scala
val dias = colDia.groupBy("Dia").max()
```
And the last step was to show it, here we used a select with a sort by descendent.

``` scala
val agrupados = dias.select($"Dia", $"max(Close)").sort(desc("max(Close)")).show()
``` 
## 9.- With your own words describe in a comment the meaning of the column "Close"

``` scala
//9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//Esta columna se refiere al precio que tuvo la bolsa o la acción al momento del cierre del día, 
//fue el valor con el que se estuvo vendiendo 
```
## 10.- What is the max and the min in the Volume column
Here we combine the select, we showed the two columns at once with the next code

``` scala
//10. ¿Cuál es el máximo y mínimo de la columna “Volume”?
df.select(max("Volume"), min("Volume")).show()
```
## 11.- This question is divided by sections, the first one asks us to show the amount of days that the column Close was inferior to $600
In order to solve this we needed a filter function, in which we used a simply "<" sign to find the amount of days 

``` scala
//11.Con Sintaxis Scala/Spark $ conteste los siguiente:
//◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
//dataframe para contestar algunos de los incisos.

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?
df.filter($"Close" < 600).count() 
```
## This question was about the percentage of time that the column High was higher than $500
First we created a variable that contains the amount of days that the column was higher than 500 and then we converted 
to double, this was because at the time that we need to divide we were going to need a double variable in order to not have any error in the runtime.
Then we created our variable that contais the percentage and we just divide the number of days by the total of days and then multiply by 100 to get the percentage

``` scala
//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
val dias = df.filter($"High" > 500).count().toDouble
val porcentaje = ((dias / df.count())*100) // 4.92% aprox
```
## Pearson correlation coefficient
Here we need the pearson correlation, we get this with a select and the function "corr" that automatically gives us the coefficient

``` scala
//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
df.select(corr("High", "Volume")).show()
```
## Max value at the High column by year
Just like we did at the exercise #8 we need to add a year column, then we get the max values with a groupBy and finally we use a select to show the results

``` scala
//d. ¿Cuál es el máximo de la columna “High” por año?
val colAnio = df.withColumn("Anio", year(df("Date")))

val dfMaximos = colAnio.groupBy("Anio").max()

dfMaximos.select($"Anio", $"max(High)").show()
```
## Average value at the Close column by month
Same process that we did before, we just change the year for a month, then we get the average values with the function "mean" and then we show them with a select

``` scala
//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?
val colMes = df.withColumn("Mes", month(df("Date")))

val dfProm = colMes.groupBy("Mes").mean()

dfProm.select($"Mes", $"avg(Close)").show()
```
