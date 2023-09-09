
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//예상 : 브루트포스, 재귀함수
public class Main {
    static ArrayList<String> arrayList;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //T받기
        int T  = Integer.parseInt(br.readLine());

        //for T : 출력하기
        for (int i=0;i<T;i++){
            arrayList = new ArrayList<>();
            int  N = Integer.parseInt(br.readLine());
            bruteforce(N,2,1, "1",false);

            Collections.sort(arrayList);
            for (int j=0; j<arrayList.size();j++){
                System.out.println(arrayList.get(j));
            }
            System.out.println();
        }

    }
    static void bruteforce(int N, int num, int sum, String str,boolean useSpace){
        //재귀의 종료
        if (num>N) {
            if (sum==0) arrayList.add(str);
            return;
        }

        //그냥 세 가지 다 하면 될 듯?
        //true -> 무조건 +-만 하기
        //case1. sum+num
        bruteforce(N,num+1,sum+num,str+"+"+num,false);
        //case2. sum-num
        bruteforce(N,num+1,sum-num,str+"-"+num,false);

        if (!useSpace){
            //안 썻다면
            //case1. sum+num
            //case2. sum-num
            //case3.
            if (num==2) bruteforce(N,num+1,sum*10+num,str+" "+num,true);
            //  앞의 부호가 +이면, sum-(num-1)+(num-1)*10+num
            // num==3이면, 1+2만 있음 -> charAt(1)
            // num==4이면, 1+2+3     -> charAt(3)
            // num==5이면, 1+2+3+4   -> charAt(5)
            // (num-3)*2+1
            else if (str.charAt((num-3)*2+1)=='+') bruteforce(N,num+1,sum-(num-1)+(num-1)*10+num,str+" "+num,true);
            //  앞의 부호가 -이면, sum+(num-1)-(num-1)*10+num
            else if (str.charAt((num-3)*2+1)=='-') bruteforce(N,num+1,sum+(num-1)-((num-1)*10+num),str+" "+num,true);
            //  앞의 부호가 없으면 -> 불가능
            //  num이 2이면, 그냥 sum*10+num
        }


        //case3. sum*10+num

    }
}
