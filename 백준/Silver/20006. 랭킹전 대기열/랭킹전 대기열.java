
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/20006
public class Main {
    static Player room[][];
    static int numPlayer;
    static int capacity;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        //플레이어수 x 최대 인원 수로 방을 만들면 됨
        //그리고 row를 순회하면서 리더 방에 들어갈 수 있는 지 확인하며 ㄴ됨
        // 결과적으로 다 있는 경우에는, Started를 출력하고
        // 덜 있으면 waiting을 출력하면 됨

        //방 : room
        //레벨 : lv
        //아이디 : id
        //플레이어 : player, numPlayer

        //numPlayer과 maxPlayerInRoom 받음
        numPlayer = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());

        // numPlayer만큼, player lv와 id가 주어짐
        room= new Player[numPlayer][capacity];
        for (int i=0;i<numPlayer;i++){
            //들어갈 방이 있는 지 확인
            st=new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            Player player =new Player(lv,id);
            int[] index=canEnter(player);

            // 있다 -> 들어감 or 생성함
            room[index[0]][index[1]]=player;
            // 아예 들어갈 공간이 없다? 불가능
        }

        // 방을 순서대로 정원이 찼는지 확인하고 출력
        Player dummy = new Player(0,"zzzzzzzzzzzzzzzzzzzz");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<numPlayer;i++){
            if (room[i][0]==null) break;

            else{
                int count = howMany(i);
                if (count==capacity) sb.append("Started!").append("\n");
                else sb.append("Waiting!").append("\n");
                //정렬을 위해 더미를 넣어줄 것임. 어차피 맨 뒤로 가는 애들이라 상관없음
                // 5개가 최대인데, 3개가 들었다면, 3,4인덱스가 비어있음
                //
                for (int j=count;j<capacity;j++){
                    room[i][j]=dummy;
                }
                Arrays.sort(room[i]);

                for (int j=0;j<count;j++){
                    sb.append(room[i][j].lv).append(" ")
                            .append(room[i][j].id).append("\n");
                }

            }
        }
        System.out.println(sb);
    }

    static class Player implements Comparable<Player>{
        int lv;
        String id;

        public Player(int lv, String id) {
            this.lv = lv;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {
            return this.id.compareTo(o.id);
        }
    }
    static int howMany(int row){
        int count=0;
        for (int i=0;i<capacity;i++){
            if (room[row][i]!=null) count++;
            else break;
        }
        return count;
    }
    static int[] canEnter(Player player){
        //순회하면서, 배열에 들어있는 player의 레벨과 비교
        for (int i=0;i<numPlayer;i++){
            // if null이 나오면, 브레이크 ->
            if (room[i][0]==null) return new int[]{i,0};

            //비교했을 때, 범위 내이고, null자리가 존재하면 리턴
            if (room[i][0].lv-10<=player.lv && player.lv<=room[i][0].lv+10){
                for (int j=1;j<capacity;j++){
                    if (room[i][j]==null) return new int[]{i,j};
                }
            }
            else continue;
        }
        // 비교했을 때, -10과 +10 사이라면, 리턴
        // 아니면 continue


        return new int[]{-1,-1};
    }
}
