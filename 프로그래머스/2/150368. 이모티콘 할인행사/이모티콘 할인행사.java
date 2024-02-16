import java.lang.Math;

class Solution {
    public int maxPeopleNum = 0;
    public int maxSaleAmount = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        //할인율 bruteforce 
        //maxPeople, maxSaleAmount
        // dfs(users, emoticons, nowIdx, int[] discount);
        dfs(users, emoticons, 0, new int[emoticons.length]);
        
        int[] answer = new int[2];
        answer[0] = maxPeopleNum;
        answer[1] = maxSaleAmount;
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int nowIdx, int[] discount) {
        if (nowIdx == emoticons.length) {
            //해당 할인율로 얻을 수 있는 사람 수와 가격 구하기
            int peopleNum=0, saleAmount=0; 
            for (int i = 0; i < users.length; i++) {
                //사람 한 명 기준, users[i][0]이상인 discount[j]에 대해서 다 더해줌. 
                //더했을 때, users[i][1]보다 크다면 peopleNum을 추가해주고
                //그렇지 않다면 saleAmoutn를 추가해줌
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
        discount[nowIdx] = 10;
        dfs(users, emoticons, nowIdx+1, discount);
        
        discount[nowIdx] = 20;
        dfs(users, emoticons, nowIdx+1, discount);
        
        discount[nowIdx] = 30;
        dfs(users, emoticons, nowIdx+1, discount);
        
        discount[nowIdx] = 40;
        dfs(users, emoticons, nowIdx+1, discount);
        return; 
    }
}