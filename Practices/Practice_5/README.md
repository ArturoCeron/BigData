# Practice5

# 15 functions that can be applied in data frames in the scala language.

## 1.-where. Filter rows using the given condition.
```scala
val wheredf = df.where($"Date" === "2006-01-06")
wheredf.show()

```
## 2.-agg. the entire dataset is added without groups
```scala
val aggdf = df.agg(Map("High" -> "max"))
aggdf.show()
```
## 3.-df.show () shows only the first 20 records of the dataframe.
```scala
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
```
## 4.-first, returns the first row of the dataframe
```scala
scala> df.head()
res4: org.apache.spark.sql.Row = [0.23,SI2,326]
```
## 5.-takeAsList () returns the specified number of rows in the method as a list.
```scala
df.takeAsList(10)
res2: java.util.List[org.apache.spark.sql.Row] = [[0.23,SI2,326], 
[0.21,SI1,326], [0.23,VS1,327], [0.29,VS2,334], [0.31,SI2,335], 
[0.24,VVS2,336], [0.24,VVS1,336], [0.26,SI1,337], [0.22,VS2,337], 
[0.23,VS1,338]]
```
## 6.-takeAsList. Returns the first n rows of the dataset as a list.
```scala
df.takeAsList(5)
```
## 7.-sort. Returns a new data set ordered by the given expressions.
```scala
val sortdf = df.sort($"Volume".desc)
sortdf.show()
```
## 8.cube. A new "dataset" is created.
```scala
val cubedf=df.cube($"High",$"Low").agg(Map("Low"-> "avg"))
cubedf.show()
```
## 9.-collectdf. Regresa el "Dataset" original.
```scala
val collectdf=df.collect()
collectdf
```
## 10.-scala> df.sort ($ "price" .asc) .show () Arrange the rows of the data frame.
```scala
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
```
## 11.-where () returns the records.
```scala
df.where("price = 326")
```
## 12.-min () returns the minimum value of the grouping.
```scala
df.groupBy("clarity").min("price")
```
## 13.-groupBy () Makes a group on the data frame.
```scala
df.groupBy("clarity")
```
## 14.-distinct () Returns only unique values ​​in the data frame.
```scala
scala> df.distinct()
res8: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = 

[carat: string, clarity: string ... 1 more field]
```
