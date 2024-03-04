import java.util.*;
//라이언은 점수를 먹기 위해서 어피치보다 딱 한 발 더 맞춰야함
//화살을 다 쏘는 경우는 데, 화살의 수가 거의 정해져있으므로, 해당 수 만큼 안 나옴 -> 10초 가능
//완전탐색 + 최대일 때, 비교해서 바꾸기
class Solution {
    int max = 0;
    int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        dfs(n, 0, 0, info, new int[11]);
        if (max == 0) return new int[]{-1};
        return answer;
    }
    
    public void dfs(int maxArrow, int curArrow, int nowIdx, int[] apeachInfo, int[] lionInfo) {
        if (curArrow == maxArrow) {
            // System.out.println("last 3 : "+ lionInfo[8] + lionInfo[9] + lionInfo[10]);
            int lionSurplusPoint = calPoint(apeachInfo, lionInfo);
            if (lionSurplusPoint == max && moreLowerPoint(answer, lionInfo)) {
                insertInfo(lionInfo); 
            }
            if (lionSurplusPoint > max) {
                max = lionSurplusPoint;
                insertInfo(lionInfo); 
            }
            return ;
        }
        
        if (nowIdx >= 11) return;
        
        //안넣고
        dfs(maxArrow, curArrow, nowIdx+1, apeachInfo, lionInfo);
        
        //넣을 수 있다면 넣고
        if (curArrow + apeachInfo[nowIdx] + 1 <= maxArrow) {
            lionInfo[nowIdx] = apeachInfo[nowIdx] + 1;
            dfs(maxArrow, curArrow + apeachInfo[nowIdx]+1, nowIdx+1, apeachInfo, lionInfo);
            lionInfo[nowIdx] = 0;
        }
        
        if (nowIdx == 10) {
            lionInfo[nowIdx] = maxArrow - curArrow; 
            dfs(maxArrow, maxArrow, nowIdx+1, apeachInfo, lionInfo);
            lionInfo[nowIdx] = 0; 
        }
        
    }
    
    public int calPoint(int[] apeachInfo, int[] lionInfo) {
        int[] point = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int lionPoint =0;
        int apeachPoint =0;
        for (int i=0; i<11; i++) {
            if (lionInfo[i] == 0 && apeachInfo[i] == 0) continue;
            if (lionInfo[i] <= apeachInfo[i]) {
                apeachPoint += point[i];
            }
            else lionPoint += point[i];
        }
        return lionPoint - apeachPoint; 
    }
    
    public boolean moreLowerPoint(int[] answer, int[] lionInfo) {
        for (int i=10; i>=0; i--) {
            if (lionInfo[i] > answer[i]) {
                return true;
            }
            else if (lionInfo[i] < answer[i]) {
                return false;
            }
        }
        return false;
    }
    
    public void insertInfo(int[] lionInfo) {
        int[] copy = new int[lionInfo.length];
        for (int i=0; i<lionInfo.length; i++) {
            copy[i] = lionInfo[i];
        }
        answer = copy;
    }
}