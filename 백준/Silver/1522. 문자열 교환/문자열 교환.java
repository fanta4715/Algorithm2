

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //문자열 받음
        String str = br.readLine();
        int len = str.length();
        int aCnt =0;
        //슬라이딩 윈도우
        //a의 개수를 다 구함
        for (char c : str.toCharArray()){
            if (c=='a') aCnt++;
        }

        //a의 개수만큼 부분배열을 추출해서, b의개수를 구함
        int bCnt=0;
        int bMin=0;

        //첫 창문의 bCnt구하기
        for (int i=0;i<aCnt;i++){
            if (str.charAt(i)=='b') bCnt++;
        }
        bMin=bCnt;

        for (int i=1;i<len;i++){
            //i부터 i+aCnt-1까지 추출
            //앞전 노드 빼고, 뒷 노드 더해주면 됨
            int first = (i-1+len)%len;
            int last = (i+aCnt-1)%len;
            if (str.charAt(first)=='b') bCnt--;
            if (str.charAt(last)=='b') bCnt++;

            bMin=Math.min(bCnt,bMin);
        }
        System.out.println(bMin);
    }
}
