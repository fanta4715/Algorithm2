import java.io.*;
import java.util.*;

//위상정렬
public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int time[] = new int[n+1];
            dp = new int[n+1];
            for (int j=0; j<n+1; j++) {
                dp[j]=-1;
            }

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }
            List<Integer> givenList[] = new ArrayList[n+1];

            for (int j=0; j<n+1; j++) {
                givenList[j] = new ArrayList<>();
            }

            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                givenList[to].add(from);
            }

            int target = Integer.parseInt(br.readLine());

            int answer = calTime(time, givenList, target);
            System.out.println(answer);
        }
    }

    private static int calTime(int[] time, List<Integer>[] given, int target) {
        // give.get(a) = b : a가 b에게 준다.
        // given.get(a) == a로 화살표 보내는 애들
        int max = 0;

        if (dp[target] != -1) return dp[target];

        if (given[target].size() == 0) {
            dp[target] = time[target];
            return dp[target];
        }

        
        for (int from : given[target]) {
            max = Math.max(max, calTime(time, given, from) + time[target]);
        }
        dp[target] = max;
        return dp[target];
    }


}