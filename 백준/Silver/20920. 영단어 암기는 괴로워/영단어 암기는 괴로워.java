import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        PriorityQueue<Word> pq = new PriorityQueue<>();
        //어차피 내림차순 정렬이라면, 가능함 (스트링의 compareTo !!)

        //N과 maxLen 받음
        int N = Integer.parseInt(st.nextToken());
        int maxLen = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        //N번 받되, 길이가 maxLen이상이면 map에넣음
        //해당 값이 있으면 value값 올림
        for (int i=0;i<N;i++){
            String str = br.readLine();
            if (str.length()>=maxLen) {
                if (map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                }
                else map.put(str,1);
            }
        }

        //map에 들어있는거 객체로 만들어서 pq에 넣음
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            pq.add(new Word(map.get(key),key));
        }
        //이미 다 정렬된 상황, 출력만 하면 됨
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!pq.isEmpty()){
            bw.write(pq.poll().str+"\n");
        }

        bw.close();// close=flush+close
    }

    public static class Word implements Comparable<Word>{
        int freq;
        String str;

        public Word(int freq, String str) {
            this.freq = freq;
            this.str = str;
        }

        @Override
        public int compareTo(Word o) {
            if (this.freq==o.freq){
                if (this.str.length()==o.str.length()){
                    return this.str.compareTo(o.str);
                }
                else return o.str.length()-this.str.length();
            }
            else return o.freq-this.freq;
        }
    }
}
