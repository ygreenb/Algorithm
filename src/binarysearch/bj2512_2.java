package binarysearch;

/*
 * bj2512.java
 * ���� 2512�� : ����
 * �Ķ��Ʈ�� ��ġ�� Ǯ��
 * data 2022.07.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2512_2{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ������ ��
		
		int left = 0, right = -1;
		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, budgets[i]); // ���� �ִ�ݾ�
		}
		
		int M = Integer.parseInt(br.readLine()); // ��ü���� 
		while(left<=right){
			int mid = (left+right)/2; // ���Ѿ�. �߰����� Ž��
			long budget = 0;
			for(int i=0; i<N;i++){
				// mid�� ���翹�꺸�� ������ budget�� ������ 
				if(budgets[i]>mid) budget += mid;
				// ���翹���� mid���� ������ budget�� ���翹�� ������
				else budget+= budgets[i];
//				System.out.println("mid "+mid +"budget "+budget);
			}
//			System.out.println("left "+left +" right "+right);
			// ������ �ѷ��� ����x
			if(budget<=M) {
				left = mid+1;
			}else { //�����ʰ�
				right = mid-1;
			}
		}
		
		System.out.println(right);
		
	}
}
