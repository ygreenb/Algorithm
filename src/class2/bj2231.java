package class2;
/*
 * bj1085.java
 * ���� 2231�� : ������
 * version 1.0
 * data 2022.09.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2231 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N_len = str.length(); // �ڿ����� ����
		int N = Integer.parseInt(str);
		int answer = 0;
		
		// N-(N�� �ڸ���*9)���� N���� ���Ʈ Ž��
		for(int i=N-(N_len*9);i<N;i++) {
			int number = i;
			int sum = 0; // �ڸ����� ��
			
			// ���� 0�� �� ������ 10���� ���� �������� ��, �� �ڸ����� ���� ����
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum+i==N) { // i�� �ڸ��� �������� N�� ��
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
	}

}
