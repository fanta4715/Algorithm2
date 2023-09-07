

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // T받기
        int T =Integer.parseInt(br.readLine()) ;

        // T번만큼 실행
        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //팀의 수, 문제 수, 팀 id, 로그 수
            int teamCnt = Integer.parseInt(st.nextToken());
            int problemCnt = Integer.parseInt(st.nextToken());
            int teamId = Integer.parseInt(st.nextToken());
            int logCnt = Integer.parseInt(st.nextToken());

            //teamCnt만큼 Team배열 생성 및 초기화
            Team[] teams = new Team[teamCnt+1];
            for (int i=0; i<=teamCnt; i++){
                teams[i] = new Team(i,new int[problemCnt+1]);
                for (int j=1;j<=problemCnt;j++){
                    teams[i].problem[j]=-1;
                }
            }
            //for : logCnt,
            for (int i=0;i<logCnt;i++){
                //팀id, 문제번호, 점수가 주어짐
                //해당 팀의 기존 문제 파악 후 갱신
                //제출시간 갱신
                st=new StringTokenizer(br.readLine());
                int id =Integer.parseInt(st.nextToken());
                int problemId=Integer.parseInt(st.nextToken());
                int score =Integer.parseInt(st.nextToken());
                if (teams[id].problem[problemId]==-1) {

                    teams[id].problem[problemId]=0;
                }

                //문제 갱신해야 함
                if (teams[id].problem[problemId] < score) {
                    teams[id].totalScore+= score-teams[id].problem[problemId];
                    teams[id].problem[problemId] = score;
                }
                teams[id].solveCnt++;
                teams[id].last=i;
            }

            Arrays.sort(teams);
            for (int i=0;i<=teamCnt;i++){

                if (teams[i].id==teamId) {
                    sb.append(i+1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static class Team implements Comparable<Team>{

        final int id;
        int totalScore; //총합
        int solveCnt; //푼 문제 수
        int last; //마지막 제출 시간
        int[] problem; //푼 문제들 (점수 갱신을 위함)

        @Override
        public int compareTo(Team o) {
            if (totalScore==o.totalScore){
                if (solveCnt==o.solveCnt){
                    return this.last-o.last;
                }
                else return this.solveCnt-o.solveCnt;
            }
            else return o.totalScore-this.totalScore;
        }

        public Team(int id, int[] problem) {
            this.id = id;
            this.totalScore = 0;
            this.solveCnt = 0;
            this.last = 0;
            this.problem = problem;
        }
    }
}
