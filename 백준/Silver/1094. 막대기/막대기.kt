

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var N = readLine().toInt()
    var length=64
    var cnt =0
    while (N!=0){
        if (N-length>=0) {
            cnt++
            N-=length
        }

        length/=2
    }
    println(cnt)
}