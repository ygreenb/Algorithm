package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bj1260.java
 * 백준 1260번 : DFS와 BFS
 * version 1.0
 * data 2022.06.28
 */

public class bj1260_2{
	static int N, M, V;

	static List<Integer>[] line;

	static int index = 0;
	static int[] visited = new int[1001];
	static boolean isEnd = false;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		line = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++){
			line[i] = new ArrayList<Integer>();
		}

		String[] inputs = new String[2];
		for (int i = 1; i <= M; i++){
			input = br.readLine();
			inputs = input.split(" ");
			line[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
			line[Integer.parseInt(inputs[1])].add(Integer.parseInt(inputs[0]));
		}

		for (int i = 1; i <= N; i++){
			Collections.sort(line[i]);
		}

		// DFS
		visited[V] = 1;
		System.out.print(V + " "); // 시작노드
		index++;
		dfs(V);

		for (int i = 1; i <= N; i++){
			visited[i] = 0; // 방문 초기화
		}
		System.out.println();

		// BFS
		bfs(V);
		System.out.println();
	}
	private static void dfs(int node){
		for (int next : line[node]){
			if (visited[next] == 0){ // 방문하지 않았을 때
				System.out.print(next + " "); // 노드 출력
				index++;
				visited[next] = 1;
				dfs(next);
			}
		}
	}
	private static void bfs(int node){
		Queue<Integer> queue = new LinkedList<Integer>();
		// 시작노드 
		queue.add(node); 
		visited[node] = 1;
		index = 1;
		// queue가 비어있을 떄 까지 반복
		while (queue.isEmpty() == false){
			node = queue.remove();
			System.out.print(node + " ");
			for (int next : line[node]){
				// 방문하지 않은 노드들 차례대로 방문 후 큐에 add
				if (visited[next] == 0){
					index++;
					visited[next] = 1;
					queue.add(next);
				}
			}
		}
	}
}