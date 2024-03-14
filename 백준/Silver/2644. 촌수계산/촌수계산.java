import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람 수 n
        // int start, end
        // 관계개수 m
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<Integer> list[] = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) break;
            for (int next : list[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[node] + 1;
                }
            }
        }

        if (distance[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[end]);
        }

    }
}