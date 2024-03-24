import java.io.*;
import java.util.*;

//dp
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][3];
        int dp[][] = new int[n][3];

        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<3; i++) {
            dp[0][i] = map[0][i];
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<3; j++) {
                if (j==0) dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][j];
                else if (j==1) dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][j];
                else if (j==2) dp[i][j] = Math.min(dp[i-1][1], dp[i-1][0]) + map[i][j];
            }
        }

        int min = 100_000_000;
        for (int i=0; i<3; i++) {
            min = Math.min(min,dp[n-1][i]);
        }
        System.out.println(min);

    }

}