

import java.lang.Math.pow
import java.util.StringTokenizer
import kotlin.math.pow

fun main()=with(System.`in`.bufferedReader()){
    // N row col 받기
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    var row = st.nextToken().toInt()
    var col = st.nextToken().toInt()

    //기준크기가 1이 될때까지 범위를 좁힘
    // 1사분면 : 전체크기* 1/4 , 좌표 col-
    // 2사분면 : +0
    // 3사분면 : 전체크기 *2/4 , 좌표 row-
    // 4사분면 : 전체크기 *3/4 , 좌표 row- col-

    //N이 3인경우, 처음에 2^3/2 row col을 기준으로 나눔
    //그 다음 row,col을 상대적으로 이동후
    //N이 2인경우와 동일하게 시행, 2^2/2
    // N이 1인경우와 동일하게 시행 ->
    var standard:Int= (2.0).pow(N-1).toInt();
    var count:Int=0
    while(standard>=1){
        // - - - +
        // + - + +
        //1사분면 row> col>
        if (row<standard && col>=standard) {
            count+=standard*standard
            col-=standard
        }
        //2사분면 안해도됨

        //3사분면
        else if (row>=standard && col<standard){
            count+=(standard*standard)*2
            row-=standard
        }

        //4사분면
        else if (row>=standard && col>=standard){
            count+=(standard*standard)*3
            row-=standard
            col-=standard
        }

        standard/=2

    }
    println(count)
}