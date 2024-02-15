import java.util.*;

class Solution {
    public long solution(int cap, int houseNum, int[] deliveries, int[] pickups) {
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        
        setStack(deliveryStack, deliveries);
        setStack(pickupStack, pickups);
        
        return getDistance(deliveryStack, pickupStack, cap);
    }
    private void setStack(Stack<Integer> stack, int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j=0; j< array[i]; j++) {
                stack.add(i+1);
            }
        }
    }
    
    private long getDistance(Stack<Integer> deliveryStack, Stack<Integer> pickupStack, int cap) {
        long answer = 0L;
        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
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