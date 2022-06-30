package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * bj1697.java
 * 백준 1697번 : 숨바꼭질
 * version 1.0
 * data 2022.06.30
 */

public class bj1697{
	static int N, K;
	static int[] visited = new int[100001];
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] inputs = input.split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);
		
		if(N==K) { 
			answer=0;
		}else{
			bfs(N);
		}

		System.out.println(answer);
		
	}
	
	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(node);
		visited[node] = 1;
		
		while(!queue.isEmpty()) {
			node = queue.remove();
			if(node==K) {
				// 답에 도달하면 return
				answer = visited[node]-1;
				return;
			}
			if(node-1 >= 0 && visited[node-1] == 0) {
				queue.add(node-1);
				visited[node-1] = visited[node]+1;
			}
			if(node+1 <= 100000 && visited[node+1] == 0) {
				queue.add(node+1);
				visited[node+1] = visited[node]+1;
			}
			if(node*2 <= 100000 && visited[node*2] == 0) {
				queue.add(node*2);
				visited[node*2] = visited[node]+1;
			}
		}
	}
}