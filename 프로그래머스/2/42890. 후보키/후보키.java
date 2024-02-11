import java.util.*;

class Solution {
    List<int[]> keys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int colNum = relation[0].length;
        for (int i=1; i<=colNum; i++) {
            dfs(relation, new boolean[colNum], 0, i);
        }
        return keys.size();
    }
    
    public void dfs(String[][] relation, boolean[] use, int nowIdx, int goal) {
        if (nowIdx == relation[0].length) {
            int useNum = findUseNum(use);
            if (useNum != goal) return;
            if (!isUnique(relation, use)) return;
            if (!isMinimum(use)) return;
            
            int[] key = new int[goal];
            int idx = 0;
            for (int i=0; i<relation[0].length; i++) {
                if (use[i]) key[idx++] = i;
            }
            keys.add(key);
            return;
        }
        dfs(relation, use, nowIdx+1, goal);
        use[nowIdx] = true;
        dfs(relation, use, nowIdx+1, goal);
        use[nowIdx] = false;
    }
    
    public int findUseNum(boolean[] uses) {
        int cnt = 0;
        for (boolean use : uses) {
            if (use) cnt++;
        }
        return cnt;
    }
    
    public boolean isMinimum(boolean[] use) {
        //use배열의 인덱스값을 활용해서 set을 만듬
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< use.length; i++) {
            if (use[i]) set.add(i);
        }
        //keys에서 get을 해서 하나하나 꺼내서 비교
        for (int i = 0; i < keys.size(); i++) {
            int[] candidateKey = keys.get(i);
            boolean allSame = true;
            for (int j = 0; j < candidateKey.length; j++) {
                //candidateKey의 값이 모두 들어있다면, false 반환
                if (!set.contains(candidateKey[j])) {
                    allSame = false;
                    break;
                }    
            }
            if (allSame) return false;
        }
        
        return true;
    }
    
    public boolean isUnique(String[][] relation, boolean[] use) {
        Set<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < relation[0].length; j++) {
                    if (use[j]) sb.append(relation[i][j]).append(":");
                }
                set.add(sb.toString());
            }
        
        if (set.size() != relation.length) return false;
        return true;
    }
}
