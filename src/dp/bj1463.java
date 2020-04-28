package dp;

import java.util.Scanner;

/*
 * bj1463.java
 * 백준 1463번 : 1로 만들기 
 * version 1.0
 * data 2020.04.25
 */

//Top down
public class bj1463 {
	static int[] C; // 최소연산횟수 저장해놓는 배열 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 정수입력받음
		
		C = new int[n+1]; // 배열크기 지정
		
		System.out.println(make1(n));
		s.close();
		
	}
	public static int make1(int n){
		if (n==1) return 0;
		if (C[n]!=0) return C[n];
		C[n] = make1(n-1)+1; 
		if(n%2==0) C[n] = Math.min(C[n], make1(n/2)+1);
		if(n%3==0) C[n] = Math.min(C[n], make1(n/3)+1);
		return C[n];
	}
	

}

/*
//Bottom up
public class bj1463 {
	static int[] C;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 정수입력받음
		
		C = new int[n+1];
		
		System.out.println(make1(n));
		s.close();
		
	}
	
	public static int make1(int n){
		if (n==1) return 0;
		if (C[n]!=0) return C[n];	
		for(int i=2; i<=n;i++) {
			C[i] = make1(i-1)+1;
			if(n%2==0) C[i] = Math.min(C[i], make1(i/2)+1);
			if(n%3==0) C[i] = Math.min(C[i], make1(i/3)+1);
		}
		return C[n];
	}

}
*/