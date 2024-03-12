import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String line = s.substring(1, s.length());
        String[] elements = line.replace("},{", ":").replace("{","").replace("}","").split(":");
        Arrays.sort(elements, (a, b) -> {return a.length() - b.length();});
        int answer[] = new int[elements.length];
        int idx = 0;
        for (String s1 : elements) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                    break;
                }
            }
        }
        
        
        return answer;
    }
}