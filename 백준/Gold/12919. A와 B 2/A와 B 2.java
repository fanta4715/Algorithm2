import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    //after에서 before의 len으로 갈 수 있는 경우를 다 담아둠
    //하나라도 존재하면 true로 만들어줌.
    static boolean possible=false;
    static String before;
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //before, after 받기
        before = br.readLine();
        String after = br.readLine();

        //after를 before로 가볼까?
        //단일한 결과가 나오지 않을 수 있음!
        //dfs처럼 여러 갈래로 파생되는 함수로 구현해야 할 듯.
        // 문자열의 길이가 똑같아질때,같은지 확인할 것.

        // A B 가능한 케이스
        // 1. A ~ A : 마지막에 A를 붙이고 끝났음
        // 2. A ~ B : 불가능함
        // 3. B ~ A : B를 붙여서 뒤집었을 수도 있고, A가 붙었을 수도 있고
        // 4. B ~ B : B를 붙여서 뒤집었음. (맨 앞을 활용해야 함)
        parsing(after);
        if (possible) System.out.println(1);
        else System.out.println(0);
    }

    static void parsing(String str){
        StringBuilder str2= new StringBuilder(str);
        int len = str.length();

        if (len==before.length() && before.equals(str)) {
            possible=true;
            return;
        }
        else if (len<before.length()) return;
        if (str.charAt(0)=='A' && str2.charAt(len-1)=='A'){
            parsing(str2.deleteCharAt(len-1).toString());
        }
        else if (str2.charAt(0)=='A' && str2.charAt(len-1)=='B'){
            return;
        }
        else if (str2.charAt(0)=='B' && str2.charAt(len-1)=='A'){
            StringBuilder str3= new StringBuilder(str);
            parsing(str2.deleteCharAt(0).reverse().toString());
            parsing(str3.deleteCharAt(len-1).toString());
        }
        else if (str2.charAt(0)=='B' && str2.charAt(len-1)=='B')
            parsing(str2.deleteCharAt(0).reverse().toString());



    }
}
