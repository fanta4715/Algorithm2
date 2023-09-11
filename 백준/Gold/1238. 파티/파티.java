

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node> arrayList[] ;
    static int studentNum;
//    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //studentNum, roadNum, destination
        studentNum = Integer.parseInt(st.nextToken());
        int roadNum = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        //for roadNum
        //arrayList에 넣기
        arrayList=new ArrayList[studentNum+1];
//        visit=new boolean[studentNum+1];
        for (int i=1;i<studentNum+1;i++){
            arrayList[i]=new ArrayList<>();
        }

        for (int i=0;i<roadNum;i++){
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arrayList[start].add(new Node(end,dis));
        }
        // 한 지점에서 목적지까지 가는 dijkstra 구현 후  N번 반복
        int[] go = new int[studentNum+1];
        int[] back = new int[studentNum+1];
        int[] total = new  int[studentNum+1];

        //for studentNum : dijkstra활용한 최소값 구하기
        for (int i=1;i<=studentNum;i++){
            go[i]=dijkstra(i, destination);
        }

        // 일단 목적지에서 다른 곳으로 가는 경우는 dijkstra한 번에 가능
        dijkstra2(destination,back);
        for (int i=1;i<=studentNum;i++){
            total[i]=go[i]+back[i];
        }
        Arrays.sort(total);
        System.out.println(total[studentNum]);
    }

    static void dijkstra2(int start, int[] back){
        //start에서 des까지 거리를 구하면 return할 거임
        PriorityQueue<Node> pq =new PriorityQueue<>();
        boolean visit[]=new boolean[studentNum+1];

        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowStart=now.end;
            if (visit[nowStart]) continue;
            else visit[nowStart]=true;
            int nowDistance= now.distance;
            back[nowStart]=nowDistance;
            //now근처에 갈 친구가 있는지 탐색
            for (int i=0;i<arrayList[nowStart].size();i++){
                Node nextNode = arrayList[nowStart].get(i);
                int nextDistance = nextNode.distance;
                //방문 안 했으면 pq에 다 담아놓음
                if (!visit[nextNode.end]) pq.add(new Node(nextNode.end,nextDistance+nowDistance));
            }
        }

    }
    static int dijkstra(int start, int destination){
        //start에서 des까지 거리를 구하면 return할 거임
        PriorityQueue<Node> pq =new PriorityQueue<>();
        boolean visit[]=new boolean[studentNum+1];
        int answer=0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowStart=now.end;
            if (visit[nowStart]) continue;
            else visit[nowStart]=true;

            //종료조건
            if (nowStart==destination) {
                answer= now.distance;
                break;
            }
            int nowDistance= now.distance;
            //now근처에 갈 친구가 있는지 탐색
            for (int i=0;i<arrayList[nowStart].size();i++){
                Node nextNode = arrayList[nowStart].get(i);
                int nextDistance = nextNode.distance;
                //방문 안 했으면 pq에 다 담아놓음
                if (!visit[nextNode.end]) pq.add(new Node(nextNode.end,nextDistance+nowDistance));
            }
        }
        return answer;
    }

    static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }
}
