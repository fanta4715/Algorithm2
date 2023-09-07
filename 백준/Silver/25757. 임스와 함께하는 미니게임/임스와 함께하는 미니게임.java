

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/25757
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // N과 game받음
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int playerNum=0;
        if (game=='Y') playerNum=2;
        else if (game=='F') playerNum=3;
        else playerNum=4;

        //for : N  set에 다 넣기
        Set<String> set =new HashSet<>();
        for (int i=0;i<N;i++){
            set.add(br.readLine());
        }
        //set.size()/game해당...
        System.out.println(set.size()/(playerNum-1));
    }
}
