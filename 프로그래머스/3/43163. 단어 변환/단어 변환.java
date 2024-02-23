import java.util.*; 

class Solution {
    public int solution(String begin, String target, String[] words) {
        int wordNum = words.length;
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[wordNum];
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.word.equals(target)) {
                answer = curNode.dist;
                break;
            }
            
            for (int i=0; i<wordNum; i++) {
                if (!visit[i] && canGo(words[i], curNode.word)) {
                    visit[i] = true;
                    q.add(new Node(words[i], curNode.dist+1));
                }
            }
        }
        
        return answer;
    }
    
    static class Node {
        public String word;
        public int dist;
        
        public Node(String word, int dist) {
            this.word=word;
            this.dist=dist;
        }
    }
    
    public boolean canGo(String word1, String word2) {
        int n = word1.length();
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) ans++;
        }
        return (ans==1);
    }
}