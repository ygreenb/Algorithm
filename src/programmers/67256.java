// 프로그래머스 : 키패드 누르기
class Solution {
    public String answer = "";
    public int left = 10, right = 12; // 엄지위치
    public String solution(int[] numbers, String hand) {
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7) selectLeft(n);
            else if(n == 3 || n == 6 || n == 9) selectRight(n);
            else {
                if(n==0) n=11;
                int l_dis = Math.abs(n-left)/3 + Math.abs(n-left)%3; // 상하+좌우 거리구함
                int r_dis = Math.abs(n-right)/3 + Math.abs(n-right)%3;
                if(l_dis<r_dis) selectLeft(n);
                else if(l_dis>r_dis) selectRight(n);
                else {
                    if(hand.equals("left")) selectLeft(n);
                    else selectRight(n);
                    
                }
            }
        }
        return answer;
    }
    public void selectLeft(int n){
        answer+='L';
        left=n;
    }
    public void selectRight(int n){
        answer+='R';
        right=n;
    }
}
