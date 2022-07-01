package binarysearch;

/*
 * bj2512.java
 * ���� 2512�� : ����
 * data 2022.07.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2512{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ������ ��
		
		// ������ �����û
		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // ��ü����
		
		int avg = M/N; // ���
		int cnt = N;
		
		Arrays.sort(budgets);
		
		// �����û�� ��պ��� ������ ����, ũ�� break
		for(int i=0;i<N;i++) {
			if(budgets[i]<avg) {
				if(i==N-1) { // ��� ������ ���������� ��
					avg= budgets[i];
					break;
				}
				cnt--;
				M -= budgets[i];
				avg = M/cnt; // (���� ��ü����)/(��������� ���� ���� ��)
			}else {
				break;
			}
		}

		System.out.println(avg);
		
	}
}
