package class2;
/*
 * bj1085.java
 * 백준 2231번 : 분해합
 * version 1.0
 * data 2022.09.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2231 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N_len = str.length(); // 자연수의 길이
		int N = Integer.parseInt(str);
		int answer = 0;
		
		// N-(N의 자릿수*9)부터 N까지 브루트 탐색
		for(int i=N-(N_len*9);i<N;i++) {
			int number = i;
			int sum = 0; // 자리수의 합
			
			// 몫이 0이 될 때까지 10으로 나눈 나머지의 합, 즉 자리수의 합을 구함
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum+i==N) { // i와 자리수 누적합이 N일 때
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
	}

}
