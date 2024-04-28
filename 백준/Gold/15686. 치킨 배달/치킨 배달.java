import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> kfcs;
    static List<int[]> houses;

    static int minTotalChickenLength = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N+1][N+1];
        kfcs = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i,j});
                } else if (map[i][j] == 2) {
                    kfcs.add(new int[]{i,j});
                }
            }
        }

        findTotalMinimunChickenLength(kfcs.size(), M, 0, new boolean[kfcs.size()]);
        System.out.println(minTotalChickenLength);
    }

    private static void findTotalMinimunChickenLength(int n, int r, int depth, boolean[] visited) {
        if (r == 0) {
            List<int[]> existedKfcs = new ArrayList<>();
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) existedKfcs.add(kfcs.get(i));
            }
            int totalChickenLength = 0;
            //해당 조합으로 집까지 최소거리 구하기
            for (int[] house : houses) {
                totalChickenLength += findChickenLength(house, existedKfcs);
            }

            if (totalChickenLength < minTotalChickenLength) {
                minTotalChickenLength = totalChickenLength;
            }
        }
        if (depth == n) {
            return ;
        }

        visited[depth] = true;
        findTotalMinimunChickenLength(n, r-1, depth+1, visited);

        visited[depth] = false;
        findTotalMinimunChickenLength(n, r, depth+1, visited);

    }

    private static int findChickenLength(int[] house, List<int[]> existedKfcs) {
        int min = 1_000_000_000;
        for (int[] kfc : existedKfcs) {
            int len = Math.abs(kfc[0]-house[0]) + Math.abs(kfc[1] - house[1]);
            if (len < min) min = len;
        }
        return min;
    }
}