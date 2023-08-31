import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //numCountry 받음
        int numCountry = Integer.parseInt(br.readLine());

        //numCountry만큼 정수 받음
        st= new StringTokenizer(br.readLine());
        int[] countries = new int[numCountry];
        for (int i=0;i<numCountry;i++){
            countries[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(countries);

        //예산 받음
        int budget=Integer.parseInt(br.readLine());

        //평균보다 낮은 값들은, budget에서 빼준다.
        int avg=budget/numCountry;

        //110 120 140 150
        // 1st avg = 121
        for (int i =0;i<numCountry;i++){
            avg = budget/(numCountry-i);
            if (avg>=countries[i]){
                while (i<numCountry&&avg>=countries[i]){
                    budget-=countries[i];
                    i++;
                    if (i<numCountry&&avg<countries[i]) {
                        i--;
                        break;
                    }
                }
            }
            else {
                System.out.println(avg);
                return ;
            }
        }
        System.out.println(countries[numCountry-1]);



        //
    }
}
