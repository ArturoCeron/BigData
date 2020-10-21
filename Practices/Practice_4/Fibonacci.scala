// Algoritmo 1

def fiboA1(n: Int): Int = {

    if (n < 2)
        return n
    else {
        return fiboA1(n - 1) + fiboA1(n - 2)
    }

}
fiboA1(10) // Resultado: 55

//Algoritmo 2

var i: Double = ((1 + Math.sqrt(5)) / 2)
var j: Double = 0

def fiboA2(n: Double): Double = {

    if (n < 2)
        return n
    else {
        j = ((Math.pow(i, n) - Math.pow((1 - i), n)) / Math.sqrt(5))
        return j
    }
}

fiboA2(15) //Resultado: 610.0000000000003

// Algortimo 3

var a: Int = 0
var b: Int = 1
var c: Int = 0

def fiboA3(n: Int): Int = {
    a = 0
    b = 1
    c = 0

    for (k <- Range(0, n)){
        c = b + a
        a = b
        b = c 
    }

    return a
}

fiboA3(7)  //Resultado = 13

// Algortimo 4

var a: Int = 0
var b: Int = 1

def fiboA4(n: Int): Int = {
    a = 0
    b = 1

    for (k <- Range(0, n)){
        b = b + a
        a = b - a
    }

    return a
}

fiboA4(6)  //Resultado = 8

// Algortimo 5

def fiboA5(n: Int): Int = {
    if (n < 2)
        return n
    else {
        var vector = new Array[Int](n + 1)
        vector(0) = 0
        vector(1) = 1
        for (k <- Range(2, n + 1)){
            vector(k) = vector(k -  1) + vector(k - 2)
        }
        return vector(n)
    }
}

fiboA5(21)