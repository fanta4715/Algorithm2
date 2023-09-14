

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //houseCnt, wifiCnt 받기
        int houseCnt = Integer.parseInt(st.nextToken());
        int wifiCnt = Integer.parseInt(st.nextToken());

        //house 받기
        int[] house=new int[houseCnt];
        for (int i=0;i<houseCnt;i++){
            house[i]= Integer.parseInt(br.readLine());
        }

        //처음 집의 좌표 소팅
        Arrays.sort(house);

        //거리를 의미함
        int left=1, right=house[houseCnt-1]-house[0]+1;

        while(left<right){
            int mid = (left+right)/2;

            //공유기를 조금밖에 설치 못한다면, 왼쪽 범위를 살펴야함
            //distance가 1~house[i]-house[0]까지 있다고 하자.
            //공유기 설치 개수는 distance가 커질 수록 줄어든다
            // 5 5 3 3 3 1 1 이라고 하자
            //
            if (howManyWifiCnt(mid,house)<wifiCnt){
                right=mid;
            }

            //그냥 끝까지 오른쪽으로 가야함
            //같은 개수를 설치할 수 있다고 하더라도,
            //길이가 더 길어질 수 있음.
            //따라서 길이가 같은 경우에도 범위를 넓혀야 함.
            else {
                left=mid+1;
            }

        }
        System.out.println(left-1);
    }
    //distance 이상의 거리로 설치할 수 있는 최대 wifi 수
    static int howManyWifiCnt(int distance, int[]house){
        int cnt=1;
        int beforeLocation=house[0];

        //for house동안, beforeLocation과 distance이상 차이나는지 확인하고
        //cnt와 beforeLocation 초기화
        for (int i=1;i<house.length;i++){
            if (house[i]-beforeLocation>=distance) {
                cnt++;
                beforeLocation=house[i];
            }
        }

        return cnt;

    }
}
