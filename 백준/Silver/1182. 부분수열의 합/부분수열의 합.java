import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main{
    static int count = 0;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            comb(new boolean[n], arr, 0, n, i, s);
        }
        System.out.println(count);
    }

    private static void comb(boolean visited[], int arr[], int depth, int n, int r, int s) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) sum+=arr[i];
            }
            if (sum == s) count++;
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(visited, arr, depth+1, n, r-1, s);
        visited[depth] = false;
        comb(visited, arr, depth+1, n, r, s);
    }

}