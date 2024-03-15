import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<26; i++) {
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        for (int i=0; i<msg.length(); i++) {
            String w= findW(map, msg, i);
            list.add(map.get(w));
            
            if (i+w.length() >= msg.length()) break;
            
            map.put(msg.substring(i, i+w.length()+1), map.size()+1);
            i+=w.length()-1;
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private String findW(Map<String, Integer> map, String msg, int idx) {
        for (int i=idx+1; i< msg.length()+1; i++) {
            if (!map.containsKey(msg.substring(idx, i))) return msg.substring(idx, i-1);
        }
        return msg.substring(idx, msg.length());
    }
}