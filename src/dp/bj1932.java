package dp;

import java.util.Scanner;

/*
 * bj2293.java
 * 백준 1932번 : 정수삼각형
 * version 1.0
 * data 2020.05.15
 */

public class bj1932 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 삼각형의 크기 n 입력받음
		
		// 정수삼각형 입력받음
		int list[][] = new int[501][501];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				list[i][j]=s.nextInt();
			}	
		}
		
		// 경로의 합과 최대값 구함
		int [][] dp = new int[501][501];
		int max=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(j==1) dp[i][1]=dp[i-1][1]+list[i][1]; // 맨 왼쪽 줄
				dp[i][j]=Math.max(dp[i-1][j-1],	dp[i-1][j])+list[i][j];
				if(j==i)dp[i][i]=dp[i-1][i-1]+list[i][i]; // 맨 오른쪽 줄
				max = Math.max(max, dp[i][j]);
			}			
		}
		
		System.out.println(max);
		s.close();
	}
}
