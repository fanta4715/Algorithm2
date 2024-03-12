import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        //1. 양 옆 중괄호 없애기
        //{2},{2,1},{2,1,3},{2,1,3,4}
        String line = s.substring(1, s.length());
        
        //2. },{ split하기
        //2 : 2,1 : 2,1,3 : 2,1,3,4
        String[] elements = line.replace("},{", ":").replace("{","").replace("}","").split(":");
        
        //3. 길이 순 정렬
        Arrays.sort(elements, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        int answer[] = new int[elements.length];
        int idx = 0;
        for (int i=0; i<elements.length; i++) {
            String[] nums = elements[i].split(",");
            for (int j=0; j<nums.length; j++) {
                int num = Integer.parseInt(nums[j]);
                if (!set.contains(num)) {
                    set.add(num);
                    answer[idx++] = num;
                    break;   
                }
            }
        }
        
        
        return answer;
    }
}