

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main()=with(System.`in`.bufferedReader()){
    //T받기
    val T = readLine().toInt()

    repeat(T){
        //N받기
        val N = readLine().toInt()
        val pq =PriorityQueue<Univ>()
        //for N ;
        repeat(N){
            val st = StringTokenizer(readLine())
            pq.add(Univ(st.nextToken(),st.nextToken().toInt()))
        }

        println(pq.peek().name)
    }

}

class Univ(val name:String, val alchol:Int):Comparable<Univ>{
    override fun compareTo(other: Univ): Int {
        return other.alchol-this.alchol
    }
}
