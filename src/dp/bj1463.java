package dp;

import java.util.Scanner;

/*
 * bj1463.java
 * 백준 1463번 : 1로 만들기
 * version 1.0
 * data 2020.04.25
 */

public class bj1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int x = s.nextInt(); // 정수입력받음
		int count = 0;
		while(x != 1) {
			count++;
			if(x % 3 == 0) {
				x=x/3;
			}else if((x-1) % 3 == 0) {
				x--;
			}
			else if (x % 2 == 0) {
				x=x/2;
			}else {
				x--;
			}
		}
		System.out.println(count);
		
	}

}
