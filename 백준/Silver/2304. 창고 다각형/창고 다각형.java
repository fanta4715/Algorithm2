import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //pillarCnt받기
        int pillarCnt = Integer.parseInt(br.readLine());

        //for : pillarCnt -> pillar받기
        Pillar[] pillars = new Pillar[pillarCnt];
        for (int i=0;i<pillarCnt;i++){

            //배열에 Pillar 객체 저장
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pillars[i]=new Pillar(x,y);
        }

        //첫 값에서 부터 시작하자.
        //이후 기둥이 존재하지 않거나, 나보다 큰 기둥이 없다면
        //그 중 가장 큰 기둥에 붙이고 면적을 더해준다.
        //나보다 큰 기둥이 존재하면 바로 면적을 더해준다.
        //for : pillarCnt
        // for : i+1 to pillarCnt
        int area = 0;
        Arrays.sort(pillars);
        for (int i=0;i<pillarCnt;i++){
//            System.out.println("my pillar x,y = "+pillars[i].x+" "+pillars[i].y);
            int nIndex=0;
            int targetIndex=0;
            int max = 0;
            for (nIndex=i+1 ; nIndex<pillarCnt ; nIndex++){
//                System.out.println("target pillar x,y = "+pillars[nIndex].x+" "+pillars[nIndex].y);
                if (pillars[nIndex].y > pillars[i].y) {
                    targetIndex=nIndex;
                    break;
                }
                else {
                    if (pillars[nIndex].y>max) {
                        max=pillars[nIndex].y;
                        targetIndex=nIndex;
                    }
                }
            }

            //이후 기둥이 없는 경우, 마지막 기둥 y 더해줌
            if (targetIndex==0) {
                area+=pillars[i].y;
                break;
            }

            //targetIndex의 y값이 더 큰 경우
            // area += 현재 i의 y값 * (x 차이)
            // i를 targetIndex-1로 변경
            if (pillars[targetIndex].y>pillars[i].y){
                area+= pillars[i].y * (pillars[targetIndex].x-pillars[i].x);
                i=targetIndex-1;
            }
            //y값이 더 작은 경우
            //area += i의 y값 + (x 차이-1)*targetIndex의 y값
            else{
                area+=pillars[i].y;
                area+=pillars[targetIndex].y * (pillars[targetIndex].x-pillars[i].x-1);
                i=targetIndex-1;
            }
        }

        System.out.println(area);
    }
    static class Pillar implements Comparable<Pillar>{
        int x;
        int y;

        public Pillar(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pillar o) {
            return x-o.x;
        }
    }
}
