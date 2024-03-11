import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            int start = (int) Math.pow(2, n-1);
            int arr1Num = arr1[i];
            int arr2Num = arr2[i];
            StringBuilder sb = new StringBuilder();
            while (start > 0) {
                if (arr1Num >= start || arr2Num >= start) {
                    if (arr1Num >= start) arr1Num -= start; 
                    if (arr2Num >= start) arr2Num -= start;
                    sb.append("#"); 
                }
                else sb.append(" ");
                start /= 2;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}