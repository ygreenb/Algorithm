package greedy;
/*
 * bj1931.java
 * ���� 1931�� : ȸ�ǽǹ���
 * version 1.0
 * data 2022.06.15
 */

import java.util.Arrays;
import java.util.Scanner;

public class bj1931 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // ȸ���� ��
		
		int[][] meetingtime  = new int[n][2]; // ȸ�� ����, ����ð�
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++)
				meetingtime[i][j] = s.nextInt();
		}
		
		Arrays.sort(meetingtime, (o1, o2) -> {
			if(o1[1]==o2[1]) {
//				return Integer.compare(o1[1],o2[1]);
				return o1[0]-o2[0];
			}else
				return o1[1]-o2[1];
		});
		
		// ���� Ȯ��
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<2;j++) {
//				System.out.print(meetingtime[i][j]+" ");	
//			}
//			System.out.println();
//		}
		
		int count = 1, current = meetingtime[0][1]; // ù���� ȸ�� ����
		for(int i=1;i<n;i++) { // 2���� ȸ�Ǻ��� ����ð��� ���۽ð� ��
			// ����ð��� ���ų� �̻��� ȸ�Ǹ� ����
			if(current <= meetingtime[i][0]) {
				current = meetingtime[i][1]; // ����ð� �־���
				count++;
//				System.out.println("("+meetingtime[i][0]+", " +meetingtime[i][1]+")");
			}
		}
		
		System.out.println(count);
		s.close();
	}

}
