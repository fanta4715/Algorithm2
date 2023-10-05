

import java.util.StringTokenizer

fun main()=with(System.`in`.bufferedReader()){
    while(true){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        if (a==0 && b==0 && c==0) break;
        var max = Math.max(a,Math.max(b,c))
        if (a==b && b==c) println("Equilateral")
        else if (max>=a+b+c-max) println("Invalid")
        else if (a==b || a==c || b==c) println("Isosceles")
        else println("Scalene")
    }
}