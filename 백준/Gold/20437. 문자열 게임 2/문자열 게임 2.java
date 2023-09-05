

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    static int[] alpabet ;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //gameCnt =
        int gameCnt = Integer.parseInt(br.readLine());

        // 첫 번째와 마지막 글자가 같은 문자열을 찾아야 함
        // 일단 문자열을 읽어서 알파벳 개수를 파악해야 함
        // K개가 넘는 것들부터 다루면 됨
        alpabet = new int[26]; // a가 0
        for (int i=0;i<gameCnt;i++){

            //문자열 받아오기
            String str = br.readLine();
            int len = str.length();

            //정수 받아오기
            int K = Integer.parseInt(br.readLine());

            //배열 초기화
            clearAlpa();

            //for len : char 개수 카운팅하기
            for (char c : str.toCharArray()) alpabet[c-'a']++;

            // K개 이상의 알파벳을 리스트 업
            ArrayList<Character> arr = new ArrayList<>();
            for (int j=0;j<26;j++) if (alpabet[j]>=K) arr.add((char)(j+'a'));

            //투 포인터
            //조건 : 맨 앞, 맨 뒤 알파벳이 동일하며, K개를 포함
            //min max 둘 다 구할 것
            int min = 10001, max =-1;

            for (int j=0;j<arr.size();j++){
                int left = 0, right=0;
                char target = arr.get(j);
//                System.out.println(target);
                int cnt = 0;
                if (str.charAt(0)==target) cnt=1;
                while(right<len){
                    //1. 조건을 만족하는 경우(길이 판단, 알파벳 판단)
                    if (str.charAt(left)==target &&
                            str.charAt(right)==target &&
                            cnt==K){

                        //1번인덱스~3번인덱스라고 하면 -> 길이 3임
                        if (min>right-left+1) min=right-left+1;
                        if (max<right-left+1) max=right-left+1;

                        //조건을 만족했다면, left, right 둘 다 키우기
                        left++; right++;
                        if (right==len) break;
                        cnt-=1;
                        //if (str.charAt(left)==target) cnt++;
                        if (str.charAt(right)==target) cnt++;


                    }
                    //min max와 값 비교 해서 넣고 left 늘림
                    else{
                        if (cnt!=K) {
                            right++;
                            if (right==len) break;
                            if (str.charAt(right)==target) cnt++;
                        }

                        else if (str.charAt(left)!=target){
                            left++;

                        }

                    }
                    //case1 앞의 알파벳이 특정 알파벳이 아닌 경우 left++
                    //
                    //case2 마지막 알파벳이 특정 알파벳이 아닌 경우 right++
                    // else cnt++;
                }
            }
            if (min==10001 && max==-1) System.out.println(-1);
            else System.out.println(min+" "+max);


        }
    }
    static void clearAlpa(){
        for (int i=0;i<26;i++){
            alpabet[i]=0;
        }
    }

}
