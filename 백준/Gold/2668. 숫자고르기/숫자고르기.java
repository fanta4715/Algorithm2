
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    static boolean visited[];
    static boolean visited2[];
    static ArrayList<Integer>[] adjList1;
    static ArrayList<Integer>[] adjList2;
    static ArrayList<Integer> result;
    static ArrayList<Integer> tempResult;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //코사라주로 SCC찾고
        // n=1 to 7까지 dfs 돌리면서 stack에 넣음
        // stack에서 빼내면서, 다시 dfs돌리고, arraylist에 넣음
        //리버스를 표현하는 방법? -> ArrayList 배열 만들기
        //ArrayList에 넣은 다음
        //Sort해서 size와 같이 출력하면 됨

        //N받음
        int N = Integer.parseInt(br.readLine());

        //배열 생성

        visited = new boolean[N+1];
        visited2 = new boolean[N+1];
        adjList1 = new ArrayList[N+1];
        adjList2 = new ArrayList[N+1];
        stack = new Stack<>();


        for (int i=0;i<=N;i++){
            adjList1[i]=new ArrayList<>();
            adjList2[i]=new ArrayList<>();
        }

        //for N 입력받음
        for (int i=1;i<=N;i++){
            int num =Integer.parseInt(br.readLine());
            adjList1[i].add(num);
            adjList2[num].add(i);
        }

        //1st DFS with node[]
        for (int i=1;i<=N;i++){
            if (!visited[i]) dfs1(i);
        }

        result=new ArrayList<>();
        //2nd DFS with adjList[]
        while (!stack.isEmpty()){
            tempResult=new ArrayList<>();
            int node = stack.pop();
            if (!visited2[node]) dfs2(node);
            else continue;
            //scc의 크기가 1이면, 넣지 않음. 대신 loop 경우는 제외
            if (tempResult.size()==1 && adjList1[node].get(0)!=node) continue;

            //tempResult의 친구를 다 넣음
            for (int i=0;i<tempResult.size();i++) {
                result.add(tempResult.get(i));
            }

        }

        Collections.sort(result);
        StringBuilder sb =new StringBuilder();
        sb.append(result.size()).append("\n");

        for (int i=0;i<result.size();i++){
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);




    }
    static void dfs1(int node){
        // visited하고,
        visited[node]=true;

        // 친구가 있으면, dfs
        int friend = adjList1[node].get(0);
        if (!visited[friend]) dfs1(friend);

        // 종료
        stack.push(node);
    }

    static void dfs2(int node){
        //
        visited2[node]=true;

        //친구있으면 dfs
        for (int i=0;i<adjList2[node].size();i++){
            int friend=adjList2[node].get(i);
            if (!visited2[friend]) dfs2(friend);
        }

        //tempResult에 넣기
        tempResult.add(node);
    }
}
