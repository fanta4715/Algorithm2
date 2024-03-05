import java.lang.*;
import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int[] dx2 = {-1, 1, 1, -1};
    int[] dy2 = {-1, -1, 1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i=0; i<5; i++) {
            boolean isGoodPlace = isValidPlace(places[i]);
            if (isGoodPlace) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    
    private boolean isValidPlace(String[] place) {
        char[][] seat = new char[5][5];
        for (int i=0; i<5; i++) {
            seat[i] = place[i].toCharArray();
        }
    
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (seat[i][j] == 'P'){
                    boolean isGoodSeat = isValidSeat(seat, i, j);
                    if (!isGoodSeat) return false;
                }
            }
        }
        return true;
    }
    //맨해튼 거리 1에 사람이 있는 경우 -> 바로 0 반환
    //맨해튼 거리 2에 사람이 있는 경우 -> 일직선이면 사이에 파티션이 있는가
    //                               -> 꺾어가면 가는 경로 전부 파티션이 있는가
    
    private boolean isValidSeat(char[][] seat, int x, int y) {
        //맨해튼 거리 1에 사람이 있는 경우
        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (isValidIndex(nextX, nextY) && seat[nextX][nextY] == 'P') {
                System.out.println("맨해튼거리 1에 사람이 있음. 문제의 위치 x,y:"+x+" "+y);
                return false;
            }
        }
        //맨해튼 직선 거리 2에 사람이 있는 경우
        for (int i=0; i<4; i++) {
            int betX = x + dx[i];
            int betY = y + dy[i];
            int nextX = x + 2 * dx[i];
            int nextY = y + 2 * dy[i];
            
            if (isValidIndex(nextX, nextY) && seat[nextX][nextY] == 'P'
               && seat[betX][betY] != 'X') {
                
                System.out.println("맨해튼 직선거리 2에 사람이 있음. 문제의 위치 x,y:"+x+" "+y);
                return false;
            }
        }
        
        //맨해튼 대각선 거리 2에 사람이 있는 경우
        for (int i=0; i<4; i++) {
            int nextX = x + dx2[i];
            int nextY = y + dy2[i];
            
            if (isValidIndex(nextX, nextY) && seat[nextX][nextY] == 'P'
               && (seat[x][nextY] != 'X' || seat[nextX][y] != 'X')) {
                System.out.println("맨해튼 대각선거리 2에 사람이 있음. 문제의 위치 x,y:"+x+" "+y);
                return false;
            }
        }
        
        //다 없는 경우
        return true;
    }
    
    private boolean isValidIndex(int x, int y) {
        if (x < 0 || x >= 5 || y < 0 || y >= 5) return false;
        return true;
    }
}