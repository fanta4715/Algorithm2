import java.util.*;

class Solution {
    //dfs -> scc찾기
    //scc크기와 최소, 최대 열만큼 list에 넣어줌
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] oilsInLand = new int[land[0].length];
        
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] == 0 || visited[i][j]) continue;
                
                Set<Integer> set = new HashSet<>();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                int area = 0;
                
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    area++;
                    set.add(curY);
                    for (int k=0; k<4; k++) {
                        int nextX = curX + dx[k];
                        int nextY = curY + dy[k];
                        if (isValidIndex(nextX, nextY, land) && land[nextX][nextY] == 1
                           && !visited[nextX][nextY]) {
                            queue.add(new int[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                        }
                    }  
                }
                
                for (int y : set) {
                    oilsInLand[y] += area;
                    // System.out.println((y+1) + "라인의 석유" + area +"만큼 추가");
                }
             }
        }
        
        int answer = findMaxOil(oilsInLand);
        return answer;
    }
    

    
    public boolean isValidIndex(int x, int y, int[][] land) {
        if (x < 0 || x >= land.length 
           || y < 0 || y >= land[0].length) return false;
        return true;
    }
    
    public int findMaxOil(int[] oilsInLand) {
        int max = 0;
        for (int i=0; i<oilsInLand.length; i++) {
            if (oilsInLand[i] > max) max = oilsInLand[i];
        }
        return max;
    }
}