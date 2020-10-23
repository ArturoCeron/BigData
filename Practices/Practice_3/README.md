# Practice 1


# Exercise 1

In this practice the following codes are analyzed:

/1. first code
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
