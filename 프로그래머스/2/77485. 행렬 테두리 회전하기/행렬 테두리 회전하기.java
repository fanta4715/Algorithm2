import java.lang.*;
import java.util.*;

class Solution {
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
            
            int min = findMin(map, x1,y1, x2,y2);
            answer[i] = min;
            rotateMap(map, x1,y1, x2,y2);
        }
        return answer;
    }
    
    private int findMin(int[][] map, int x1, int y1, int x2, int y2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; y1 + i <= y2; i++) {
            pq.add(map[x1][y1 + i]);
        }
        
        //x1 y2 -> x2 y2
        for (int i=1; x1 + i <= x2; i++) {
            pq.add(map[x1+i][y2]);
        }
        
        //x2 y2 -> x2 y1
        for (int i=1; y2 - i >= y1; i++) {
            pq.add(map[x2][y2-i]);
        }
        
        //x2 y1 -> x1 y1
        for (int i=1; x2 - i >= x1; i++) {
            pq.add(map[x2-i][y1]);
        }
        
        return pq.poll();
    }
    
    private void rotateMap(int[][] map, int x1, int y1, int x2, int y2) {
        int pre = map[x1][y1];
        int tmp = 0;
        //x1 y1 -> x1 y2
        for (int i=1; y1 + i <= y2; i++) {
            tmp = map[x1][y1 + i];
            map[x1][y1 + i] = pre;
            pre = tmp;
        }
        
        //x1 y2 -> x2 y2
        for (int i=1; x1 + i <= x2; i++) {
            tmp = map[x1+i][y2];
            map[x1+i][y2] = pre;
            pre = tmp;
        }
        
        //x2 y2 -> x2 y1
        for (int i=1; y2 - i >= y1; i++) {
            tmp = map[x2][y2-i];
            map[x2][y2-i] = pre;
            pre = tmp;
        }
        
        //x2 y1 -> x1 y1
        for (int i=1; x2 - i >= x1; i++) {
            tmp = map[x2-i][y1];
            map[x2-i][y1] = pre;
            pre = tmp;
        }
    }
}