En estapractica se analizan los siguientes códigos:

primer codigo
def listEvens(list:List[Int]): String ={
	for(n <- list){
    	if(n%2==0){
        	println(s"$n is even")
    	}else{
        	println(s"$n is odd")
    	}
	}
	return "Done"
}
En esta funcion se declaran una lista conformada por numeros enteros y nos da a conocer si es par o impar

segundo codigo 
def​ afortunado(list:List[Int]): Int={
var​ res=​0 
 ​for​(n <- list){ 
 if​(n==​7​){ 
  res = res + ​14 
   }​else​{ 
    res = res + n 
    }
    }
    return res
    }
 
 declara una Lista llamada afortunado añadiendo numeros enteros, utilizando un ciclo for mientras el valor de n sea menor que la lista 
 Si n es igual a 7 esta imprimira el valor que de la operacion de re = res  + 14 

Tercer Codigo

def balance(list:List[Int]): Boolean={
	var primera = 0
	var segunda = 0

	segunda = list.sum

	for(i <- Range(0,list.length)){
    	primera = primera + list(i)
    	segunda = segunda - list(i)
    	if(primera == segunda){
        	return true
}
	}
	return false
}
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl) //TRUE output 3 = 3
balance(bl2) ///TRUE output 5 = 5
balance(bl3) //FALSE output 0 /= 130

en esta funcion se reciben dos listas con valor =0 y se asigna la suma de toda la Lista a la variable segunda
si alguno de los valores en la misma posición son iguales, regresa un verdadero, y si no es el caso regresa un falso.

Cuarto codigo

def palindromo(palabra:String):Boolean ={
	return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra)) //TRUE output "OSO"
def palindromo(palabra:String):Boolean ={
	return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra)) //TRUE output "OSO"
println(palindromo(palabra2)) //TRUE output "ANNA"
println(palindromo(palabra3)) //FALSE output "NAUJ"

esta es una funcion la cual cual revisa cada una de las palabras en reverso sea la misma que la palabra escrita de manera normal 



    
