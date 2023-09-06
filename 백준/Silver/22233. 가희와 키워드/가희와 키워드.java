

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

        //set을 쓰는게 오히려 더 나을지도?
        Set<String> set = new HashSet<>();
        for (int i=0;i<keywordCnt;i++){
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int cnt = keywordCnt;
        //for : articleCnt, 쉼표로 구분해서 받기
        for (int i=0;i<articleCnt;i++){
            st =new StringTokenizer(br.readLine(),",");
            while (st.hasMoreElements()){
                //key를 받음
                String key = st.nextToken();

                //set에서 key지움
                set.remove(key);
            }
            sb.append(set.size()).append("\n");

        // 꼭 마지막에는 엔터를 안 붙여야 하는가?

            

        }
        System.out.println(sb);


    }
}
