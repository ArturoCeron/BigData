//Practice 2
// 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
var lista = List("rojo", "blanco", "negro")

// 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
var add1 = "verde" :: lista
var add2 = "amarillo" :: add1
var add3 = "azul" :: add2
var add4 = "naranja" :: add3
var add5 = "perla" :: add4
// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
add5 slice (2, 5)

// 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
var arreglo = Array(Range(1,1000, 5))

// 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
val Lista = List(1,3,3,4,6,7,3,7)  
val ListaSet = Lista.toSet

// 6. Crea una mapa mutable llamado nombres que contenga los siguiente
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
var mapa = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

// 6 a . Imprime todas la llaves del mapa
for (llaves <- mapa.keys){
    println(llaves)
}
// 7 b . Agrega el siguiente valor al mapa("Miguel", 23)
mapa += ("Miguel" -> 23)