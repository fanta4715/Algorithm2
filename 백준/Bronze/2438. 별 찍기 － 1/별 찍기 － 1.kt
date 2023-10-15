
// https://www.acmicpc.net/problem/2438
import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    for (j in 1..n){
        for (i in 1..j){
            print("*")
        }
        println()
    }

}