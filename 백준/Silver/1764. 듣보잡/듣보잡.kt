

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main()=with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val set = HashSet<String>()
    repeat(N){
        set.add(readLine())
    }
    val pq=PriorityQueue<String>()
    repeat(M){
        val str= readLine()
        if (set.contains(str)) pq.add(str)
    }

    println(pq.size)
    for (i in 0 until pq.size){
        println(pq.poll())
    }



}