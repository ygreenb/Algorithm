package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * bj1260.java
 * 백준 1260번 : DFS와 BFS
 * version 1.0
 * data 2020.05.23
 */

public class bj1260 {
	private static int n, m, v; 
	private static int[][] map; 
	private static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt(); // 정점의 개수
		m = s.nextInt(); // 간선의 개수
		v = s.nextInt(); // 탐색 시작할 정점의 번호
		
		map = new int[n+1][n+1]; 
		while(m-->0) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			map[x][y]=map[y][x]=1;
		}
		visit = new boolean[n+1];
		dfs(v);
		
		System.out.println("");
		
		visit = new boolean[n+1];
		bfs(v);
		
	}
	static void dfs(int s) {
		if(visit[s]) { // 이미 방문한 적 있으면
			return; // 넘어감
		}
		
		visit[s] = true; // 방문
		System.out.print(s+" ");

		for(int i=1;i<=n;i++) {
			if(map[s][i] == 1) {
				dfs(i);
			}
		}
		
	}
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s); // 큐에 첫번쩨 데이터 넣음
		visit[s] = true;
		
		while(!q.isEmpty()) { // 2번째부터 방문
			// 큐의 첫번째 데이터를 미리 빼주고 시작
			int temp = q.poll();
			System.out.print(temp+" ");
			
			for(int i=1;i<=n;i++) { // 차례대로 큐에 넣어줌
				if(map[temp][i]==1 && !visit[i]){
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	
}
