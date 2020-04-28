package dp;
/*
 * bj1463.java
 * 백준 1256번 : 포도주 시식
 * version 1.0
 * data 2020.04.29
 */
import java.util.Scanner;

public class bj2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 포도잔 수 입력 받음
		
		int[] p = new int[n]; // 포도주의 양
		int[] dp = new int[n]; // 최대로 마실 수 있는 포도주의 양
		
		for (int i=0;i<n;i++) {
			p[i]=s.nextInt();
		}
		
		if(n>=1) dp[0]=p[0];
		if(n>=2) dp[1]=p[0]+p[1];
		if(n>=3) dp[2]= Math.max(Math.max(dp[1], dp[0]+p[2]),p[1]+p[2]);
		for(int i=3;i<n;i++) {
			dp[i]=Math.max(Math.max(dp[i-1], dp[i-2]+p[i]),dp[i-3]+p[i-1]+p[i]);
		}
		
		System.out.println(dp[n-1]);
		s.close();
	}

}
