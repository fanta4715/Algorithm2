import java.util.*;


class Solution {
    Set<Integer> primeSet = new HashSet<>();
    
    public int solution(int n, int k) {
        String changedNum = changeBase(n, k);
        // makePrimeSet();
        // 0으로 분리해서, 공백이 아닌 String을 숫자로 변형시킨다음. 
        int answer = 0;
        String[] numberStr = changedNum.split("0");
        for (String str : numberStr) {
            if (str.length() > 0 && isPrime(str)) {
                answer++;  
            } 
        }
        return answer;
    }
    
    private String changeBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n%k);
            n /= k;
        }
        return sb.toString();
    }
    
    private boolean isPrime(String str) {
        Long num = Long.parseLong(str);
        if (num < 2L) return false;
        for (long i=2; i*i<=num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
}
