

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int numCnt[];
    static int maximum;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //슬라이딩 윈도우 문제 no
        //two pointer 문제 yes
        //+된 원소의 최대값이랑 연관있을 듯.
        int numLen = Integer.parseInt(st.nextToken());
        maximum = Integer.parseInt(st.nextToken());
        numCnt= new int[100001];

        //numLen만큼 받아서 배열에 넣기
        int[] num= new int[numLen];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<numLen;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }


        int left= 0;
        int right=0;
        int maxLen = 1;
        numCnt[num[0]]=1;
        boolean itsOk = true;
        while (true){

            //left부터 right까지 조건 확인
            //조건 만족하면, maxLen에 비교해서 넣고, right++;
            if (itsOk) {
                maxLen = Math.max(maxLen,right-left+1);
                right++;
                if (right>=numLen) break;
                else {
                    numCnt[num[right]]++;
                    if (numCnt[num[right]]>maximum) itsOk=false;
                }
            }
            //불만족시 left++;
            else {
                numCnt[num[left]]--;
                if (numCnt[num[left]]==maximum) itsOk=true;
                left++;
              //  System.out.println("i");
            }

            //if right가 numLen 이상이면 종료
            if (right>=numLen) break;
        }
        System.out.println(maxLen);
    }
//    static boolean itsOk(){
//        for (int i=0;i<10;i++){
//            if (numCnt[i]>maximum) return false;
//        }
//        return true;
//    }

}
