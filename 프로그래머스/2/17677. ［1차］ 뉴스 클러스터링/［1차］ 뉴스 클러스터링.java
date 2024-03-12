import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeMap(str1.toLowerCase());
        Map<String, Integer> map2 = makeMap(str2.toLowerCase());
        
        int answer = 0;
         
        //교집합 구하기
        int andNum = 0;
        Set<String> keys = new HashSet<String>(map1.keySet());
        keys.retainAll(map2.keySet());

        for (String key : keys) {
            andNum += Math.min(map1.get(key), map2.get(key));
        }
        if (map1.isEmpty() && map2.isEmpty()) return 65536;
        
        //합집합 구하기
        int unionNum = 0;
        Set<String> unionKeys = new HashSet<>(map1.keySet());
        unionKeys.addAll(map2.keySet());
        for (String key : unionKeys) {
            if (map1.get(key) == null) unionNum += map2.get(key);
            else if (map2.get(key) == null) unionNum += map1.get(key);
            else unionNum += Math.max(map1.get(key), map2.get(key));
        }
        
        answer = (int)(((double) andNum / (double) unionNum) * 65536);
        return answer;
    }
    
    private Map<String, Integer> makeMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<str.length()-1; i++) {
            String element = str.substring(i, i+2);
            if (validElement(element)) {
                if (map.containsKey(element)) map.put(element, map.get(element)+1);
                else map.put(element, 1);
            }
        }
        return map; 
    }
    
    private boolean validElement(String element) {
        char c1 = element.charAt(0);
        char c2 = element.charAt(1);
        if (c1 >= 'a' && c1 <='z' && c2 >= 'a' && c2 <='z') return true;
        return false;
    }
}