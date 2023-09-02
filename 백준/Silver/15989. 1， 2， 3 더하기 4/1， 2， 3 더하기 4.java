

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //1표현방법 : 1
        //2표현방법 : 1+1 , 2
        //3표현방법 : 1+1+1, 1+2, 3
        //4표현방법 : (1,3) (2,2) 1도배경우    -> 4
        //5표현방법 : (1 4), (2 3) 1도배경우   -> 6
        //표현방법은 (1을 도배하는 경우)를 제외하고 곱해서 더하고 나중에 +1
        //6 111111 11112 1113 1122
        //testNum 받음
        int testNum = Integer.parseInt(br.readLine());

        //dp로 10001개의 배열 완성
        int[][] express = new int[10001][4];
        express[1][1]=1;
        express[2][1]=1;
        express[2][2]=1;
        express[3][1]=1;
        express[3][2]=1;
        express[3][3]=1;


        //dp로 배열 생성
        //4 2번 13 22
        //5 2번
        //6 3번
        //7 3번
        for (int i=4;i<=10000;i++){
            express[i][1]=express[i-1][1];
            express[i][2]=express[i-2][1]+express[i-2][2];
            express[i][3]=express[i-3][1]+express[i-3][2]+express[i-3][3];
        }

        //for : testNum, n을 받고 출력
        StringBuilder sb =new StringBuilder();
        for (int i=0;i<testNum;i++){
            int target= Integer.parseInt(br.readLine());
            int result = express[target][1]+
                    express[target][2]+
                    express[target][3];

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
