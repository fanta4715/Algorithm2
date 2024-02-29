import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        //선물지수와 사람끼리의 주고받은 수 저장해야 함.
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String sender : friends) {
            Map<String, Integer> receiver = makeReceiverMap(friends);
            map.put(sender, receiver);
        }
        
        //선물지수 틀 만들기
        Map<String, Integer> point = new HashMap<>();
        for (String friend : friends) {
            point.put(friend, 0);
        }
        //sender receiver로 map추가
        for (String gift : gifts) {
            String sender = gift.split(" ")[0];
            String receiver = gift.split(" ")[1];
            Map<String, Integer> receiverMap = map.get(sender);
            int pre = receiverMap.get(receiver);
            receiverMap.put(receiver, pre+1);
        } 
        
        //선물지수 계산
        for (String sender : friends) {
            for (String receiver : friends) {
                if (sender.equals(receiver)) continue;
                int sendNum = map.get(sender).get(receiver);
                point.put(sender, point.get(sender)+sendNum);
                point.put(receiver, point.get(receiver)-sendNum);
            }
        }
        
//         //총 받을 선물 수 계산
        Map<String, Integer> recvNum = new HashMap<>();
        for (String friend : friends) {
            recvNum.put(friend, 0);
        }
        for (String a : friends) {
            for (String b : friends) {
                if (a.equals(b)) continue;
                
                //a가 b보다 많이 준 경우
                if (map.get(a).get(b) > map.get(b).get(a)) {
                    recvNum.put(a, recvNum.get(a)+1);
                }
                //a가 b보다 적게 준 경우
                else if (map.get(a).get(b) < map.get(b).get(a)) {
                    recvNum.put(b, recvNum.get(b)+1);
                }
                //a와 b가 동일하게 준 경우
                else {
                    //a의 선물지수가 b보다 큰 경우
                    if (point.get(a) > point.get(b)) recvNum.put(a, recvNum.get(a)+1);
                    //a의 선물지수가 b보다 작은 경우
                    if (point.get(a) < point.get(b)) recvNum.put(b, recvNum.get(b)+1);
                    //같은 경우
                }
            }   
        }
        int max = 0;
        for (String friend : friends) {
            if (recvNum.get(friend) > max) max = recvNum.get(friend);
        }
        
        return max/2;
        //최대값 찾기
        
    }
    
    public Map<String, Integer> makeReceiverMap(String[] friends) {
        Map<String, Integer> map = new HashMap<>();
        for (String friend : friends) {
            map.put(friend, 0);
        }
        map.put("total", 0);
        return map;
    }
}