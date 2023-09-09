

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//DP
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //towerCnt받기
        int towerCnt=Integer.parseInt(br.readLine());

        //towerCnt만큼 tower받기
        int[] towers = new int[towerCnt+1];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int max=0;
        for (int i=1;i<=towerCnt;i++){
            towers[i]=Integer.parseInt(st.nextToken());
            if (towers[i]>max) max = towers[i];
        }
        towers[0]=100_000_001;
        //
        //DP인가?
        // 내 왼편에서 받은 놈 vs 내 왼편 높이
//        // 1번 tower부터 비교하자. dp[0]과 dp[1]까지는 동일함!
//        int dp[]=new int[towerCnt+1];
//        dp[0]=0;
//        dp[1]=0;
//        StringBuilder sb= new StringBuilder("0");
//        for (int i=2;i<=towerCnt;i++){
//            if (towers[i] > towers[i-1]) dp[i]=dp[i-1];
//            else dp[i]=i-1;
//            sb.append(" ").append(dp[i]);
//
//        }
//        System.out.println(sb);

        //stack을 활용하자
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        StringBuilder sb= new StringBuilder("0");
        int [] answer= new int[towerCnt+1];
        //2번 건물부터 순회하면서 stack비교하고 넣기
        for (int i=2;i<=towerCnt;i++){
            //현재 인덱스의 탑이 더 크면, 그것보다 작은 애들 스택에서 빼낼 것
            while(towers[stack.peek()]<towers[i]) stack.pop();
            answer[i]=stack.peek();
            sb.append(" ").append(answer[i]);
            stack.add(i);
        }
        System.out.println(sb);
    }
}
