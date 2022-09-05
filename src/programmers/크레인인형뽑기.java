import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // ��Ʈ�� ����� ��������
        ArrayList<Integer> dolls = new ArrayList<>(); // �ٱ���
        
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                int doll = board[i][move-1];
                board[i][move-1] = 0; // ��������
                if(doll != 0){
                    // int last = dolls.size()-1;
                    if(dolls.size() == 0) dolls.add(doll); // ù��°�̱�
                    else if(doll != dolls.get(dolls.size()-1)) {dolls.add(doll); } // �ٱ��Ͽ� ����
                    else { dolls.remove(dolls.size()-1); answer += 2;} // ����
                    break;
                }
            }
        }
        
        return answer;
    }
}