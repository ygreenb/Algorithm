package greedy;
/*
 * bj11047.java
 * 백준 11047번 : 동전 0
 * version 1.0
 * data 2022.06.15
 */

import java.util.Scanner;

public class bj11047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 동전의개수
		int k = s.nextInt(); // 만드려는 가치의 합
		
		int[] a = new int[n]; // 동전 가치
		for(int i=0;i<n;i++) {
			a[i] = s.nextInt();
		}
		
		int count=0;
		for(int i = n-1; i>=0;i--) {
			// 현재 동전의 가치가 K보다 초과되지 않아야만 가능
			if(a[i] <=k) {
				// 현재 동전의 가치로 더할수 있는 개수 더해줌
				count += (k/a[i]);
				k = k % a[i];
			}
		}
		
		System.out.println(count);
		s.close();
	}

}
