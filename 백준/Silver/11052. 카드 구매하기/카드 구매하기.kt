

import java.util.PriorityQueue
import java.util.StringTokenizer
//https://www.acmicpc.net/problem/11052
fun main()=with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val pack= IntArray(N+1,{0})

    val st =StringTokenizer(readLine())
    val dp = IntArray(N+1,{0})
    for ( i in 1 .. N){
        pack[i]=st.nextToken().toInt()
        dp[i]=pack[i]
    }

    //dp로 풀어보자4
    //5장 사는 경우
    //5장짜리, 4장짜리 + 1장사는 경우, 3장짜리+2장사는경우,


    for (i in 1 .. N){
        for (j in 1..i){
            dp[i]=Math.max(dp[i-j]+pack[j], dp[i])
        }
    }
        println(dp[N])

    //max는 카드당 가격을 의미함.

}
