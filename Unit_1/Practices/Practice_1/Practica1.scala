// Assessment 1/Practica 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo

var diametro: Double = 10.0
var radio: Double = 0.0

radio = diametro / 2

radio

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
}

//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"

var bird: String = "tweet"
println("Estoy escribiendo un ${bird}")

//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"

var mensaje: String = "Hola Luke yo soy tu padre!"

mensaje.slice(5, 9)

//5. Cual es la diferencia entre value y una variable en scala?
//Val sólo permite el valor especificado, no puede ser cambiado, en cambio, Var es mutable, puede ser modificado durante el proceso

//6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416

val tupla = (2,4,5,1,2,3,3.1416,23)
tupla._7
