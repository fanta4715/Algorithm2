

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //모음을 포함하는가
        boolean good = true;


        String str = br.readLine();
        StringBuilder sb= new StringBuilder();
//        sb.append("<").append(str).append("> is ");

        while(!str.equals("end")){
            good=true;
            int len = str.length();
            sb.append("<").append(str).append("> is ");
            //for : strlen동안 조건 불만족시 not을 sb에 붙이고 break;
            Set<Character> set = new HashSet<>();
            for (int i=0;i<len;i++){
                set.add(str.charAt(i));
            }

            //1번 케이스
            if (
                    !set.contains('a')
                            &&      !set.contains('e')
                            &&      !set.contains('i')
                            &&      !set.contains('o')
                            &&      !set.contains('u'))
                good=false;

            //2번 케이스
            for (int i=0;i<len-2;i++){
                if (isVowel(str.charAt(i))==
                        isVowel(str.charAt(i+1))
                        &&isVowel(str.charAt(i))==
                        isVowel(str.charAt(i+2)
                        )) {
                    good = false;
                    break;
                }
            }

            //3번 케이스
            for (int i=0;i<len-1;i++){
                if (str.charAt(i)==str.charAt(i+1)){
                    if (str.charAt(i)=='e'
                            ||str.charAt(i)=='o') continue;
                    else {
                        good=false;
                        break;
                    }
                }
            }

            if (!good) sb.append("not acceptable.").append("\n");
            else sb.append("acceptable.").append("\n");
            str=br.readLine();
        }


        System.out.println(sb);

    }

    static boolean isVowel(char c){
        if (c=='a'
                || c=='e'
                || c=='i'
                || c=='o'
                || c=='u') return true;
        else return false;
    }

}
