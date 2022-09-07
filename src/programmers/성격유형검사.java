import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        int[] score = {0,3,2,1,0,3,2,1};
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 타입별 점수 기록 초기화
        for(char[] t:type) {
            map.put(t[0],0);
            map.put(t[1],0);
        }
        
        // 점수 기록
        for(int i = 0; i<survey.length; i++){
            if(choices[i] < 4)
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+score[choices[i]]);
            else
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+score[choices[i]]);    
        }

        // 유형 선택
        StringBuilder sb = new StringBuilder();
        for(char[] t : type){
            sb.append(
               (map.get(t[0])>=map.get(t[1]))?t[0]:t[1] 
            );
        }
        
        return sb.toString();
    }
}
