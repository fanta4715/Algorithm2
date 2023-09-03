

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //그리디 개삘인데?
        //도착순으로 정렬해놓고, 쓰면 될 듯.

        //shortCnt , roadLen 받기
        int shortCnt = Integer.parseInt(st.nextToken());
        int roadLen = Integer.parseInt(st.nextToken());
        int[] road = new int[roadLen+1];

        //road초기화
        for (int i=0;i<=roadLen;i++){
            road[i]=i;
        }

        //shortCnt만큼, 지름길 받기
        ArrayList<ShortCut> shortCuts = new ArrayList<>();
        for (int i=0;i<shortCnt;i++){
            st=new StringTokenizer(br.readLine());
            int start=  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int length=  Integer.parseInt(st.nextToken());

            //타지 않는 지름길 (도착지점이 목표지점 뒤 or 길이가 김) 제외
            if (end>roadLen || end-start<length) continue;

            shortCuts.add(new ShortCut(start,end,length));
        }

        Collections.sort(shortCuts);
        int realShortCnt = shortCuts.size();
        //10~30 : 2
        //10~40 : 1 이면 당연히 후자를 선택해야 함
        //그리디가 아닌가? 왜냐하면 그리디는 개수에만 치중했거든
        //근데 이건 가중치라는 개념이 도입되니까,
        //2개보다 나은 1개가 존재한다는 거지.
        //dp로 풀어야 하나?
        //length[150]을 구하면 됨
        //length[50]=length[49]+1 or
        for (int i=0;i<realShortCnt; i++){
            //end위치의 값이 기존이랑 비교헀을 때, 차이가 나는가?
            int end = shortCuts.get(i).end;
            int start = shortCuts.get(i).start;
            int length = shortCuts.get(i).length;
            if (road[end]>road[start]+length) {
                road[end]=road[start]+length;
                for (int j=end+1;j<=roadLen;j++){

                    road[j]=road[j-1]+1;
                }
            }

            else continue;
        }

        System.out.println(road[roadLen]);
    }

    static class ShortCut implements Comparable<ShortCut>{
        int start;
        int end;
        int length;

        public ShortCut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(ShortCut o) {
            if (end==o.end) return length-o.length;
            else return end-o.end;
        }
    }
}
