package dp;

import java.util.Scanner;

public class bj1890 {
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		n= s.nextInt(); // 게임판의 크기
		int list[][] = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				list[i][j] = s.nextInt();
			}
		}
		
		long dp[][] = new long[n+1][n+1]; // 경로의 개수는 2^63-1보다 작거나 같으니 long타입
		dp[1][1]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int next = list[i][j];
				if(next==0) break;
				// if(i==n&&j==n) continue;// 위에랑같은문장.. 해당 반복문만 빠져나감.
				if(j+next<=n) dp[i][j+next] += dp[i][j];
				if(i+next<=n) dp[i+next][j] += dp[i][j];
			}		
			
			// dp 변화 출력확인
			//print(dp);
            //System.out.println();
		}
		System.out.println(dp[n][n]);
	}
	 public static void print(long[][] dp){
	        for(int i=1; i<=n; i++){
	            for(int j=1; j<=n; j++){
	                System.out.print(dp[i][j]+" ");
	            }
	        System.out.println();
	        }
	        
	  }
}
