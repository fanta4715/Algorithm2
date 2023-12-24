import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int N;
    static List<Consult> consults;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        consults = new ArrayList<>();
        consults.add(new Consult(0,0));
        //N개의 일정 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            consults.add(new Consult(time,price));
        }

        //dfs로 bruteforce하는것
        dfs(1,0);
        System.out.println(max);
    }

    public static void dfs(int day, int totalPrice) {
        //if day+day에 해당하는 T <= N이면 dfs돌리기
        //dfs돌리기
        if (day == N+1 ) {
            if (max < totalPrice) max = totalPrice;
            return;
        }
        int nextDay = day + consults.get(day).time;
        if (nextDay <= N+1) {
            dfs(nextDay, totalPrice+consults.get(day).price);
        }
        dfs(day+1, totalPrice);
    }
}



class Consult implements Comparable<Consult> {
    int time;
    int price;

    public Consult(int time, int price) {
        this.time = time;
        this.price = price;
    }

    @Override
    public int compareTo(Consult o) {
        return 0;
    }
}
