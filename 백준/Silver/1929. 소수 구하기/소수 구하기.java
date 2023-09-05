
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M N 받기
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        //false : 소수
        //true : 소수가 아닌 정수
        arr[0]=true;
        arr[1]=true;
        StringBuilder sb = new StringBuilder();

        //i*i가 N이하일 때까지 판별하면 됨
        for (int i=2;i*i<=N;i++){
            //소수인 경우
            if (!arr[i]){
                //제곱부터 배수들을 지운다
                for (int j=i*i;j<=N;j=j+i){
                    arr[j]=true;
                }
            }
        }

        for (int i=M;i<=N;i++){
            if (!arr[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
