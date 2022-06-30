package backtracking;
/*
 * bj9663.java
 * 백준 9663번 : N-Queen
 * version 1.0
 * data 2022.06.23
 */

import java.util.Scanner;

public class bj9663 {
	
	public static int[] X;
	public static int N;
	public static int count=0;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		X = new int[N];
		
		nQueen(0);
		System.out.println(count);
		s.close();
	}
	
	// GETNEXT() 재귀적으로 구현
	public static void nQueen(int depth) {
		// X의 모든 원소를 다 채웠다면 count증가
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			X[depth] = i;
			// BOUND를 만족하면 즉,놓을 수 있다면 재귀호출(다음 행으로 넘어감)
			// false의 경우 가지치기, 다음 열(i+1)으로 넘어감
			if(BOUND(depth)) {
				nQueen(depth+1); // 다음행 재귀호출
			}
		}
		
	}

	// 노드가 유망한지 검사하는 함수
	public static boolean BOUND(int row) {
		for(int i=0;i<row;i++) { // 행(가로)의 수만큼 반복
			// 일직선(같은 열)으로 놓여있는 경우
			if(X[row]==X[i]) {
				return false;
			}
			// 대각선으로 놓여있는 경우
			else if(Math.abs(row-i)==Math.abs(X[row]-X[i])){
				return false;
			}
		}
		return true;
	}

}
