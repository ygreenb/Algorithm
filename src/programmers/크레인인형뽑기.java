import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 터트려 사라진 인형개수
        ArrayList<Integer> dolls = new ArrayList<>(); // 바구니
        
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                int doll = board[i][move-1];
                board[i][move-1] = 0; // 인형뽑음
                if(doll != 0){
                    // int last = dolls.size()-1;
                    if(dolls.size() == 0) dolls.add(doll); // 첫번째뽑기
                    else if(doll != dolls.get(dolls.size()-1)) {dolls.add(doll); } // 바구니에 넣음
                    else { dolls.remove(dolls.size()-1); answer += 2;} // 터짐
                    break;
                }
            }
        }
        
        return answer;
    }
}