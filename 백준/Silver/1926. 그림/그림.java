import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//boj
public class Main {
    private static int[] dRow = {1,0,-1,0};
    private static int[] dCol = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int paper[][] = new int[row][col];
        boolean visited[][] = new boolean[row][col];
        for (int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<col; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int max = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {

                    max = Math.max(max, bfs(paper, visited, i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
        return;
    }

    private static int bfs(int[][] map, boolean[][] visited, int row, int col) {

        //Queue에 담기
        //while queue가 들어있는 동안
        //  근처에 1이고, visit하지 않은 친구 넣기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            area++;
            int[] element = queue.poll();
            int cRow = element[0];
            int cCol = element[1];
            for (int i=0; i<4; i++) {
                int nRow = cRow +  dRow[i];
                int nCol = cCol +  dCol[i];
                if (isOutOfIndex(map, nRow, nCol) && !visited[nRow][nCol] &&map[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }

        //
        return area;
    }

    private static boolean isOutOfIndex(int[][] map,int row, int col) {
        return row<map.length && row>=0 && col<map[0].length && col>=0;
    }
}
