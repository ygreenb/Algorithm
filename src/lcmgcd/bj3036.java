package lcmgcd;

import java.util.Scanner;

/*
 * bj3036.java
 * 백준 3036번 : 링
 * version 1.0
 * data 2020.05.16
 */

public class bj3036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 링의 개수 n개
		
		int r[] = new int[n+1]; // 링의 반지름
		for(int i=1;i<=n;i++)
			r[i]=s.nextInt();
		
		for(int i=2;i<=n;i++) {
			int gcd = gcd(Math.max(r[1], r[i]),Math.min(r[1], r[i]));
			System.out.print(r[1]/gcd); //분자
			System.out.print("/"); // 분수 막대
			System.out.println(r[i]/gcd); //분모
			
		}
	}
	// 최대 공약수 구하는 함수
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}


}
