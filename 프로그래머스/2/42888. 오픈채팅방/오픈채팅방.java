import java.util.*;
class Solution {
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        
        //uid1234:님이 들어왔습니다. 와 같이 담김
        List<String> tempAnswer = new ArrayList<>();
        
        for (String record : records) {
            parseRecord(record, map, tempAnswer);
        }
        
        return changeIdToName(tempAnswer, map);
    }
    
    private void parseRecord(String record, Map<String, String> map, List<String> tempAnswer) {
        if (record.split(" ")[0].equals("Enter")) {
            String uid = record.split(" ")[1];
            String name = record.split(" ")[2];
            map.put(uid, name);
            tempAnswer.add(uid+":"+"님이 들어왔습니다.");
            //tempAnswer에 기록 남기기
            //혹시 기존에 없었던 uid라면, map에 넣어주고
            //있었다면 map에 넣어주자
        }
        
        else if (record.split(" ")[0].equals("Leave")) {
            String uid = record.split(" ")[1];
            tempAnswer.add(uid+":"+"님이 나갔습니다.");
            //tempAnswer에 기록 남기기
        }
        
        else {
            String uid = record.split(" ")[1];
            String name = record.split(" ")[2];
            map.put(uid, name);
        }
    }
    
    
    private String[] changeIdToName(List<String> tempAnswer, Map<String, String> map) {
        String[] ans = new String[tempAnswer.size()];
        for (int i=0; i<tempAnswer.size(); i++) {
            String arr[] = tempAnswer.get(i).split(":");
            ans[i] =map.get(arr[0])+arr[1] ;
        }
        return ans;
    }
}