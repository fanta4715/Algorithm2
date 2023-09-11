

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxFloor;
    static int digit;
    static int maxFlip;
    static int nowFloor;
    static String nowFloorStr;static int[][] flip = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //maxFloor, digit, maxFlip, nowFloor
        maxFloor = Integer.parseInt(st.nextToken());
        digit = Integer.parseInt(st.nextToken());
        maxFlip = Integer.parseInt(st.nextToken());
        nowFloor = Integer.parseInt(st.nextToken());
        nowFloorStr=Integer.toString(nowFloor);
//        System.out.println(nowFloorStr.length());
        while (nowFloorStr.length()!=digit){
            nowFloorStr="0"+nowFloorStr;
//            System.out.println(nowFloorStr);
        }


        // 반전에 필요한 수를 배열에 저장함


        // 1부터 maxFloor까지 순회하면서
        // 자릿수 비교 -> 범위 내인지 확인
        int answer=0;
        for (int i=1;i<=maxFloor;i++){
            if (makeThisFloor(i))answer++;
        }
        //그럼 O(N)안에 풀리고, 완성!
        System.out.println(answer);
    }
    static boolean makeThisFloor(int target){

        //target을 String으로 둔갑시킴
        String str = Integer.toString(target);

        //digit이 4인데, str이 2라면,
        //처음 2번은 0이라고 생각하고 진행하고
        //후반 2번은 그냥 진행하면 됨.
        int cnt =0;
        int len = str.length();
        for (int i=0;i<digit-len;i++){
            int before = nowFloorStr.charAt(i)-'0';
            cnt+=flip[before][0];
        }
        for (int i=digit-len;i<digit;i++){
            int before = nowFloorStr.charAt(i)-'0';
            int after = str.charAt(i-(digit-len))-'0';
            cnt+=flip[before][after];
        }
        //그리고 K만큼 순회해서, 카운팅함
        //범위가 maxFlip이내, 1이상이면 true 리턴
        if (cnt>=1 && cnt<=maxFlip) return true;
        else return false;
    }
}
