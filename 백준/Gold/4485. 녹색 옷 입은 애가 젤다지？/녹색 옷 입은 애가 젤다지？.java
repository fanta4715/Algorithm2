import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][]cost;
    static int[][]distance;
    static int [][] visit ;

    static int[] dy = {-1,1,0,0};//상하좌우
    static int[] dx = {0,0,-1,1};

    static class point implements Comparable<point> {
        int row, col, cost;
        public point(int row, int col, int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }

        @Override
        public int compareTo(point o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st =null;
        int cnt =0;
        while (true){
            N = Integer.parseInt(br.readLine());
            if (N==0) break;

             cost = new int[N][N];
             distance = new int[N][N];
             visit = new int[N][N];

            for (int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                //cost , distance 초기화
                for (int j=0;j<N;j++){
                    cost[i][j]=Integer.parseInt(st.nextToken());
                    distance[i][j]=Integer.MAX_VALUE-1000;
                    visit[i][j]=0;
                }

            }
            cnt++; //출력문 cnt
            //dijkstra함수 구현 필요
            sb.append("Problem "+cnt+": "+dijkstra()+"\n"); //출력문
        }
        ;
        System.out.println(sb); //이게 어떤 식으로 되는거지?

        br.close();
    }

    public static int dijkstra(){
        // 우선순위 큐 생성
        PriorityQueue<point> pq = new PriorityQueue<point>();
        // 0,0에 해당하는 포인트 우선순위 큐에 삽입
        pq.offer(new point(0,0,cost[0][0]));
        // distance[0][0] =0으로 초기화
        //  visit[][]=1
        distance[0][0] =cost[0][0];
        visit[0][0]=1;

        /* while (!empty)
        우선순위 큐 하나 빼냄 + visit 1대입
        // 상 하 좌 우 순회
        //      distance[][]와 distance[이전][위치]+cost[이동][위치] 비교
        // min값 distance[][]대입 후 PQ에 넣음
        */
        while (!pq.isEmpty()){
            point p = pq.poll();
            visit[p.row][p.col]=1;

            for (int i=0;i<4;i++){
                int nextRow=p.row+dx[i];
                int nextCol=p.col+dy[i];

                //인덱스가 범위를 넘어가지 않을 때
                if (nextRow<N && nextRow>=0 && nextCol<N && nextCol>=0) {
                    if (distance[nextRow][nextCol]>distance[p.row][p.col]+cost[nextRow][nextCol]){
                        distance[nextRow][nextCol]=distance[p.row][p.col]+cost[nextRow][nextCol];
                        pq.offer(new point(nextRow,nextCol,distance[nextRow][nextCol]));
                    }
                }
            }

        }
        return distance[N-1][N-1];
        //






    }

}
