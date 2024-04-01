/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
//    static List<int[]> babyTreeSpot = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int robot[][] = new int[N+1][N+1];
        //N M K

        Land[][] land = new Land[N+1][N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                land[i][j] = new Land();
            }
        }
        //forN 양분값 map
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                robot[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //forM 나무
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            land[x][y].addTree(age);
        }
        //for K 1년이 지남
        for (int i=0; i<K; i++) {
            //  봄
            for (int x = 1; x <= N; x++) {
                for (int y=1; y<=N; y++) {
                    land[x][y].spring();
                }
            }
            //여름
            for (int x = 1; x<=N; x++) {
                for (int y=1; y<=N; y++) {
                    land[x][y].summer();
                }
            }
            //가을
            for (int x = 1; x<=N; x++) {
                for (int y=1; y<=N; y++) {
                    int addNum = land[x][y].fall();
                    if (addNum ==0) continue;
                    for (int d = 0; d<8; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (validIndex(nx,ny, N)) {
//                            babyTreeSpot.add(new int[]{nx, ny});
                            land[nx][ny].addTree(1);
                        }
                    }
                }
            }

            //겨을
            for (int x = 1; x<=N; x++) {
                for (int y=1; y<=N; y++) {
                    land[x][y].winter(robot[x][y]);
                }
            }
        }

        //tree 남아있는거 구하기
        int answer = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
//                System.out.println("i, j : "+i+" "+j+" size : "+land[i][j].list.size());
                answer+=land[i][j].list.size();
            }
        }
        System.out.println(answer);
    }

    private static boolean validIndex(int nx, int ny, int N) {
        return nx>0 && nx<=N && ny>0 && ny<=N;
    }
}

class Land{
    PriorityQueue<Integer> list = new PriorityQueue<>();
    int deadNut = 0;
    int nut = 5;

    public void spring() {
        PriorityQueue<Integer> newList = new PriorityQueue<>();
        while (!list.isEmpty()) {
            int youngTree = list.poll();
            if (youngTree > nut) {
                list.add(youngTree);
                break;
            }
            nut -= youngTree;
            youngTree++;
            newList.add(youngTree);
        }
        //list에 남은 개수 = 죽은 나무 개수
        while (!list.isEmpty()) {
            int deadTree = list.poll();
            nut = nut + deadTree/2;
        }

        list = newList;
    }

    public void summer(){
        nut+= deadNut;
        deadNut = 0;
    }

    public int fall() {
        //5의 배수 개수의 나무
        int cnt = 0;
        for (int tree : list) {
            if (tree % 5 == 0) cnt++;
        }
        return cnt;
    }

    public void winter(int surplus) {
        nut+=surplus;
    }
    public void addTree(int tree) {
        list.add(tree);
    }
}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;
    public static int[][] add;
    public static int[][] map;
    public static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }

    }
    public static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    public static Queue<Tree> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        add = new int[n][n];
        map = new int[n][n];
        q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }



        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            q.add(new Tree(x-1, y-1, age));
        }

        // 초반에만 정렬하면 더이상 정렬 필요 x
        Collections.sort((List<Tree>)q);

        for(int a=0;a<k;a++) {
            ArrayList<Tree> dead = new ArrayList<>();
            // 봄
            int q_len = q.size();

            while(q_len-- > 0) {
                Tree tree = q.poll();
                if(tree.age <= map[tree.x][tree.y]) {
                    map[tree.x][tree.y] -= tree.age;
                    q.add(new Tree(tree.x, tree.y, tree.age+1));
                } else {
                    dead.add(new Tree(tree.x, tree.y, tree.age));
                }
            }



            // 여름
            for(Tree tree:dead) {
                map[tree.x][tree.y] += tree.age/2;
            }
            ArrayList<Tree> parent = new ArrayList<>();
            q_len = q.size();
            // 가을
            while(q_len-- > 0) {
                Tree tree = q.poll();
                parent.add(tree);
                if(tree.age % 5 == 0) {
                    for(int d=0;d<8;d++) {
                        int nx = tree.x + dx[d];
                        int ny = tree.y + dy[d];
                        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                            q.add(new Tree(nx, ny, 1));
                        }
                    }
                }
            }

            for(Tree tree:parent) {
                q.add(tree);
            }

            // 겨울
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    map[i][j] += add[i][j];
                }
            }



        }


        System.out.println(q.size());
    }

}