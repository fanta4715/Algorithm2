class Solution {
    public int solution(int N, int[][] roads, int K) {
        
        int len[][] = new int[N+1][N+1];
        clear(len);
        
        //road를 받아서 len[][]에 넣기
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            int dist = road[2];
            if (dist < len[x][y]) {
                len[x][y] = dist;
                len[y][x] = dist;
            }
        }
        
        int floyd[][] = new int[N+1][N+1];
        for (int i=0; i<N+1; i++) {
            for (int j=0; j<N+1; j++) {
                floyd[i][j] = len[i][j];
            }
        }
        
        //floyd구현
        for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                for (int k=1; k<N+1; k++) {
                    if (floyd[j][i] + floyd[i][k] < floyd[j][k]) {
                        floyd[j][k] = floyd[j][i] + floyd[i][k];
                        floyd[k][j] = floyd[j][i] + floyd[i][k];
                    }
                }
            }
        }
        //1번 가게에서 dist가 k이하인 경우 찾기
        int answer =0 ;
        for (int i=1; i<N+1; i++) {
            if (floyd[1][i] <= K) answer++;
        }
        return answer;
    }
    
    public void clear(int[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                map[i][j] = 1_000_000_000;
                if (i==j) map[i][j]=0;
            }
        }
    }
}