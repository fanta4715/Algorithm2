import java.util.*;

class Solution {
    int answer = 0;
    boolean possible = false;
    public int solution(String[] user_id, String[] banned_id) {
        //모든 경우의 수 -> banned_id에 매핑되는가? -> answer++;
        dfs(user_id, banned_id, 0, 0, new boolean[user_id.length]);
        return answer;
    }
    
    private void dfs(String[] user_id, String[] banned_id, int idx, int cnt, boolean[] selected) {
        if (cnt == banned_id.length) {
            //selected가 banned_id에 매핑이 되면 answer++;
            //모든 경우의 수로 정렬시켜놓고, 1ㄷ1 매핑이 되는 지 확인
            int index = 0;
            String[] selectedUser = new String[banned_id.length];
            for (int i=0; i<user_id.length; i++) {
                if (selected[i]) selectedUser[index++] = user_id[i];
            }
            possible = false;
            permutation(selectedUser, banned_id, new String[banned_id.length], new boolean[banned_id.length], 0, banned_id.length);
            if (possible) answer++;
            return;
        }
        if (idx >= user_id.length) return;
        
        dfs(user_id, banned_id, idx+1, cnt, selected);
        selected[idx] = true;
        dfs(user_id, banned_id, idx+1, cnt+1, selected);
        selected[idx] = false;
    }
    // frodo crodo 
    // *rodo f*odo 
    private void permutation(String[] selectedUser, String[] banned_id, String[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            for (int i=0; i<r; i++) {
                //가능하지 않으면 return
                if (!matchString(output[i], banned_id[i])) return;
            }
            //
            possible = true;
        }
        
        for (int i=0; i<r; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = selectedUser[i];
                permutation(selectedUser, banned_id, output, visited, depth+1, r);
                output[depth] = null;
                visited[i] = false;
            }
        }
    }
    
    private boolean matchString(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        for (int i=0; i<userId.length(); i++) {
            if (userId.charAt(i) != bannedId.charAt(i) 
               && bannedId.charAt(i) != '*') return false;
        }
        return true;
    }
}