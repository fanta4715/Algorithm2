

import java.util.*

fun main()=with(System.`in`.bufferedReader()){
    //N받음
    val N  = readLine().toInt()
    // int[][]배열 생성
    val semo = Array(N,{IntArray(N,{-6_000_000})})

    //for N
    for (i in 0 until N)
    {
        // for 0 to i
        val st = StringTokenizer(readLine())
        for (j in 0 .. i){
            semo[i][j]=st.nextToken().toInt()
        }
    }

    //dp로 풀기
    // dp[i][j]=dp[i-1][j] vs dp[i-1][j+1] +dfdf
    val dp = Array(N,{IntArray(N,{-6_000_000})})
    dp[0][0]=semo[0][0]
    for (i in 1 .. N-1){
        dp[i][0]=dp[i-1][0]+semo[i][0]
    }

    for (i in 1 until N){
        for (j in 1 .. i){
            dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+semo[i][j]

        }
    }

    Arrays.sort(dp[N-1])
    println(dp[N-1][N-1])


}