import java.util.*;
class Solution {
    int answerStart = 1;
    int answerEnd = 100_000;
    public int[] solution(String[] gems) {
        
        int start = 1;
        int end = 1;
        //gems -> Set<String>
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        
        //임시 Set<>만들면서, 크기가 같아지는 시점에 start, end를 비교해서 저장
        HashMap<String, Integer> bag = new HashMap<>();
        String[] gemArr = new String[gems.length+1];
        for (int i=1; i<gemArr.length; i++) {
            gemArr[i] = gems[i-1];
        }
        bag.put(gemArr[1], 1);
        
        while (start <= end) {
            //bag.size() == set.size()인 경우
            // System.out.println("bag set size:"+bag);
            if (bag.keySet().size() == set.size()) {
                //대입하기
                // System.out.println(start+":"+end+"insert!");
                
                insertAnswer(start, end);
                if (bag.get(gemArr[start]) == 1) {
                    // System.out.println("gemArr out"+gemArr[start]);
                    bag.remove(gemArr[start]);
                }
                else bag.put(gemArr[start], bag.get(gemArr[start])-1);
                start++;
                continue;
            }
            
            //bag.size() < set.size()인 경우
            if (end+1 < gemArr.length) {
                end++;
                if (end >= gemArr.length) break;
                if (bag.get(gemArr[end]) == null) {
                    // System.out.println(gemArr[end]);
                    bag.put(gemArr[end], 1);
                }
                else bag.put(gemArr[end], bag.get(gemArr[end])+1);
                continue;
            }
            break;
            
        }
        return new int[]{answerStart, answerEnd};
    }
    
    private void insertAnswer(int start, int end) {
        if (end-start >= answerEnd-answerStart) return ;
        answerStart = start;
        answerEnd = end;
    }
}