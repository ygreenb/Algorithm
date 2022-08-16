/*
 * bj4153.java
 * 백준 4153번 : 직각삼각형
 * version 1.0
 * data 2022.08.17
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4153 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String[] inputs = br.readLine().split(" ");
			int x= Integer.parseInt(inputs[0]);
			int y= Integer.parseInt(inputs[1]);
			int z= Integer.parseInt(inputs[2]);
			
			if(x==0&&y==0&&z==0)
				break;
			
			if(x*x+y*y==z*z) 
				System.out.println("right");
			else if(y*y+z*z==x*x) 
				System.out.println("right");
			else if(x*x+z*z==y*y) 
				System.out.println("right");
			else 
				System.out.println("wrong");
		}
	}
}
