import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int bro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //subin, bro받기
        int subin = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        //queue를 사용하자(BFS)
        //queue에 넣고난 후,
        Queue<Location> queue= new LinkedList<>();
        boolean visit[] =new boolean[100_001];
        int answer=100000;
        queue.add(new Location(subin,0));
        visit[subin]=true;
        //queue가 비어있지 않은 동안
        while(!queue.isEmpty()){
            // 1. poll함
            Location target = queue.poll();
            if (target.location==bro) answer=Math.min(target.distance,answer);
            //갈 수 있는 곳 탐색 (2배, 앞뒤)
            // 2. 값의 2배 4배 8배 ... -> distance통일시킴

            //범위가 되고
            if (!outOfIndex(target.location*2)&& !visit[target.location*2]){
                //방문을 안 했다면! 넣어줌(visit하고)
                visit[target.location*2]=true;
                queue.add(new Location(target.location*2,target.distance));
               // if (target.location*2==bro) answer= target.distance;
            }
                //방문했다면 넘어가기

            // 3. +-1거리로 distance+1해줌
            if (!outOfIndex(target.location-1) && !visit[target.location-1]) {
                visit[target.location-1]=true;
                queue.add(new Location(target.location-1,target.distance+1));
                //if (target.location-1==bro) answer= target.distance+1;
            }

            if (!outOfIndex(target.location+1)&& !visit[target.location+1]) {
                visit[target.location+1]=true;
                queue.add(new Location(target.location+1,target.distance+1));

                //if (target.location+1==bro) answer= target.distance+1;
            }

            // 4.

           // if (visit[bro]) break;
        }
        System.out.println(answer);
    }

    static boolean outOfIndex(int n){
        if (n<0 || n>=100001) return true;
        else return false;
    }

    public static class Location{
        int location;
        int distance;

        public Location(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

    }
}
