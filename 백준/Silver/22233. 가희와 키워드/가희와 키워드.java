

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //키워드 수, 게시글 수
        int keywordCnt=Integer.parseInt(st.nextToken());
        int articleCnt=Integer.parseInt(st.nextToken());

        //for : keywordCnt keyword받고, boolean hashmap 넣기
        //false -> 사용된 적 없음
        //true -> 사용됨
        HashMap<String,Boolean> map = new HashMap<>();
        for (int i=0;i<keywordCnt;i++){
            map.put(br.readLine(),false);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = keywordCnt;
        //for : articleCnt, 쉼표로 구분해서 받기
        for (int i=0;i<articleCnt;i++){
            st =new StringTokenizer(br.readLine(),",");
            while (st.hasMoreElements()){
                //key를 받음
                String key = st.nextToken();

                if (!map.containsKey(key)) continue;
                if (map.get(key)==false){
                    map.put(key,true);
                    cnt--;
                }
                //key를 통해 HashMap값 변경


            }


            if (i!=articleCnt-1)
                sb.append(cnt).append("\n");
            else
                sb.append(cnt);
        }
        System.out.println(sb);


    }
}
