//15 funciones que se pueden aplicar en data frames en el lenguaje scala.
//1.-where. Filtra filas usando la condición dada.
val wheredf = df.where($"Date" === "2006-01-06")
wheredf.show()

//2.-   agg. se agregan todo el conjunto de datos sin grupos
val aggdf = df.agg(Map("High" -> "max"))
aggdf.show()

//3.- df.show() muestra solamente los primeros 20 registros del dataframe.
+-----+-------+-----+
|carat|clarity|price|
+-----+-------+-----+
| 0.23|    SI2|  326|
| 0.21|    SI1|  326|
| 0.23|    VS1|  327|
| 0.29|    VS2|  334|
| 0.31|    SI2|  335|
| 0.24|   VVS2|  336|
| 0.24|   VVS1|  336|
| 0.26|    SI1|  337|
| 0.22|    VS2|  337|
| 0.23|    VS1|  338|
|  0.3|    SI1|  339|
| 0.23|    VS1|  340|
| 0.22|    SI1|  342|
| 0.31|    SI2|  344|
|  0.2|    SI2|  345|
| 0.32|     I1|  345|
|  0.3|    SI2|  348|
|  0.3|    SI1|  351|
|  0.3|    SI1|  351|
|  0.3|    SI1|  351|
+-----+-------+-----+
only showing top 20 rows

//4.- first, devuelve la primera fila del dataframe
scala> df.head()
res4: org.apache.spark.sql.Row = [0.23,SI2,326]

//6.- takeAsList() devuelve el número especificado de filas en el método como una lista. 
df.takeAsList(10)
res2: java.util.List[org.apache.spark.sql.Row] = [[0.23,SI2,326], 
[0.21,SI1,326], [0.23,VS1,327], [0.29,VS2,334], [0.31,SI2,335], 
[0.24,VVS2,336], [0.24,VVS1,336], [0.26,SI1,337], [0.22,VS2,337], 
[0.23,VS1,338]]

//7.-takeAsList. Devuelve las primeras n filas del conjunto de datos como una lista
df.takeAsList(5)

//8.-sort. Regresa un nuevo conjunto de datos ordenado por las expresiones dadas
val sortdf = df.sort($"Volume".desc)
sortdf.show()

//9.-cube. Se crea un nuevo "dataset"
val cubedf=df.cube($"High",$"Low").agg(Map("Low"-> "avg"))
cubedf.show()

//10.-collectdf. Regresa el "Dataset" original
val collectdf=df.collect()
collectdf

//11.- scala> df.sort($"price".asc).show() Acomoda las filas del data frame 
+-----+-------+-----+
|carat|clarity|price|
+-----+-------+-----+
| 0.38|   VVS2| 1000|
| 0.53|    SI2| 1000|
| 0.39|    VS1| 1000|
| 0.38|    VS1| 1000|
| 0.38|    VS1| 1000|
| 0.38|    VS1| 1000|
| 0.38|    VS1| 1000|
| 0.53|    SI2| 1000|
| 0.57|    SI2| 1000|
| 0.38|    VS1| 1000|
|  0.5|    SI2| 1000|
|  0.3|   VVS1| 1000|
| 0.35|   VVS1| 1000|
| 0.38|    VS1| 1000|
|  0.3|   VVS1| 1000|
| 0.38|    VS1| 1000|
| 0.38|    VS1| 1000|
| 0.38|    VS1| 1000|
|  0.5|    SI2| 1000|
| 0.34|   VVS1| 1000|
+-----+-------+-----+
only showing top 20 rows

//12.-where() Regresa los registros 
df.where("price = 326")

//13.-min() nos devuelve el valor minimo de la agrupacion
df.groupBy("clarity").min("price")

//14.-groupBy() Hace una agrupación en el data frame
df.groupBy("clarity")

//15.-distinct() Regresa solamente valores unicos en el data frame.
scala> df.distinct()
res8: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = 
[carat: string, clarity: string ... 1 more field]

