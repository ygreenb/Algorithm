package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * bj11724.java
 * 백준 11724번 : 연결 요소와 개수
 * version 1.0
 * data 2020.05.23
 */

public class bj11724 {
	private static int n, m, v; 
	private static int[][] map; 
	private static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt(); // 정점의 개수
		m = s.nextInt(); // 간선의 개수
		
		map = new int[n+1][n+1]; 
		while(m-->0) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			map[x][y]=map[y][x]=1;
		}
	
		int cnt=0; // 연결 요소의 개수
		visit = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			if(!visit[i]) { // 방문한 적 없었을 때
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
		
	}
	static void dfs(int s) {
		if(visit[s]) { // 이미 방문한 적 있으면
			return; // 넘어감
		}
		
		visit[s] = true; // 방문

		for(int i=1;i<=n;i++) {
			if(map[s][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
}
