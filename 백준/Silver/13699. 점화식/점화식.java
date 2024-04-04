import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[36];
        dp[0] = 1;
        for (int i=1; i<36; i++) {
            long num = 0;
            for (int j=0; j<i; j++) {
                num += dp[j]*dp[i-1-j];
            }
            dp[i] = num;
        }

        System.out.println(dp[n]);
    }


}