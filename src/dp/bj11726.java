package dp;

import java.util.Scanner;

/*
 * bj11726.java
 * 백준 11726번 : 2xn 타일링
 * version 1.0
 * data 2020.05.08
 */
public class bj11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // n 입력받음
	
		int dp[] = new int[1001];
		
		dp[0] = 0; // 초기화 안해주면 런타임 에러
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
		
	}

}
