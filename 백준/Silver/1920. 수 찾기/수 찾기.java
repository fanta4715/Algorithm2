import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] search = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = findAnswer(M, numbers, search);
        printAnswer(answer);
    }

    private static int[] findAnswer(int m, int[] numbers, int[] search) {
        int[] answer = new int[m];

        //numbers 정렬
        Arrays.sort(numbers);

        //for serach : binarySearch로 1 or 0 받음, 해당 값을 인덱스에 넣음
        for (int i = 0; i < m; i++) {
            int first = 0;
            int last = numbers.length-1;
            answer[i] = binarySearch(numbers, search[i], first, last);
        }
        return answer;
    }

    private static int binarySearch(int[] numbers, int search, int first, int last) {

        if (first < 0 || last >= numbers.length || first > last) {
            return 0;
        }

        //0 4
        //3 4
        //4 4
        int mid = (first + last) / 2;

        if (numbers[mid] == search) return 1;
        else if (numbers[mid] < search) {
            return binarySearch(numbers, search, mid+1, last);
        }
        else {
            return binarySearch(numbers, search, first, mid-1);
        }
    }

    private static void printAnswer(int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int ans: answer) {
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}