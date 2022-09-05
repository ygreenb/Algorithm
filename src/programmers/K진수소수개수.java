class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";
        while(n>0){
            s = n%k + s;
            n /= k;
        }
        
        int i,j=0;
        for(i=0; i<s.length();i=j){
            for(j = i+1; j<s.length() && s.charAt(j)!='0';j++);
            if(isPrime(Long.parseLong(s.substring(i,j)))) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n==0||n==1) return false;
        else if(n == 2) return true;
        for(int i=2;i <= Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}