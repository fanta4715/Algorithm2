import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//boj 1987
public class Main {
    static int ROW;
    static int COL;
    static int max = 0;
    static char[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static Set<Character> charSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //row, col받기
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        //for ROW, for COL map받기
        map = new char[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            String line = br.readLine();
            for (int j = 0; j < COL; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        //dfs로 갈 수 있는 가장 긴 거리 구하기
        charSet.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int row, int col, int length) {
        if (length > max) {
            max = length;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (isValidIndex(nextRow, nextCol)
            && !charSet.contains(map[nextRow][nextCol])) {
                charSet.add(map[nextRow][nextCol]);
                dfs(nextRow, nextCol, length+1);
            }
        }

        charSet.remove(map[row][col]);
    }

    private static boolean isValidIndex(int nextRow, int nextCol) {
        if (nextRow >=0 && nextRow < ROW
        && nextCol >=0 && nextCol < COL) {
            return true;
        }
        return false;
    }
}
