// 숫자 문자열과 영단어
class Solution {
    public int solution(String s) {
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<number.length;i++){
            if(s.contains(number[i])) {
                s = s.replaceAll(number[i],String.valueOf(i));    
            }
        }
        int answer = Integer.valueOf(s);
        return answer;
    }
}
