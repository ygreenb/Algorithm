package dp;

import java.util.Scanner;

/*
 * bj14501.java
 * 백준 14501번 : 퇴사
 * version 1.0
 * data 2020.05.15
 */

public class bj14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 남은 일기간
		
		int t[] = new int[n+5]; // 상담을 완료하는데 걸리는 시간
		int p[] = new int[n+5]; // 상담을 마쳤을때 받는 금액
		for(int i=1;i<=n;i++) {
			t[i] = s.nextInt();
			p[i] = s.nextInt();
		}

		int dp[] = new int[n+5]; // 얻을 수 있는 최대이익
		int max=0;
		

		for(int i=1;i<=n;i++) { // n+1일까지 구하는 이유는 마지막날+1일일경우까지 구해야해서
			dp[i] = Math.max(dp[i], max); // i일까지 일했을 최대이익값으로 dp[i]도 새로 갱신해줌
			dp[i+t[i]-1] = Math.max(dp[i+t[i]-1], dp[i]+p[i]);
			max = Math.max(max, dp[i]); // i일까지 일했을 때 최대이익
		}
		
		System.out.println(max);
		s.close();
	}

}
