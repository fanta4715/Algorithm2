

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // H, W받기
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int height[] =new int[W];
        //for W 배열 채우기
        st =new StringTokenizer(br.readLine());
        for (int i=0;i<W;i++){
            height[i]=Integer.parseInt(st.nextToken());
        }

        //for H
        // for W 로 사이값 구하기
        int rain =0;
        for (int i=1;i<=H;i++){
            boolean left=false;
            int temp =0;
            for (int j=0;j<W;j++){
                //left가 없는 경우
                //1. 얘 높이가 i보다 낮으면 continue;
                //2. 얘 높이가 i보다 크면, left=true하고 continue
                if (!left){
                    if (height[j]>=i) left=true;
                    continue;
                }
                //left가 있는 경우
                // 1. 얘 높이가 i보다 낮으면, temp++;
                // 2. 얘 높이가 i보다 크면, temp를 rain에 집어넣고,
                // 0으로 초기화
                else{
                    if (height[j]>=i) {
                        rain+=temp;
                        temp=0;
                    }
                    else temp++;
                }

            }
        }
        System.out.println(rain);
        //그냥 2중 for문으로 처리가능

    }
}

//Stack<Integer> stack = new Stack<>();
//        //W만큼 건물 받기
//        st=new StringTokenizer(br.readLine());
////        int rain =0;
////        for (int i=0;i<W;i++){
////            int height = Integer.parseInt(st.nextToken());
////            //스택이 비어있고, 높이가 0이 아닌 경우 stack에 push
////            if (stack.isEmpty() && height!=0) {
////                stack.push(height);
////                continue;
////            }
////
////            //스택의 첫 값보다 작다면 push
////            if (stack.get(0)>height) stack.push(height);
////            //스택의 첫 값보다 크다면 pop해서 값을 합산함
////            else {
////                int size = stack.size();
////                for (int j=0;j<size-1;j++){
////                    rain+=stack.get(0)-stack.pop();
////                }
////
////                //첫 기준도 pop
////                stack.pop();
////
////                //그리고 이번 height를 다시 넣음
////                stack.push(height);
////            }
////
////        }
////
////
////        System.out.println(rain);
////        //스택에서 비교를 할 것임
////        //스택의 첫 값보다 작으면, 계속 스택에 push
////        // 스택의 첫 값 이상이 나오면, 첫 값을 바탕으로 스택의 값 빼내면서 값 합산
////
////
