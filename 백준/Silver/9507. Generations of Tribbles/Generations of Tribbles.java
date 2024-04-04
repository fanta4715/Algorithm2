import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long[] dp = new long[68];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(koong(n)).append("\n");
        }
        System.out.println(sb);
    }
    
    private static long koong(int n) {
        if (n < 2) return 1L;
        if (n == 2) return 2L;
        if (n == 3) return 4L;
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = koong(n-1) + koong(n-2) + koong(n-3) + koong(n-4);
        return dp[n];
    }
    
}