

import java.util.StringTokenizer
lateinit var visited:BooleanArray
lateinit var edge:Array<ArrayList<Int>>
fun main()=with(System.`in`.bufferedReader()){
    //vNum , eNum받기
    var st= StringTokenizer(readLine())
    val vNum = st.nextToken().toInt()
    val eNum = st.nextToken().toInt()

    //N+1크기의 정점배열 만들기
    edge = Array(vNum+1,{ArrayList<Int>()})
    visited=BooleanArray(vNum+1,{false})
    //eNum만큼 받기
    //kruskal X
    repeat(eNum){
        //start랑 end받기
        //start에 end넣고, end에 start넣기
        st= StringTokenizer(readLine())
        val start=st.nextToken().toInt()
        val end=st.nextToken().toInt()
        edge[start].add(end)
        edge[end].add(start)
    }

    //for N N 으로 모든 요소 돌면서
    //visit안했으면 dfs하고 answer++
    var answer=0
    for (i in 1 until vNum+1){
        if (!visited[i]) {
            dfs(i)
            answer++
        }

    }
    //그냥 edge다 받아서 dfs로 구하자..
    println(answer)
}

fun dfs(now:Int){
    visited[now]=true

    //edge[now]에서 갈 수 있는 모든 friend들에 대해서
    //visit하지 않았다면 바로 dfs실행
    for (i in 0 until edge[now].size){
        val friend=edge[now][i]
        if (!visited[friend]) dfs(friend)
    }

}