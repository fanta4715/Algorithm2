import java.lang.*;
import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) { 
                map[i][j] = (i-1)*columns + j;
            }
        }
        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int x1 = queries[i][0];
            int x2 = queries[i][2];
            int y1 = queries[i][1];
            int y2 = queries[i][3];
            
            answer[i] = rotateMapAndFindMin(map, x1,y1, x2,y2);
        }
        return answer;
    }
    
    private int rotateMapAndFindMin(int[][] map, int x1, int y1, int x2, int y2) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int dir = 0, x = x1, y = y1;
        queue.add(map[x1][y1]);
        pq.add(map[x1][y1]);
        
        while (true) {
            if (x == x1 && y == y2) dir = 1;
            if (x == x2 && y == y2) dir = 2;
            if (x == x2 && y == y1) dir = 3;
            
            x += dx[dir];
            y += dy[dir];
            queue.add(map[x][y]);
            pq.add(map[x][y]);
            map[x][y] = queue.remove();
            if (x == x1 && y == y1) break;
        }
        
        return pq.poll();
    }
}