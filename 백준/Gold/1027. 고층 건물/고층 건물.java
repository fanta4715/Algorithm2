
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //빌딩 수 받기
        int buildingCnt = Integer.parseInt(br.readLine());

        //빌딩 높이 배열
        int[] buildingH = new int[buildingCnt];
        StringTokenizer st =new StringTokenizer(br.readLine());

        //빌딩 높이 받기
        for (int i=0;i<buildingCnt;i++){
            buildingH[i]= Integer.parseInt(st.nextToken());
        }

        //4가지 경우를 생각하자
        //1. 왼편에 있는 건물 + 기울기 양수 (오름차순일때)
        //2. 왼편에 있는 건물 + 기울기 음수 (내림차순일때)
        //3, 오른편에 있는 건물 + 기울기 양수 (오름차순일때)
        //4. 오른편에 있는 건물 + 기울기 음수 (내림차순일때)
        //핵심은 기울기인데, 기울기를 미리 구해버려?
        //굳이 빌딩 번호 1번으로 할 필요 없으니, int[buildingCnt+1][buildingCnt+1]
        //로 해서, 구한다음

        //매 건물마다, 기울기 활용해서 빌딩 수 구하고 max에 넣음
        //최종 max출력
//        int [][] incline =new int[buildingCnt][buildingCnt];
//        //기울기
//        for (int i=0;i<buildingCnt;i++){
//            for (int j=i+1;j<buildingCnt;j++){
//                incline[i][j]=(buildingH[j]-buildingH[i])/(j-1)
//            }
//        }
        int max=0;
        int cnt=0;
        for (int i=0;i<buildingCnt;i++){
            //i가 다른 건물들과 기울기를 계산하면서, 파악할 예정
            long minDy=1_000_000_001;
            long minDx=1;
            cnt=0;

            for (int j=i-1;j>=0;j--){
                //건물 i-1부터 0번째 건물까지 탐색
                long dy=buildingH[i]-buildingH[j];
                long dx=i-j;
                if (dy*(minDx)<dx*(minDy)) {
                    cnt++;
                    minDy=dy;
                    minDx=dx;
                }
                //기울기가 직전 최대값보다 작을 경우에만 카운트
            }
            long maxDy=-1_000_000_001;
            long maxDx=1;
            for (int j=i+1;j<buildingCnt;j++){
                //건물 i+1부터 마지막 건물까지 탐색
                long dy=buildingH[j]-buildingH[i];
                long dx=j-i;

                //기울기가 직전 최대값보다 큰 경우에만 카운트
                if (dy*(maxDx)>dx*(maxDy)) {
                    cnt++;
                    maxDy=dy;
                    maxDx=dx;
                }
            }
            max=Math.max(max,cnt);

        }
        System.out.println(max);

    }
}
