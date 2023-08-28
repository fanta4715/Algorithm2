import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //전체 사람 수 N 받기
        int N = Integer.parseInt(st.nextToken());

        //N만큼 덩치 받아서 배열에 넣기
        Size[] size= new Size[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            size[i]=new Size(w,h);
        }

        //for : N * N을 하면서
        for (Size s1 : size){
            int rank =1;
            for (Size s2 : size){
                if (s1.compareTo(s2)==1) rank++;

            }
            System.out.println(rank);
        }


        //

    }
    static class Size implements Comparable<Size>{
        int weight;
        int height;

        public Size(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Size o) {
            if (this.weight<o.weight && this.height<o.height) return 1;
            else return 0;

        }
    }
}
