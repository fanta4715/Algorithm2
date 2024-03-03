//투포인터
//len = 1부터 s.length()/2까지 탐색
//줄인 크기의 합이 가장 큰 것을 내 뱉자
//그리고 s.length - 줄인크기 return 
import java.util.*;

class Solution {
    public int solution(String s) {
        int maxCut = 0;
        for (int i = 1; i <= s.length()/2; i++) {
            int cutNum = calCut(s, i);
            maxCut = Math.max(cutNum, maxCut);
        }
        return s.length() - maxCut;
    }
    
    public int calCut(String s, int len) {
        String standWord = s.substring(0, len);
        // System.out.println(standWord);
        int sameCnt = 0;
        int cutNum = 0;
        for (int start = 0; start < s.length(); start+=len) {
            if (start+len > s.length()) break; 
            
            String thisWord = s.substring(start, start+len);
            if (len == 6) System.out.println(thisWord);
            if (standWord.equals(thisWord)) {
                sameCnt++;
            }
            else {
                if (sameCnt >= 2) {
                    cutNum-= String.valueOf(sameCnt).length();
                    cutNum += (sameCnt-1) * len;
                    if (len == 6) System.out.println(cutNum);
                }
                sameCnt = 1;
                standWord = s.substring(start, start+len);                
            }
        }
                
        if (sameCnt >= 2) {
            cutNum-= String.valueOf(sameCnt).length();
            cutNum += (sameCnt - 1) * len;
            if (len == 6) System.out.println(cutNum);
                
        }       
        return cutNum;
    }
}