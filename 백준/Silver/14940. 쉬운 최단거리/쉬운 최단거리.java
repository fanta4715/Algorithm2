import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //왼 위 오 아래
    static int dRow[]={0,-1,0,1};
    static int dCol[]={-1,0,1,0};
    static int row;
    static int col;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //row col 받기 -> 배열 초기 선언
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int map[][]= new int[row][col];
        int distance[][] = new int[row][col];
        boolean visit[][] = new boolean[row][col];
        int[] start = new int[2];
        //row * col 받기
        for (int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<col;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j]==2){
                    start[0]=i;
                    start[1]=j;
                }
                if (map[i][j]!=0) distance[i][j]=-1;
            }
        }
        Queue<int[]> queue= new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]]=0;
        visit[start[0]][start[1]]=true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            //근처 친구 탐색
            for (int i=0;i<4;i++){
                int nextRow = now[0]+dRow[i];
                int nextCol = now[1]+dCol[i];

                //범위도 안 나가고
                // 방문도 안 했을 때
                // 갈 수 있을 때
                if (!outOfIndex(nextRow,nextCol)
                && !visit[nextRow][nextCol]
                && map[nextRow][nextCol]!=0){
                    //방문체크하고
                    visit[nextRow][nextCol]=true;
                    //distance갱신하고
                    distance[nextRow][nextCol]=distance[now[0]][now[1]]+1;
                    //queue에 넣음
                    queue.add(new int[]{nextRow,nextCol});

                }

            }
        }
        StringBuilder sb =new StringBuilder();
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                sb.append(distance[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static boolean outOfIndex(int nowRow, int nowCol) {
        if (nowRow < 0 || nowRow >= row || nowCol < 0 || nowCol >= col)
            return true;
        else return false;
    }
}
