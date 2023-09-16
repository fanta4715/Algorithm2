

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //N받기
        int N = Integer.parseInt(br.readLine());

        //for N 수열 받기
        int[] arr = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //투포인터 구현
        //초기 상태? left,right=0
        //while을 통해서 right늘리면서 판단하자.
        // cnt배열을 통해서 left이동할 때 마다 넣어주자.
        int left=0,right=0;
        Set<Integer> exist =new HashSet<>();
        exist.add(arr[0]);
        long answer=0L;
        while(left<N){
            //left가 N-1이되면 종료임. 이 상황에서는 right==left==N-1임.

            //left가 늘어나는 경우 (이 left에서 볼 수 있는 최대길이를 찍었음)
            //1. right를 넣을 시, 조건에 부합하지 않을 경우
            //  *여기서 left==right라면 둘다 ++해주어야 함.
            //2, right가 끝까지 간 경우
            if (right==N-1){
                answer+=right+1-left;
                exist.remove(arr[left]);
                left++;
                continue;
            }
            int nextNum = arr[right+1];
            if (exist.contains(nextNum)) {
                answer+=right+1-left;
                exist.remove(arr[left]);
                left++;

                if (left==right+1) {
                    right++;
                    exist.add(nextNum);
                }
            }

            //right가 늘어나는 경우
            //1. right를 넣어도 조건에 부합하는 경우
            else{
                right++;
                exist.add(nextNum);
            }


            //1. right가 마지막에 도달했을 때
            //2. else right늘리기 가능할 때 늘림
            //        right늘리면 조건 안 맞을 때 left도 같이 늘림
            //그냥 left늘릴 타이밍에 cnt늘려주면 될 듯?
        }

        System.out.println(answer);
    }
}
