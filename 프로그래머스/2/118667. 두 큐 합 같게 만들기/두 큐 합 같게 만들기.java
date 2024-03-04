import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0L;
        long q2Sum = 0L;
        long goal = 0L;
        int answer = 0;
        //Queue<> 두개 생성해서 값 넣기, 넣으면서 합 넣기
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            q1Sum += (long)queue1[i]; 
            q2Sum += (long)queue2[i]; 
        }
        goal = (q1Sum + q2Sum) / 2;
        if ((q1Sum + q2Sum)%2 != 0) return -1;
        
        while (q1Sum != q2Sum) {
            answer++;
            //q1Sum이 q2Sum보다 큰 경우, q1의 값을 q2에 더해주고, sum변경
            if (q1Sum > q2Sum) {
                int num = q1.poll();
                if ((long)num > goal) return -1;
                
                q2.add(num);
                q2Sum += num;
                q1Sum -= num;
                continue;
            }
            //q2Sum이 q1Sum보다 큰 경우
            int num = q2.poll();
            if ((long)num > goal) return -1;
            q1.add(num);
            q1Sum += num;
            q2Sum -= num;
            
            if (answer > 4*queue1.length) return -1;
         }
        
        return answer;
    }
}