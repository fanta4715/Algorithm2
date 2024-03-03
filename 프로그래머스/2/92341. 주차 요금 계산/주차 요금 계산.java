import java.util.*;

class Solution {
    //fee 0 : 기본시간
    //fee 1 : 기본 요금
    //fee 2 : 단위 시간
    //fee 3 : 단위 요금
    //총시간 - 기본시간 <= 0 이면, fee[1] 
    // 그렇지 않으면 fee[1] + (총시간-기본시간)/단위시간 (%단위시간있을시 +1) * fee[3];
    //record 0 : 시각
    //record 1 : 차량번호
    //record 2 : 내역(IN OR OUT)
    public int[] solution(int[] fees, String[] records) {
        //records 순회하면서 Map<> feeMap에 key로 넣어둠.
        Map<String, Integer> feeMap = new HashMap<>();
        Map<String, Integer> inMap = new HashMap<>();
        
        for (int i=0; i<records.length; i++) {
            String carNum = records[i].split(" ")[1];
            feeMap.put(carNum, 0);
            inMap.put(carNum, -1);
            
        }
        
        for (int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            int time = Integer.parseInt(record[0].split(":")[0])*60 + Integer.parseInt(record[0].split(":")[1]);
            String carNum = records[i].split(" ")[1];
            boolean isIn = records[i].split(" ")[2].equals("IN");
            if (isIn) {
                inMap.put(carNum, time);
            }
            else {
                int startTime = inMap.get(carNum);
                int parkTime = time - startTime;
                feeMap.put(carNum, feeMap.get(carNum)+parkTime);
                inMap.put(carNum, -1);
            }
        }
        //inMap에 IN넣음 -> OUT발견시, IN에서 값 발견해서 뺄셈하고, feeMap에 값 추가해줌
        //inMap에 값이 남아있다면, OUT 23:59로 하고, 뺄셈해서 feeMap 넣어줌.
        for (String carNum : inMap.keySet()) {
            if (inMap.get(carNum) != -1) {
                int parkTime = (23*60 + 59) - inMap.get(carNum);
                feeMap.put(carNum, feeMap.get(carNum)+parkTime);
            }
        }
        String[] carNumList = feeMap.keySet().stream()
            .sorted((o1, o2) -> o1.compareTo(o2))
            .toArray(String[]::new);
        
        int[] answer = new int[carNumList.length];
        for (int i=0; i<carNumList.length; i++){
            int totalTime = feeMap.get(carNumList[i]);
            answer[i] = calFee(fees, totalTime);
        }
        //key를 정렬해서 값을 뽑고, []에 담아냄
        return answer;
    }
    
    public int calFee(int[] fees, int totalTime) {
        //총시간 - 기본시간 <= 0 이면, fee[1] 
        
        if (totalTime <= fees[0]) return fees[1];
        int div = (totalTime - fees[0]) / fees[2];
        int remain = (totalTime - fees[0]) % fees[2];
        if (remain > 0) div++;
        return fees[1] + div*fees[3];
    // 그렇지 않으면 fee[1] + (총시간-기본시간)/단위시간 (%단위시간있을시 +1) * fee[3];
    
    }
}