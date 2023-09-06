
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        //1은 왼쪽에서부터 지우고
        //0은 오른쪽에서부터 지우면 될 듯
        StringBuilder sb =new StringBuilder();

        int len = str.length();
        int zeroCnt =0;
        int oneCnt = 0;
        //1. 1의 개수와 0의 개수 파악
        for (int i=0;i<len;i++){
            if (str.charAt(i)=='0') zeroCnt++;
            else oneCnt++;
        }
        boolean[] delete=new boolean[len];
        int leftCnt =0;
        //2. for 0 to len , 1지우기
        for (int i=0;i<len;i++){
            //charAt(i)=='1'이면 지우기
            if (str.charAt(i)=='1') {
                delete[i]=true;
                leftCnt++;
            }
            //그리고 leftCnt가 oneCnt/2와 같으면 break
            if (leftCnt==oneCnt/2) break;
        }
        int rightCnt=0;
        //3. for 0 to zeroCnt
        for (int i=len-1;i>=0;i--){
            //charAt(i)=='1'이면 지우기
            if (str.charAt(i)=='0') {
                delete[i]=true;
                rightCnt++;
            }
            //그리고 leftCnt가 oneCnt/2와 같으면 break
            if (rightCnt==zeroCnt/2) break;
        }

        //sb에 true가 아닌 애들 넣기
        for (int i=0;i<len;i++){
            if (!delete[i]) sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
