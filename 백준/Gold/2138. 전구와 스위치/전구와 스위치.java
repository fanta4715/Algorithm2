
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        //N받고,  before after 받기
        N = Integer.parseInt(br.readLine());
        String b = br.readLine();
        String a = br.readLine();

        //before after 배열로 만들기
        boolean[] before1=new boolean[N];
        boolean[] before2=new boolean[N];
        boolean[] after=new boolean[N];

        for (int i=0;i<N;i++){
            before1[i]=(b.charAt(i)=='0') ? false:true;
            before2[i]=(b.charAt(i)=='0') ? false:true;
            after[i]=(a.charAt(i)=='0') ? false:true;
        }
        int cnt1=0, cnt2=0;
        //before2는 1번을 flip한 경우
        flip(before2, 0);
        cnt2++;

        for (int i=1;i<N;i++){
            //before1에 i-1인덱스가 after의 i-1인덱스와 같으면 skip
            //다르면 flip하고 cnt++
            if (before1[i-1]!=after[i-1]) {
                flip(before1, i); cnt1++;
            }
            if (before2[i-1]!=after[i-1]) {
                flip(before2,i); cnt2++;
            }
        }
        int answer=N+1;
        if (before1[N-1]==after[N-1]) answer=cnt1;
        if (before2[N-1]==after[N-1]) answer=Math.min(answer,cnt2);
        if (answer==N+1) answer=-1;
        System.out.println(answer);
    }

    static void flip(boolean[] before, int index){
        before[index]=(before[index]==false) ? true : false;
        if (index==0){
            //index+1만 바꿔줌
            before[index+1]=(before[index+1]==false) ? true : false;
        }
        else if (index==N-1){
            //index-1만 바꿔줌
            before[index-1]=(before[index-1]==false) ? true : false;

        }
        else{
            // index+-1 바꿔줌
            before[index+1]=(before[index+1]==false) ? true : false;
            before[index-1]=(before[index-1]==false) ? true : false;
        }
    }
}
