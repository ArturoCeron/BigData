# Practice 1


# Exercise 1
A program to solve the circle's radius is needed, so, we develop this code
``` scala

/1. Desarrollar un algoritmo en scala que calcule el radio de un circulo

var diametro: Double = 10.0
var radio: Double = 0.0

radio = diametro / 2

radio```

# Exercise 2
This code shows if a number is prime or it isn't 
``` scala
//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
var numero: Int = 16 
var primo: Boolean = true

for(valor <- Range(2,numero))
{
    if ((numero % valor) == 0){
        primo = false
    }
}

if (primo == true){
    println("Es primo")
}else{
    println("No es primo")
}```

# Exercise 3
This code prints the phrase "Estoy escribiendo un tweet"

```scala
//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"

var bird: String = "tweet"
println(s"Estoy escribiendo un ${bird}")```

# Exercise 4
We need to split the string and just show the word "Luke"
``` scala
//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"

var mensaje: String = "Hola Luke yo soy tu padre!"

mensaje.slice(5, 9)```

# Exercise 5
This is not code exactly, we just define a question in a scala comment
``` scala
//5. Cual es la diferencia entre value y una variable en scala?
//Val sólo permite el valor especificado, no puede ser cambiado, 
//en cambio, Var es mutable, puede ser modificado durante el proceso ```

# Exercise 6
In this code we returned the value specified at the given tuple

``` scala
//6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416
val tupla = (2,4,5,1,2,3,3.1416,23)
tupla._7```

