
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st= StringTokenizer(readLine());
    var a = st.nextToken().toLong();
    var b = st.nextToken().toLong();
    var c = st.nextToken().toLong();
        // 1 000 000 000 000
    println(a+b+c);
}