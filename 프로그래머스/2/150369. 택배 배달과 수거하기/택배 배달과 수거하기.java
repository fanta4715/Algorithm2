import java.util.*;
//무조건 최대 개수만큼 싣고 가야 함
//무조건 멀리 있는 곳을 가긴 해야 함
//멀리있는 곳을 먼저가면 그 전 것들도 해결이 가능함. 
//스택으로 배달 수거 스택 관리하자.
class Solution {
    public long solution(int cap, int houseNum, int[] deliveries, int[] pickups) {
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        
        //deliveries, pickup 배열을 순회하면서 스택에 넣음
        for (int i = 0; i < deliveries.length; i++) {
            for (int j=0; j< deliveries[i]; j++) {
                deliveryStack.add(i+1);
            }
        }
        
        for (int i = 0; i < pickups.length; i++) {
            for (int j=0; j< pickups[i]; j++) {
                pickupStack.add(i+1);
            }
        }
        
        //둘 다 비어있는 경우에 탈출
        //그 외에는 루프 돌기
        //1 3 3  delStack
        //2 2 2  picStack
        long answer = 0L;
        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            //스택에서 하나 뺌 
            int destNum = 0;
            if (deliveryStack.isEmpty()) destNum = pickupStack.peek();
            else if (pickupStack.isEmpty()) destNum = deliveryStack.peek();
            else destNum = (pickupStack.peek() >  deliveryStack.peek()) ?
                pickupStack.peek() : deliveryStack.peek();

            answer += destNum*2;
            if (deliveryStack.size() >= cap) {
                for (int i = 0 ; i < cap; i++) {
                    deliveryStack.pop();
                }
            } else {
                int repeatNum = deliveryStack.size();
                for (int i = 0; i < repeatNum; i++) {
                    deliveryStack.pop();
                }
            }
            
            if (pickupStack.size() >= cap) {
                for (int i = 0 ; i < cap; i++) {
                    pickupStack.pop();
                }
            } else {
                int repeatNum = pickupStack.size();
                for (int i = 0 ; i < repeatNum; i++) {
                    pickupStack.pop();
                }
                
            }
        }
        return answer;
    }
}