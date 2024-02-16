import java.lang.Math;

class Solution {
    public int maxPeopleNum = 0;
    public int maxSaleAmount = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        dfs(users, emoticons, 0, new int[emoticons.length]);
        
        int[] answer = new int[2];
        answer[0] = maxPeopleNum;
        answer[1] = maxSaleAmount;
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int nowIdx, int[] discount) {
        if (nowIdx == emoticons.length) {
            int peopleNum=0, saleAmount=0; 
            
            for (int i = 0; i < users.length; i++) {
                int money = 0;
                for (int j = 0; j < discount.length; j++) {
                    if (users[i][0] <= discount[j]) money += emoticons[j]*(100-discount[j]) / 100;
                }
                if (users[i][1] <= money) peopleNum++;
                else saleAmount += money;
            }
            
            //사람 수가 기존보다 많다면, 사람 수와 가격 둘 다 덮어쓰기
            if (peopleNum > maxPeopleNum) {
                maxPeopleNum = peopleNum;
                maxSaleAmount = saleAmount;
            }
            //사람 수가 기존과 동일하다면, 가격을 높은 것으로 덮어쓰기
            else if (peopleNum == maxPeopleNum) {
                maxSaleAmount = Math.max(maxSaleAmount, saleAmount);
            }
            return;
        }
        
        // 10, 20, 30, 40
        for (int i = 10; i <= 40; i+=10) {
            discount[nowIdx] = i;
            dfs(users, emoticons, nowIdx+1, discount);
        }
        return; 
    }
}