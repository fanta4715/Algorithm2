
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i=0; i<t*m; i++) {
            sb.append(Integer.toString(i, n));
            if (sb.length() > t*m) break;
        }
        String str = sb.toString();
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<t; i++) {
            answer.append(str.charAt(p+i*m));
        }
        
        return answer.toString().toUpperCase();
    }
}