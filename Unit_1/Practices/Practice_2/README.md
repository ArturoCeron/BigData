# Practice 2

# Exercise 1
The exercise asks for a list with some colors

``` scala 
// 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
var lista = List("rojo", "blanco", "negro")
```

# Exercise 2
To the list created before, we need to add some more values to it

``` scala
// 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
var add1 = "verde" :: lista
var add2 = "amarillo" :: add1
var add3 = "azul" :: add2
var add4 = "naranja" :: add3
var add5 = "perla" :: add4
```

# Exercise 3
We need to show certain elements of the list, for this we used 'slice'

``` scala
// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
add5 slice (2, 5)
```

# Exercise 4 
This code creates an array with a range of valos from 1 to 1000 in steps of 5

``` scala
// 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
var arreglo = Array(Range(1,1000, 5))
```

# Exercise 5
This exercise requires to convert a list o a set.

``` scala
// 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
val Lista = List(1,3,3,4,6,7,3,7)  
val ListaSet = Lista.toSet
```

# Exercise 6
This exercise requires 2 different codes, the first one asks to create a mutable map with certain names and ages and the second one asks us to print all the map keys

``` scala
// 6. Crea una mapa mutable llamado nombres que contenga los siguiente
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
var mapa = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

// 6 a . Imprime todas la llaves del mapa
for (llaves <- mapa.keys){
    println(llaves)
}
```

# Exercise 7
This last exercise asks us to add a value to the map created before

``` scala
// 7 b . Agrega el siguiente valor al mapa("Miguel", 23)
mapa += ("Miguel" -> 23)
```
