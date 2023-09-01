import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //line받기
        String str = br.readLine();

        //line 순회하기
        int num=0;
        int index=0;
        int len = str.length();
        while(true){
            num++;
            String numStr = Integer.toString(num);

            //numStr과 str이 같은 경우, 계속 먹어줘야함
            for (int i=0;i<numStr.length();i++){
                if (numStr.charAt(i)==str.charAt(index)){
                    index++;
                }
                if (index==len) {
                    System.out.println(num);
                    return;
                }
            }
        }

    }
}
