import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String remainStr = br.readLine();
        String boomStr = br.readLine();
        int remainStrLen = remainStr.length();
        int boomStrLen = boomStr.length();

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<remainStrLen; i++) {
            stack.push(remainStr.charAt(i));
            boolean isSame = true;

            if (stack.size() >= boomStrLen &&
                    remainStr.charAt(i) == boomStr.charAt(boomStrLen-1)) {
                //스택에서 인덱스 내려가면서 boomStr과 똑같은 값이 있는지 확인
                //있으면 해당 내용 전부 스택에서 제외하기
                //없으면 계속 진행
                for (int j=boomStrLen-1 ; j>=0; j--) {
                    if (stack.get(stack.size()+j-boomStrLen) != boomStr.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j=0; j<boomStrLen; j++) {
                        stack.pop();
                    }
                }
            }



        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
