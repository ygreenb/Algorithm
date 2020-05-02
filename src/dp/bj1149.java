package dp;
/*
 * bj1463.java
 * 백준 1149번 : RGB거리 
 * version 1.0
 * data 2020.04.28
 */

import java.util.Scanner;

public class bj1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 집의 수 입력 받음
		
		int[][] list = new int[n][3]; // 각 집을 칠하는 비용을 넣는 배열
		int[][] dp = new int[n][3]; // 모든 집을 칠하는 비용
		
		for(int i=0;i<n;i++) {
			for (int j=0;j<3;j++) {
				list[i][j] = s.nextInt();				
			}
		}
		
		// 첫번째 집 칠하는 비용 넣어줌
		dp[0][0] = list[0][0];
		dp[0][1] = list[0][1];
		dp[0][2] = list[0][2];
		
		// 비용의 최솟값 구해서 갱신
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+list[i][0]; // i번째에 R을 칠할 경우
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+list[i][1]; // i번째에 G을 칠할 경우
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+list[i][2]; // i번째에 B을 칠할 경우
		}
		
		System.out.println(Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
		s.close();
	}

}
