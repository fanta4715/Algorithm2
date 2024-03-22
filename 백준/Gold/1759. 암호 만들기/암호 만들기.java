import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        char[] alpa = new char[c];

        for (int i=0; i<c; i++) {
            alpa[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpa);
        comb(new boolean[c], alpa, 0, c, l);

    }

    private static void comb(boolean[] visit, char[] alpa, int depth, int n, int r) {
        if (r == 0) {
            StringBuilder sb =new StringBuilder();
            for (int i=0; i<n; i++) {
                if (visit[i]) sb.append(alpa[i]);
            }
            if (!vaildOne(sb.toString()) || !vaildTwo(sb.toString())) return;
            System.out.println(sb.toString());
            return;
        }

        if (depth == n) return;
        visit[depth] = true;
        comb(visit,alpa,depth+1, n,r-1);
        visit[depth] = false;
        comb(visit, alpa, depth+1, n, r);
    }

    private static boolean vaildOne(String str) {
        Set<Character> set = new HashSet<>(Set.of('a','e','i','o','u'));
        for (int i =0; i<str.length(); i++) {
            if (set.contains(str.charAt(i))) return true;
        }
        return false;
    }

    private static boolean vaildTwo(String str) {
        Set<Character> set = new HashSet<>(Set.of('a','e','i','o','u'));
        int count = 0;
        for (int i =0; i<str.length(); i++) {
            if (!set.contains(str.charAt(i))) count++;
        }
        return count >= 2;
    }
}