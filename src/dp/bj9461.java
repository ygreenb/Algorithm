package dp;

import java.util.Scanner;

/*
 * bj9461.java
 * 백준 9461번 : 파도반 수열
 * version 1.0
 * data 2020.05.08
 */
public class bj9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		long P[] = new long[101]; // int형 주면 틀림
		
		P[0] = 0;
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;

		for(int i=6;i<101;i++) {
			P[i] = P[i-1]+P[i-5];
		}	
		
		int T = s.nextInt(); // 테스트 케이스의 개수 T
		for(int t=0;t<T;t++) {
			int n = s.nextInt(); // N 입력받음
			System.out.println(P[n]);
		}
		
		s.close();
	}
}
