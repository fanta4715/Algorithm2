class Solution {
    int[] dh = {-1, 0, 1, 0};
    int[] dw = {0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {
        //4방향
        int answer = 0;
        for (int i=0; i<4; i++){
            int nextH = h+dh[i];
            int nextW = w+dw[i];
            if (!outOfIndex(nextH, nextW, board) && board[nextH][nextW].equals(board[h][w])) answer++;
        }
        return answer;
    }
    
    public boolean outOfIndex(int nextH, int nextW, String[][] board) {
        if (nextH < 0 || nextH >= board.length || nextW < 0 || nextW >= board[0].length) return true;
        return false;
    }
}