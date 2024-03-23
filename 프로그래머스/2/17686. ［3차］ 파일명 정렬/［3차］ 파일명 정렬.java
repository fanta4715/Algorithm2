import java.util.*;

class Solution {
    
    static class FileSys implements Comparable<FileSys>{
        String head;
        String number;
        String remain;
        int rank;
        
        public FileSys(String head, String number, String remain, int rank) {
            this.head = head;
            this.number = number;
            this.remain = remain;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(FileSys o) {
            if (this.head.toLowerCase().equals(o.head.toLowerCase())) {
                if (Integer.parseInt(this.number) == Integer.parseInt(o.number)) {
                    return this.rank - o.rank;
                }
                else return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
        
        @Override
        public String toString() {
            return head+number+remain;
        }
    }
    
    public String[] solution(String[] files) {
        FileSys[] fakeAnswers = new FileSys[files.length];
        for (int i=0; i<files.length; i++) {
            String[] arr = parseFile(files[i]);    
            fakeAnswers[i] = new FileSys(arr[0], arr[1], arr[2], i);
        }
        
        Arrays.sort(fakeAnswers);
        String[] answer = new String[files.length];
        for (int i=0; i<files.length; i++) {
            answer[i] = fakeAnswers[i].toString();
        }
        return answer;
    }
    
    private String[] parseFile(String file) {
        String lowStr = file.toLowerCase();
        int i=0;
        int firstIdx = 0;
        int secondIdx = 0;
        for (; i<lowStr.length(); i++) {
            if (lowStr.charAt(i) <='9' && lowStr.charAt(i)>='0') {
                firstIdx = i;
                break;
            }
        }
        
        
        for (; i<lowStr.length(); i++) {
            if (lowStr.charAt(i) <='9' && lowStr.charAt(i)>='0') {
                secondIdx = i+1;
            }
            else break;
        }
        
        String arr[] = new String[3];
        arr[0] = file.substring(0, firstIdx);
        arr[1] = file.substring(firstIdx, secondIdx);
        if (secondIdx == file.length()) arr[2] = "";
        else arr[2] = file.substring(secondIdx, file.length());
        return arr;
    }
}