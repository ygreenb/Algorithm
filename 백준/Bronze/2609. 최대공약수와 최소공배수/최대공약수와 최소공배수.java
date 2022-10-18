import java.util.Scanner;

/*
 * bj2609.java
 * 백준 2609번 : 최대공약수와 최소공배수
 * version 1.0
 * data 2020.05.15
 */

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int a= s.nextInt();
		int b= s.nextInt();
	
		System.out.println(gcd(a,b)); // 최대공약수 출력
		System.out.println(a*b/gcd(a,b)); // 최소공배수 출력
		
		s.close();
		
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
