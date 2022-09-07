import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String,String> map = new TreeMap<String,String>(); // 차량번호, 주차 입/출 기록
        TreeMap<String,Integer> cumTime = new TreeMap<String,Integer>(); // 차량번호, 주차시간->요금
        
        // 주차 입/출 기록
        for(String record : records){   
            String[] r = record.split(" ");
            if(map.get(r[1])!=null) map.put(r[1],map.get(r[1])+" "+r[0]);
            else map.put(r[1], r[0]);
        }
        
        // 누적 주차 시간, 요금 계산
        for(String key : map.keySet()){
            // 주차시간(분) 구함
            cumTime.put(key,getCumulativeTime(map.get(key)));
            // System.out.println(key+" : "+cumTime.get(key));
            // 주차시간 -> 요금변환
            cumTime.put(key,ParkingFee(fees, cumTime.get(key)));
            // System.out.println(key+" : "+cumTime.get(key));
        }
        
        // 요금 출력
        int idx=0, answer[] = new int[cumTime.size()];;
        for(Integer cost : cumTime.values()){
            answer[idx++] = cost;
        }    
        
        return answer;
    }
    
    // 누적 주차 시간 구하는 함수
    public int getCumulativeTime(String s){
        String[] time = s.split(" ");
        int cum = 0;
        for(int i=0;i<time.length;i+=2){
            if(i+1==time.length) cum += HourtoMinute("23:59")-HourtoMinute(time[i]);
            else cum += HourtoMinute(time[i+1])-HourtoMinute(time[i]);
        }
        return cum;
    }
    
    public int HourtoMinute(String s){
        return Integer.valueOf(s.substring(0,2))*60 + Integer.valueOf(s.substring(3,5));
    }
    
    // 주차 요금 구하는 함수
    public int ParkingFee(int[] fees, int time){
        // 기본 시간 이하 => 기본요금
        if(time <= fees[0]) return fees[1];
        // 기본시간 초과 -> 기본요금 + 단위마다 단위요금 청구
        else return fees[1] + (int) Math.ceil((double)(time-fees[0])/fees[2]) * fees[3];
    }
}
