

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //A, B받기
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //0~B까지 총 1의 개수 - 0~A-1까지 총 1의 개수
        System.out.println(findOneCnt(B)-findOneCnt(A-1));
    }

    static long findOneCnt(long B){
        //B라는 뜻은 0~B까지를 탐색하라는 뜻이므로,
        //B+1개를 기준으로 해야 한다.
        // 첫번째 자리 (= 맨 뒷자리)
        long divisor=2;
        long cnt=0;
        while (B+1>=divisor){
            cnt+=(B+1)/divisor*(divisor/2);
            if ((B+1)%divisor > divisor/2) cnt+= (B+1)%divisor-divisor/2;
            divisor*=2;
        }
        if ((B+1)%divisor > divisor/2) cnt+= (B+1)%divisor-divisor/2;
        return cnt;
    }
}
