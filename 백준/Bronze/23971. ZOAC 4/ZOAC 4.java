import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        //H W N M받기
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //H/(N+1) + 1 or 0
        int row = H/(N+1);
        if (H%(N+1)!=0) row++;
        //W/M + 1 or 0
        int col =W/(M+1);
        if (W%(M+1)!=0) col++;
        System.out.println(row*col);
    }
}
