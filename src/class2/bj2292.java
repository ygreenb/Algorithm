package class2;

/*
 * bj1085.java
 * น้มุ 2292น๘ : น๚มý
 * version 1.0
 * data 2022.09.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2292 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x = 1;
		int result = 1;
		
		while(N > x) {
			if(N==x) break;
			x += 6*result; // 7 19 37 61
			result++;
		}
		
		System.out.println(result);
		
	}
}
