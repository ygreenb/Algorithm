// 프로그래머스 : 신고결과받기

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일을 받은 횟수
        HashMap<String, Integer> idMap = new HashMap<>(); // 유저 순서저장
        HashMap<String, HashSet<String>> map = new HashMap<>(); // 각 유저별 자신을 신고한 유저 set
        
        // init
        for(int i=0; i<id_list.length;i++){
            idMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }
        
        // 자신을 신고한 유저이름 저장
        for(String r : report){
            String[] str = r.split(" ");
            map.get(str[1]).add(str[0]);
        }
        
        // 유저별 신고당한 횟수가 k보다 많으면 메일보냄
        for(int i=0; i<id_list.length;i++){
            HashSet<String> set = map.get(id_list[i]); // 해당 유저를 신고한 유저 set
            if(set.size() >= k){
                for(String userId : set){
                    // userId가 동일한 순서 answer증가
                    answer[idMap.get(userId)]++;
                }
            }
        }
        
        return answer;
    }
}