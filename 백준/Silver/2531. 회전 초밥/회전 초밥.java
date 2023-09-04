

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //접시 수 : dishCnt
        //초밥 가짓 수 : sushiDiv
        //연속해서 먹는 수 : k
        //쿠폰 번호 : coupon
        int dishCnt=  Integer.parseInt(st.nextToken());
        int sushiDiv=  Integer.parseInt(st.nextToken());
        int k=  Integer.parseInt(st.nextToken());
        int coupon=  Integer.parseInt(st.nextToken());

        int div[] = new int[sushiDiv+1];
        div[coupon]++;
        int dish[]=new int[dishCnt];
        int max = 1;
        //dishCnt만큼 배열에 넣음
        for (int i=0;i<dishCnt;i++){
            dish[i]=Integer.parseInt(br.readLine());
        }
        //슬라이딩 윈도우로 초밥 가짓수 카운팅하면 될 듯
        //초기 세팅
        for (int i=0;i<k;i++){
            div[dish[i]]++;
            if (div[dish[i]]==1) max++;
        }

//        System.out.println("first : "+min);
        int nowDiv=max;
        for (int i=1;i<dishCnt;i++){
            int left = i-1;
            int right= (i+k-1)%dishCnt;
            div[dish[left]]--;
            if (div[dish[left]]==0) nowDiv--;
            div[dish[right]]++;
            if (div[dish[right]]==1) nowDiv++;
//            System.out.println(i+"~"+right+":"+nowDiv);
            if (nowDiv>max)max=nowDiv;
        }

        System.out.println(max);
    }
}
