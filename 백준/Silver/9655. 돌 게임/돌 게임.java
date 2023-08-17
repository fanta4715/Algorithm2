import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 1일때 SK
    // 2일때 CY
    // 3일때 SK
    // 4일때 CY
    // 5일때 SK
    // 6일때 CY
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N%2==0) System.out.println("CY");
        else System.out.println("SK");
    }
}
