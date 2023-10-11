

fun main()=with(System.`in`.bufferedReader()){
    //최대 1로 더하는 경우
    //최대 2로 더하는 경우
    //최대 3로 더하는 경우

    //T받기
    val T = readLine().toInt()
    //repeat(T)
    repeat(T){
        //n받기
        val n = readLine().toInt()

        //n으로 dp만들고, 출력
        //dp[n][1] = 최대 1로 n을 만드는 경우의수
        //dp[n][2] = 최대 2로 n을 만드는 경우의수
        //dp[n][3] = 최대 3로 n을 만드는 경우의수
        //출력 dp[n][1]+[2]+[3]
        //dp[n][3]=dp[n-3][1] + [2] + [3]
        //dp[n][2]=dp[n-2][1] + [2]
        //dp[n][1]=dp[n-1][1]
        val dp = Array(n+1,{IntArray(4,{0})})
        dp[1][1]=1
        if (n==1) {
            println(1)
            return@repeat
        }
        dp[2][1]=1
        dp[2][2]=1
        if (n==2){
            println(2)
            return@repeat
        }
        dp[3][1]=1
        dp[3][2]=2
        dp[3][3]=1

        for (i in 4 .. n){
            dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3]
            dp[i][2]=dp[i-2][1]+dp[i-2][2]+dp[i-2][3]
            dp[i][1]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3]
        }

        println(dp[n][1]+dp[n][2]+dp[n][3])
    }


}