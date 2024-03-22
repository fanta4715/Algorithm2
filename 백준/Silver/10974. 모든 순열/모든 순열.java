import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        perm(new boolean[n], new int[n], arr, 0, n,n);

    }

    private static void perm(boolean[] visited, int[] output, int arr[], int depth, int n, int r) {
        if (depth == r) {
            for (int i=0; i<depth; i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(visited, output, arr, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}