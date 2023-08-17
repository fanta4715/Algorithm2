import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        //스택을 통해서, 넣는다
        Stack<Integer> stack = new Stack<>();



        int cnt=0;
        //이전값보다 값이 작다면, +1을 한다.
        //마지막에도 +1을 한다.
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //243
//            System.out.println(x+","+y);

            //stack.add(y);
            //y가 더 작으면, +1을 하고, 값을 뺴냄
            if (stack.isEmpty()) {
                stack.add(y);
                continue;
            }
            while (stack.peek()>y){
                cnt++;
//                System.out.println("x:"+x);
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(y);
                    break;
                }
            }
            if (stack.isEmpty()) {
                stack.add(y);
                continue;
            }
            if (stack.peek()==y) continue;
            else stack.add(y);

        }

        while(!stack.isEmpty()){
            if (stack.pop()!=0) cnt++;
        }
        System.out.println(cnt);
    }
}
