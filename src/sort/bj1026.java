package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * bj1026.java
 * 백준 1026번 : 보물
 * version 1.0
 * data 2020.05.22
 */


public class bj1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int A[] = new int[n];
		for(int i=0;i<n;i++)
			A[i] = s.nextInt();
		
		int B[] = new int[n];
		for(int i=0;i<n;i++)
			B[i] = s.nextInt();		
		
		Integer temp[] = new Integer[n];
		for(int i=0;i<n;i++)
			temp[i] = B[i];		
		
		Arrays.sort(A);
		Arrays.sort(temp,Collections.reverseOrder()); // 내림차순정렬
		
		int S=0;
		for(int i=0;i<n;i++)
			S += A[i]*temp[i];
		
		System.out.println(S);
	}

}
