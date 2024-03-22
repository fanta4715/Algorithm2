import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //N : 물품의 개수
        //K : 가방의 최대 weight
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // w : 물품의 weight 배열
        // v : 물품의 value 배열
        int[] w = new int[N+1];
        int[] v = new int[N+1];

        //이 table에 DP 넣을 것
        // K+1의 크기로 만드는 이유 : 1번 인덱스부터 쓰기 위함
        int[] dp = new int[K+1];

        //dp 배열 초기화
        for (int i=0;i<K+1;i++){
            dp[i]=0;
        }

        // w v의 안쓰는 0번 인덱스 초기화
        w[0]=0; v[0]=0;

        // 물품 N개의 w v 정보 채우기
        for (int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }


        for (int i=1;i<N+1;i++){ //물품의 인덱스
            for (int j=K;j>0;j--){ //dp의 인덱스 거꾸로
                if (j-w[i]<0) continue;
                else dp[j]=(dp[j]>dp[j-w[i]]+v[i])? dp[j]:dp[j-w[i]]+v[i];
            }
        }
        System.out.println(dp[K]);
    }

}
