package binarysearch;

/*
 * bj2512.java
 * 백준 2512번 : 예산
 * data 2022.07.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2512{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		
		// 지방의 예산요청
		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // 전체예산
		
		int avg = M/N; // 평균
		int cnt = N;
		
		Arrays.sort(budgets);
		
		// 예산요청이 평균보다 작으면 배정, 크면 break
		for(int i=0;i<N;i++) {
			if(budgets[i]<avg) {
				if(i==N-1) { // 모든 예산을 배정해줬을 때
					avg= budgets[i];
					break;
				}
				cnt--;
				M -= budgets[i];
				avg = M/cnt; // (남은 전체예산)/(예산배정이 남은 지방 수)
			}else {
				break;
			}
		}

		System.out.println(avg);
		
	}
}
