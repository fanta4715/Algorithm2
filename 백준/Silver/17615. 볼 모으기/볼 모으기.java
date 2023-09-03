

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //int strlen받기
        int strlen = Integer.parseInt(br.readLine());

        //str받기
        String str = br.readLine();

        //빨간색을 구하는 경우랑
        //파란색을 구하는 경우를 둘 다 구해서 비교하자
        boolean leftRed=false, rightRed=false;
        int leftLen=1, rightLen=1;
        int redCnt=0,blueCnt=0;
        if (str.charAt(0)=='R') leftRed=true;
        if (str.charAt(strlen-1)=='R') rightRed=true;
        for (int i=1;i<strlen;i++){
            if (str.charAt(i)==str.charAt(i-1)) leftLen++;
            else break;
        }
        for (int i=strlen-2;i>=0;i--){
            if (str.charAt(i+1)==str.charAt(i)) rightLen++;
            else break;
        }

        for (int i=0;i<strlen;i++){
            if (str.charAt(i)=='R') redCnt++;
            else blueCnt++;
        }

        int leftMin, rightMin;
        if (leftRed){
            leftMin = redCnt-leftLen;
        }
        else leftMin=blueCnt-leftLen;

        if (rightRed){
            rightMin = redCnt-rightLen;
        }
        else rightMin = blueCnt-rightLen;
        int allMove = Math.min(redCnt,blueCnt);
        System.out.println(Math.min(Math.min(leftMin,rightMin),allMove));

        //빨 왼, 빨 오, 파 왼, 파 오 존재.


    }
}
