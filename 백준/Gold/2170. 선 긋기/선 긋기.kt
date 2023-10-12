
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main()=with(System.`in`.bufferedReader()){
    //N을 받는다
    val N = readLine().toInt()
    var answer=0
    val pq =PriorityQueue<Line>()
    //N만큼 값을 받는다
    repeat(N){
        val st= StringTokenizer(readLine())
        pq.add(Line(st.nextToken().toInt(),st.nextToken().toInt()))
    }

    //while (front
    val first=pq.poll()
    answer =first.end-first.start
    var lastEnd = first.end
    while (!pq.isEmpty()){
        //프론트 하나 꺼냄
        val thisLine = pq.poll()
        //현재 now보다 크거나 같은 경우, 다음
        // 경우의 수 3가지
        //1. thisLine의 end가 lastEnd보다 작은 경우
        if (thisLine.end <= lastEnd) continue
        //2. thisLine의 end가 lastEnd보다 크고, first는 end보다 작은경우
        else if (thisLine.start >=lastEnd) {
            answer+=(thisLine.end-thisLine.start)
            lastEnd = thisLine.end
        }
        //3. thisLine의 first가 end보다 큰 경우
        else {
            answer+=(thisLine.end-lastEnd)
            lastEnd=thisLine.end
        }
    }

    println(answer)
}

class Line(val start:Int, val end:Int):Comparable<Line> {
    override fun compareTo(other: Line): Int {
        return this.start-other.start;
    }

}
