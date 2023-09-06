
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //우선순위 큐
        //삽입, 삭제, : logN
        //서칭 : N

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //N받기
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue=new PriorityQueue<>();

        //첫 줄은 전부 큐에 넣어줌

        // 이후 줄부터, 하나씩 빼고 넣어줌
        // 왜냐하면 다음부터 들어가는 값은 무조건 꼴등이 아님!
        //for N*N :
        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                int temp = Integer.parseInt(st.nextToken());
                if (queue.size()==N){
                    if (queue.peek()<temp) {
                        queue.poll();
                        queue.add(temp);
                    }
                }
                else queue.add(temp);
            }
        }

        System.out.println(queue.poll());
    }
}
