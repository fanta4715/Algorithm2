
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val N = readLine().toInt()

    val A= IntArray(N)
    val B= IntArray(N)
    var st = StringTokenizer(readLine())
    for (i in 0 until N){
        A[i]=st.nextToken().toInt()
    }
    st=StringTokenizer(readLine())
    for (i in 0..N-1){
        B[i]=st.nextToken().toInt()
    }

    Arrays.sort(A)
    Arrays.sort(B)
    var sum = 0;
    for (i in 0 until N){
        sum+= A[i]*B[N-1-i]
    }
    println(sum)
}