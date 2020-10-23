# Practice 1



In this practice the following codes are analyzed:

# first code
``` scala

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


In this function, a list made up of whole numbers is declared and it tells us if it is even or odd

# second code

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
    
 declare a List named lucky by adding integers, using a for loop as long as the value of n is less than the list
 If n is equal to 7 this will print the value of the operation of re = res + 14

# Third Code

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

In this function, two lists with value = 0 are received and the sum of the entire List is assigned to the second variable
if any of the values ​​in the same position are equal, it returns a true, and if not, it returns a false.

# Fourth code
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

this is a function which checks each of the words in reverse is the same as the word written in a normal way

