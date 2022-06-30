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
 * ���� 1260�� : DFS�� BFS
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
		System.out.print(V + " "); // ���۳��
		index++;
		dfs(V);

		for (int i = 1; i <= N; i++){
			visited[i] = 0; // �湮 �ʱ�ȭ
		}
		System.out.println();

		// BFS
		bfs(V);
		System.out.println();
	}
	private static void dfs(int node){
		for (int next : line[node]){
			if (visited[next] == 0){ // �湮���� �ʾ��� ��
				System.out.print(next + " "); // ��� ���
				index++;
				visited[next] = 1;
				dfs(next);
			}
		}
	}
	private static void bfs(int node){
		Queue<Integer> queue = new LinkedList<Integer>();
		// ���۳�� 
		queue.add(node); 
		visited[node] = 1;
		index = 1;
		// queue�� ������� �� ���� �ݺ�
		while (queue.isEmpty() == false){
			node = queue.remove();
			System.out.print(node + " ");
			for (int next : line[node]){
				// �湮���� ���� ���� ���ʴ�� �湮 �� ť�� add
				if (visited[next] == 0){
					index++;
					visited[next] = 1;
					queue.add(next);
				}
			}
		}
	}
}