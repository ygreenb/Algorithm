package binarysearch;

/*
 * bj2512.java
 * 백준 2512번 : 예산
 * 파라메트릭 서치로 풀기
 * data 2022.07.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2512_2{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		
		int left = 0, right = -1;
		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, budgets[i]); // 예산 최대금액
		}
		
		int M = Integer.parseInt(br.readLine()); // 전체예산 
		while(left<=right){
			int mid = (left+right)/2; // 상한액. 중간부터 탐색
			long budget = 0;
			for(int i=0; i<N;i++){
				// mid가 현재예산보다 작으면 budget에 더해줌 
				if(budgets[i]>mid) budget += mid;
				// 현재예산이 mid보다 작으면 budget에 현재예산 더해줌
				else budget+= budgets[i];
//				System.out.println("mid "+mid +"budget "+budget);
			}
//			System.out.println("left "+left +" right "+right);
			// 예산이 총량에 도달x
			if(budget<=M) {
				left = mid+1;
			}else { //예산초과
				right = mid-1;
			}
		}
		
		System.out.println(right);
		
	}
}
