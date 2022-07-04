package backtracking;
/*
 * bj15649.java
 * ���� 15649�� : N�� M (1)
 * version 1.0
 * data 2022.07.04
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {

	static int N,M;
	static boolean[] visit;
	static int ans[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		ans = new int[M];
		// 1~N ���� �ߺ����� M�� ���
		getNext(0);
		System.out.println(sb);
		
	}

	public static void getNext(int depth) {
		if(depth == M) {
			// ���� M�� ä������ ���
			for(int a : ans)
				sb.append(a).append(' ');
			sb.append('\n');
			return;
		}

		for(int i=1;i<=N;i++) {	
			if(!visit[i]) {
				visit[i]=true;
				ans[depth] = i;
				getNext(depth+1); // ���ȣ��
				// �ڽĳ�� �湮 �� �湮�ʱ�ȭ
				visit[i]=false;
				
			}
		}
	};
	
}