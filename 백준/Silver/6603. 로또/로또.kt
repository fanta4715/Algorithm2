
import java.util.*
import kotlin.collections.ArrayList

lateinit var sb:ArrayList<String>
//https://www.acmicpc.net/problem/6603
fun main()=with(System.`in`.bufferedReader()){
    while(true){
        val arr = readLine().split(" ")
        if (arr.size==1) break;

        //brute force인데, 고르기만 하면 됨
        sb=ArrayList<String>()
        bruteForce("",arr,0,0);
     //   Collections.sort(sb)
        for (i in 0 until sb.size){
            println(sb[i])
        }
        println()
    }
}

fun bruteForce(str:String, arr:List<String>, lastIndex:Int, cnt:Int){
   //현재 만들어진 문자열의 길이가 12일 때, 바로 sb에 넣고 끝냄
    if (cnt==6) {
        sb.add(str)
        return
    }

    // 전체개수와 현재 고른 개수와 마지막 번호가 중요함
    // 마지막 개수에서 뒤에 남은 개수와 골라야 하는 개수 비교해서
    // 전체개수보다 크거나 같다면, 진행가능
    // 선택할 수 있는 선택지 = 남은 개수 - 뽑아야하는 개수
    // 남은 개수 = arr.size-lastIndex-1
    // 뽑아야하는 개수  = 6 - str.length()/2
    val canChoose = (arr.size-lastIndex-1) - (6-cnt)

    for (i in 0 ..canChoose){
        bruteForce("${str}${arr[lastIndex+i+1]} ",
               arr, lastIndex+i+1,cnt+1)
    }
}