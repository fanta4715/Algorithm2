import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //N받기
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        //N번 받으면서 바로바로 처리
        for (int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            //출력한다.
            if (num==0) {
                if (pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }

            //넣는다
            else{
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
