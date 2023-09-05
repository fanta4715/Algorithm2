
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //peopleCnt 받음
        int pCnt = Integer.parseInt(br.readLine());

        //peopleHeight 초기설정
        int pHeight[] = new int[pCnt];
        for (int i=0;i<pCnt;i++){
            pHeight[i]=-1;
        }

        //입력을 받을 배열
        int pLeft[]=new int[pCnt];
        //st로받고 쪼개서 배열에 넣음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<pCnt;i++){
            pLeft[i]=Integer.parseInt(st.nextToken());
        }

        //제일 작은 사람의 위치는 고정할 수 있음
        // 2 1 1 0 이라고 치자. 그럼 무조건 앞에 두 명이 있어야 하는
        //쪼꼬미는 무조건 3번 인덱스에 위치하겠지.

        //pLeft배열에서 숫자를 이용해서
        //pHeight배열에 인덱스를 접근하고
        //i+1을 넣어주면 딤
        for (int i=0;i<pCnt;i++){
            int index = pLeft[i];
            for (int j=0;j<=index;j++){
                if (pHeight[j]!=-1) index++;
            }
            pHeight[index]=i+1;
        }
        StringBuilder sb= new StringBuilder();
        for (int n : pHeight){
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}
