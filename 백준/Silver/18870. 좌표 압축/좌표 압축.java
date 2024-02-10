import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] points = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        //해당 배열을 넣고, 압축된 좌표 배열을 반환하는 함수
        int[] pressedPoints = pressPoints(points);

        //print함수
        printPoints(pressedPoints);
    }

    private static int[] pressPoints(int[] points) {
        //각 인덱스마다 값을 알아내야 함.
        //Map을 사용해서 해당 값 : 해당 순위를 반환해서 바로 받으면 되지 않을까?
        Map<Integer, Integer> pressResult = new HashMap<>();

        //point를 정렬해야 함. priorityQueue를 활용하자.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int point : points) {
            pq.add(point);
        }

        //pq가 empty가 아닐때동안
        //하나씩 값을 제외하고, 해당 값을 넣어줌
        int rank = 0;
        int first = pq.poll();
        int before = first;
        pressResult.put(first, 0);

        while (!pq.isEmpty()) {
            //값을 뽑음
            int number = pq.poll();
            //before의 값과 현재 뽑은 값이 같다면. continue
            if (number == before) {
//                rank++;
                continue;
            }
            //rank를 추가해서 맵에 넣어주고, before값을 최신화시킴
            pressResult.put(number, ++rank);
            before = number;
        }

        int[] answer = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            answer[i] = pressResult.get(points[i]);
        }
        return answer;
    }

    public static void printPoints(int[] pressedPoints) {
        StringBuilder sb = new StringBuilder();
        for (int pressedPoint : pressedPoints) {
            sb.append(pressedPoint + " ");
        }
        System.out.println(sb);
    }
}
