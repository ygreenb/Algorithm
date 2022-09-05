class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];; // 실패율 높은 스테이지 순(같다면 오름차순)
        int[] noclear = new int[N]; // 해당 스테이지에 머물러있는 플레이어 수
        double[] fail = new double[N]; // 스테이지별 실패율 
        
        for(int stage : stages){
            if(stage != N+1) noclear[stage-1]++;
        }
        
        int player = stages.length; // 스테이지 도달 플레이어 수
        for(int i=0;i<N;i++){
            fail[i] = (double)noclear[i]/player;
            player -= noclear[i];
            answer[i] = i+1; // 스테이지 저장
        }
        
        double tmpf = 0;
        int tmpa = 0;
        for(int i=0;i<N;i++){
            for(int j=1; j<N-i;j++){
                if(fail[j-1]<fail[j]){
                    tmpf=fail[j-1];
                    fail[j-1]=fail[j];
                    fail[j]=tmpf;
                    
                    tmpa=answer[j-1];
                    answer[j-1]=answer[j];
                    answer[j]=tmpa;
                }
            }
        }
        
        return answer;
    }
}