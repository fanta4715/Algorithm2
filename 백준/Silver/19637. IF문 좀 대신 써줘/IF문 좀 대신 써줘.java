
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] power;
    static int numRank;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        // 10^9 = 1_000_000_000
        // 10^5 = 100_000

        //칭호 : rank numRank
        //전투력 : power
        //캐릭터 : person numPerson

        //numRank numPerson 받음
        numRank = Integer.parseInt(st.nextToken());
        int numPerson = Integer.parseInt(st.nextToken());

        //numRank만큼, rank를 받음, 상한값이 작은 수대로
        //클래스로 저장할 것이냐, 두 개의 배열로 저장할 것이냐
        //배열의 크기를 +1로 해놓은 이유 :
        // 이분탐색을 위해서, n-1번 인덱스와 n번 인덱스 사이의 값으로 판단을 할 예정
        // 맨 앞 인덱스의 경우에는, 인덱스 에러가 나서 예외처리 해야 함
        // 그냥 0번 인덱스에 power -1으로 두면 가능
        // 중복되는 값들은 넣어도 되고 안 넣어도 되고. 그냥 넣자. 배열 꽉 채우게
        String[] rank = new String[numRank+1];
        power = new int[numRank+1];

       // st =new StringTokenizer(br.readLine());
        rank[0]="BOUNDARY";
        power[0]=-1;

        //rank 받음
        for (int i=1;i<=numRank;i++){
            st =new StringTokenizer(br.readLine());
            rank[i]=st.nextToken();
            power[i]=Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        //numPerson만큼, person의 전투력을 얻음
        for (int i=1;i<=numPerson;i++){
            //다 받고나서 순회하나, 받고 바로 처리하나 시간 복잡도 동일
            // 바로 처리하자
            int person = Integer.parseInt(br.readLine());
            int indexRank = findRank(person); //person에 해당하는 rank의 인덱스
            sb.append(rank[indexRank]).append("\n");
        }
        //문제의 요점은, 해당 값의 칭호를 log시간안에 찾으라는 것.
        System.out.println(sb);
    }

    static int findRank(int person){
        //이분 탐색
        // power에서 탐색하면 됨
        // left right 정하고, mid를 정해서
        int left=1;
        int right=numRank;
        while(left<right){
            int mid = (left+right)/2;
            //0~numRank 인덱스까지 살피기
            //mid가 1이 나왔을 때, 0~1을 뒤질 것이냐, 1~2를 뒤질 것이냐
            //0~1을 뒤져야한다.

            //1 mid-1  2  mid 3
            //case2
            if (person>power[mid-1] && person<=power[mid]) return mid;

            //case1
            else if (person<=power[mid-1]) right=mid-1;

            //case3
            else left=mid+1;
        }
        return left;
    }
}
