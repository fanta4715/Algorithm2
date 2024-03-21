
// \_\ : right
//
class Solution {
    
    public int solution(int n, int[] tops) {
        int[] dpRight = new int[n];
        int[] dpLeft = new int[n];
        dpRight[0] = 1;
        if (tops[0] == 1) dpLeft[0] = 3;
        else dpLeft[0] = 2;
        
        for (int i=1; i<n; i++) {
            dpRight[i] = (dpLeft[i-1] + dpRight[i-1])%10007;
            if (tops[i] == 1) {
                dpLeft[i] = (dpLeft[i-1]*3 + dpRight[i-1]*2)%10007;
            }
            else {
                dpLeft[i] = (dpLeft[i-1]*2 + dpRight[i-1])%10007;
            }
        }
        return (dpLeft[n-1]+dpRight[n-1])%10007;
    }
}