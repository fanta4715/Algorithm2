import java.util.*; 
class Solution {
    public int cnt = 0;
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while (getRemoveNum(map)!=0) {
            removeBlock(map);
        }
        
        return cnt;
    }
    
    private int getRemoveNum(char[][] map) {
        int count = 0;
        for (int i=0; i<map.length-1; i++) {
            for (int j=0; j<map[0].length-1; j++) {
                if (map[i][j] == map[i][j+1]
                   && map[i][j+1] == map[i+1][j+1]
                   && map[i+1][j+1] == map[i+1][j]
                   && map[i][j] != 'X') count++;
            }
        }
        return count;
    }
    
    private void removeBlock(char[][] map) {
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<map.length-1; i++) {
            for (int j=0; j<map[0].length-1; j++) {
                if (map[i][j] == map[i][j+1]
                   && map[i][j+1] == map[i+1][j+1]
                   && map[i+1][j+1] == map[i+1][j]) list.add(new int[]{i,j});
            }
        }
        
        for (int[] xy : list) {
            int x = xy[0];
            int y = xy[1];
            
            if (map[x][y] != 'X') cnt++; map[x][y] = 'X';
            if (map[x+1][y] != 'X') cnt++; map[x+1][y] = 'X';
            if (map[x][y+1] != 'X') cnt++; map[x][y+1] = 'X';
            if (map[x+1][y+1] != 'X') cnt++; map[x+1][y+1] = 'X';
            
            
        }
        
        for (int j=0; j<map[0].length; j++) {
            for (int i=map.length-1; i >= 0; i--) {
                if (map[i][j] != 'X') continue;
                int index = i;
                for (int k = i-1; k >=0; k--) {
                    if (map[k][j] != 'X') {
                        map[i][j] = map[k][j];
                        map[k][j] = 'X';
                        break;
                    }
                }
            }
        } 
    }
}