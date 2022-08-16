/*
 * bj1085.java
 * 백준 1085번 : 직사각형에서 탈출
 * version 1.0
 * data 2022.08.17
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1085 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int w= Integer.parseInt(st.nextToken());
		int h= Integer.parseInt(st.nextToken());

		// 각 경계선 까지 가는 거리의 최솟값을 구함
		int min = Math.min(Math.min(x, w-x),Math.min(y, h-y));
		System.out.println(min);
	}

}
