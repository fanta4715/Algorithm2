

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main()=with(System.`in`.bufferedReader()){
    //N받기
    val N = readLine().toInt()
    //N개 point받고 pq저장
    val pq = PriorityQueue<Point>()
    repeat(N){
        val st= StringTokenizer(readLine())
        pq.add(Point(st.nextToken().toInt(),st.nextToken().toInt()))
    }
    //출력
    repeat(N){
        val point = pq.poll()
        println("${point.x} ${point.y}")
    }
}

class Point(val x:Int, val y:Int):Comparable<Point>{
    override fun compareTo(other: Point): Int {
        if (this.y==other.y) return this.x-other.x
        return this.y-other.y
    }

}