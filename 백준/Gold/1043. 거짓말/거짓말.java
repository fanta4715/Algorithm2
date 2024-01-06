import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//boj 1043
public class Main {
    static boolean[] know;
    static ArrayList<Integer>[] attendees;
    static ArrayList<Integer>[] partyAttendees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //peopleNum partyNum 받기
        int peopleNum = Integer.parseInt(st.nextToken());
        know = new boolean[peopleNum + 1];
        int partyNum = Integer.parseInt(st.nextToken());

        //knowerNum 받기
        st = new StringTokenizer(br.readLine());
        int knowerNum = Integer.parseInt(st.nextToken());
        if (knowerNum != 0) {
            for (int i = 0; i < knowerNum; i++) {
                int knower = Integer.parseInt(st.nextToken());
                know[knower] = true;
            }
        }

        //attendees 초기화
        attendees = new ArrayList[peopleNum + 1];
        partyAttendees = new ArrayList[partyNum];
        attendees[0] = new ArrayList<>();
        for (int i = 1; i <= peopleNum; i++) {
            attendees[i] = new ArrayList<>();
        }
        for (int i=0;i<partyNum;i++){
            partyAttendees[i] = new ArrayList<>();
        }

        //attendeeNum, attendee받기
        for (int i = 0; i < partyNum; i++) {
            st = new StringTokenizer(br.readLine());
            linkAttendee(st, i);
        }

        //bfs로 다 찍어보기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= peopleNum; i++) {
            if (know[i]) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int person = queue.poll();
            //person의 친구 찾기
            for (int i=0; i<attendees[person].size(); i++){
                //know가 false이면 넣음
                int friend = attendees[person].get(i);
                if (!know[friend]) {
                    queue.add(friend);
                    know[friend]=true;
                }
            }

        }

        //false개수 파악
        System.out.println(countParty(partyNum));
    }

    private static int countParty(int partyNum) {
        int count = 0;
        for (int i = 0; i < partyNum; i++) {
            if (!know[partyAttendees[i].get(0)]) {
                count++;
            }
        }
        return count;
    }

    private static void linkAttendee(StringTokenizer st, int partyIndex) {
        int attendeeNum = Integer.parseInt(st.nextToken());
        int prePersonNum = Integer.parseInt(st.nextToken());
        partyAttendees[partyIndex].add(prePersonNum);

        int nowPersonNum;
        for (int i = 0; i < attendeeNum - 1; i++) {
            nowPersonNum = Integer.parseInt(st.nextToken());
            attendees[nowPersonNum].add(prePersonNum);
            attendees[prePersonNum].add(nowPersonNum);
            partyAttendees[partyIndex].add(nowPersonNum);
            prePersonNum = nowPersonNum;
        }
    }
}
