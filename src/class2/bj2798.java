package class2;
/*
 * bj1325.java
 * 백준 2798번 : 블랙잭
 * version 1.0
 * data 2022.09.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2798 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] inputs = br.readLine().split(" ");
		int[] cards = new int[N];
		for(int i=0;i<N;i++) {
			cards[i]=Integer.parseInt(inputs[i]);
		}

		int result = 0;
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					int sum = cards[i]+cards[j]+cards[k];
					if(sum<=M) result = Math.max(result, sum);
				}
			}
		}
		System.out.println(result);
	}
}
