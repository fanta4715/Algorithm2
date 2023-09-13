package a230913

import java.util.*

fun main() = with(Scanner(System.`in`)){
    val a = nextInt()
    val b =nextInt()
    val c= nextInt()
    
    println((a+b)%c)
    println(((a%c)+(b%c))%c)
    println((a*b)%c)
    println(((a%c)*(b%c))%c)
}