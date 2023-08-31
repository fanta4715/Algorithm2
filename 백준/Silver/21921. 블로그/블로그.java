import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // day, num받기
        int day = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());


        // day만큼 받기
        st=new StringTokenizer(br.readLine());
        int[] arr= new int[day];
        for (int i=0;i<day;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // max를 찾으면서, max와 같은 값이면 카운팅까지
        long sum=0;
        for (int i=0;i<num;i++){
            sum+=arr[i];
        }
        long max=sum;
        int countMax=1;

        for (int i=1; i<=day-num; i++){
            //i번째 값 빼고, i+num-1값 넣음
            sum=sum-arr[i-1]+arr[i+num-1];

            //sum이 max보다 크면, max와 maxCount초기화
            if (sum>max) {
                max=sum;
                countMax=1;
            }
            //sum이 max와 같으면, maxCount 증가
            else if (sum==max) countMax++;
            //sum이 max보다 작으면, continue
            else continue;
        }

        if (max==0) {
            System.out.println("SAD");
            return;
        }
        else{
            System.out.println(max);
            System.out.println(countMax);
        }
    }
}
