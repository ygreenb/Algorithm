package backtracking;
/*
 * bj9663.java
 * ���� 9663�� : N-Queen
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
	
	// GETNEXT() ��������� ����
	public static void nQueen(int depth) {
		// X�� ��� ���Ҹ� �� ä���ٸ� count����
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			X[depth] = i;
			// BOUND�� �����ϸ� ��,���� �� �ִٸ� ���ȣ��(���� ������ �Ѿ)
			// false�� ��� ����ġ��, ���� ��(i+1)���� �Ѿ
			if(BOUND(depth)) {
				nQueen(depth+1); // ������ ���ȣ��
			}
		}
		
	}

	// ��尡 �������� �˻��ϴ� �Լ�
	public static boolean BOUND(int row) {
		for(int i=0;i<row;i++) { // ��(����)�� ����ŭ �ݺ�
			// ������(���� ��)���� �����ִ� ���
			if(X[row]==X[i]) {
				return false;
			}
			// �밢������ �����ִ� ���
			else if(Math.abs(row-i)==Math.abs(X[row]-X[i])){
				return false;
			}
		}
		return true;
	}

}
