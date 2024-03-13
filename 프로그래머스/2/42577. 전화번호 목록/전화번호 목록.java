import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        Arrays.sort(phone_book, (a,b) -> {return a.length() - b.length();});
        
        for (int i=0; i<phone_book.length; i++) {
            if (havingPrefix(phone_book[i], set)) return false;
            set.add(phone_book[i]);
        } 
        
        return true;
    }
    
    private boolean havingPrefix(String phone, Set<String> set) {
        for (int i=1; i<phone.length(); i++) {
            if (set.contains(phone.substring(0,i))) return true;
        }
        return false;
    }
}