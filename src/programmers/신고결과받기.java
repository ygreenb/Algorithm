// ���α׷��ӽ� : �Ű����ޱ�

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // ������ ���� Ƚ��
        HashMap<String, Integer> idMap = new HashMap<>(); // ���� ��������
        HashMap<String, HashSet<String>> map = new HashMap<>(); // �� ������ �ڽ��� �Ű��� ���� set
        
        // init
        for(int i=0; i<id_list.length;i++){
            idMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }
        
        // �ڽ��� �Ű��� �����̸� ����
        for(String r : report){
            String[] str = r.split(" ");
            map.get(str[1]).add(str[0]);
        }
        
        // ������ �Ű���� Ƚ���� k���� ������ ���Ϻ���
        for(int i=0; i<id_list.length;i++){
            HashSet<String> set = map.get(id_list[i]); // �ش� ������ �Ű��� ���� set
            if(set.size() >= k){
                for(String userId : set){
                    // userId�� ������ ���� answer����
                    answer[idMap.get(userId)]++;
                }
            }
        }
        
        return answer;
    }
}