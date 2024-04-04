import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i+1] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n+1];
        dp[1] = arr[1];
        for (int i=2; i<=n; i++) {
            dp[i] = arr[i] + dp[i-1];
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end]-dp[start-1]);
        }
    }

}