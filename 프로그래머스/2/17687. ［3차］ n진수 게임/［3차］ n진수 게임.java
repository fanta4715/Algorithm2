
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder(" ");
        StringBuilder answer = new StringBuilder();
        int num = 0;

        while (sb.length() <= t*m) {
            sb.append(Integer.toString(num++, n));
        }
        String str = sb.toString();
        
        for (int i=0; i<t; i++) {
            answer.append(str.charAt(p+i*m));
        }
        
        return answer.toString().toUpperCase();
    }
}