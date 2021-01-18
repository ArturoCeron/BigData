# Practice 4

# Fibonacci Algorithm

In this practice we need to develop 5 different kind of algorithms

## Algorithm #1
This is a recursive algorithm, what it does is that keeps adding the previous value and the one before that one

```scala
// Algoritmo 1

def fiboA1(n: Int): Int = {

    if (n < 2)
        return n
    else {
        return fiboA1(n - 1) + fiboA1(n - 2)
    }

}
fiboA1(10) // Resultado: 55
```

## Algorithm #2
In this algorithm we use some mathematics, in order to solve this one we needed to use the 'Math' library

```scala
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
```

## Algorithm #3
This code requires 3 variables, these are the ones that we need to add the values and store the ones that we need to the next step 

```scala
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
```

## Algorithm #4
This algorithm and the number 3 are almost the same, the code adds the values and then changes the value to the next to use it and add it

```scala
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
```

## Algorithm #5
This algorithm is particularly different from the others, this one uses vectors to solve the problem

``` scala
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
```
