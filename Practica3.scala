En estapractica se analizan los siguientes códigos:
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
    
