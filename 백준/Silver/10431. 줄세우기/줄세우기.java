import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();

        //P받기
        int P = Integer.parseInt(st.nextToken());

        //P번 만큼 반복
        for (int i=0;i<P;i++)
        {
            // 한 줄 읽고, sb에 저장
            st = new StringTokenizer(br.readLine());
            count(st, sb);

        }

        //출력
        System.out.println(sb);
    }

    static void count(StringTokenizer st, StringBuilder sb){
        //테케 번호 넣기
        sb.append(st.nextToken()).append(" ");
        int count=0;
        //미는것은 귀찮으니, 배열에 넣되, 개수파악으로 밀리는 수를 파악하자.
        int arr[] = new int[20];
        for (int i=0;i<20;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            for (int j=0;j<i;j++){
                if (arr[j]>arr[i]) count++;
            }
        }
        sb.append(count).append("\n");


    }
}
