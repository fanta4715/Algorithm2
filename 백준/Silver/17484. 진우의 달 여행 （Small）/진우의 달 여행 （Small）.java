

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // / | \
    static int[] dRow = {1,1,1};
    static int[] dCol = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //row col 받기
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        //for row
        // for col 동안 map받기
        int map[][]=new int[row][col];
        for (int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<col;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //Dijkstra
        //Dijkstra는 갈 수 있는 경우의 수와 최소 경우의 수를 확실하게 구할 수 있음
        // 4단계를 거쳐가더라도, 최소인 경우를 구할 수 있음
        // 선택이 된다는 것은, 그것보다 적은 값에서 이 노드로 올 수 없다는 뜻이기 때문.
//        PriorityQueue를 활용하자
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance-o2.distance;
            }
        });
        boolean visit[][] =new boolean[row][col];

        //초기 넣기
        for (int i=0;i<col;i++) {
            pq.add(new Node(0,i,-1,map[0][i]));
        }
        while(!pq.isEmpty()){
            Node preNode = pq.poll();
//            if (visit[preNode.row][preNode.col]==true) continue;
//            visit[preNode.row][preNode.col]=true;

            //종료조건 2
            if (preNode.row==row-1) {
                System.out.println(preNode.distance);
                return;
            }
//            System.out.println("s");
            //preNode에서 근처 친구들 다 pq에 추가.
            for (int i=0;i<3;i++){
                int nextRow= preNode.row+dRow[i];
                int nextCol= preNode.col+dCol[i];

                //범위가 초과함
                if (outOfIndex(nextRow,nextCol,row,col)) continue;
                if (preNode.noDir==i) continue;
                pq.add(new Node(nextRow,nextCol,i, preNode.distance+map[nextRow][nextCol]));
                //preNode의 distance+map으로 넣어둠
            }

        }

    }

    static boolean outOfIndex(int nRow, int nCol, int row, int col) {
        if (nRow<0 || nRow>=row || nCol<0 || nCol>=col) return true;
        else return false;
    }

    static class Node{
        int row;
        int col;
        int noDir; // 0 1 2로 가능
        int distance;

        public Node(int row, int col, int noDir, int distance) {
            this.row = row;
            this.col = col;
            this.noDir = noDir;
            this.distance = distance;
        }
    }
}
