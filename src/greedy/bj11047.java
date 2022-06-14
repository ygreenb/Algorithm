package greedy;
/*
 * bj11047.java
 * ���� 11047�� : ���� 0
 * version 1.0
 * data 2022.06.15
 */

import java.util.Scanner;

public class bj11047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // �����ǰ���
		int k = s.nextInt(); // ������� ��ġ�� ��
		
		int[] a = new int[n]; // ���� ��ġ
		for(int i=0;i<n;i++) {
			a[i] = s.nextInt();
		}
		
		int count=0;
		for(int i = n-1; i>=0;i--) {
			// ���� ������ ��ġ�� K���� �ʰ����� �ʾƾ߸� ����
			if(a[i] <=k) {
				// ���� ������ ��ġ�� ���Ҽ� �ִ� ���� ������
				count += (k/a[i]);
				k = k % a[i];
			}
		}
		
		System.out.println(count);
		s.close();
	}

}
