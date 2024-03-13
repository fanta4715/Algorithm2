import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        
        Arrays.sort(phone_book, (a,b) -> {return a.length() - b.length();});
        
        for (int i=0; i<phone_book.length; i++) {
            //내 글자의 substring마다 파악해서 있는지 확인
            if (havingPrefix(phone_book[i], set)) {
                answer = false;
                break;
            } 
            //있으면, false만들고 break;하고
            //없으면 set에 집어넣음
            set.add(phone_book[i]);
        }        
        return answer;
    }
    
    private boolean havingPrefix(String phone, Set<String> set) {
        for (int i=1; i<phone.length(); i++) {
            if (set.contains(phone.substring(0,i))) return true;
        }
        return false;
    }
}