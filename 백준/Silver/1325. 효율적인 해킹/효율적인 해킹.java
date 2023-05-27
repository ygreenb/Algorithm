import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static private List<List<Integer>> adjacencyList = new ArrayList<>();
  static boolean[] visited;
  static int[] hackingCnt;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    for (int i = 0; i <= N; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      adjacencyList.get(a).add(b);
    }

    hackingCnt = new int[N + 1];
    int max = 0;
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      bfs(i);
    }

    // 최대로 해킹할 수 있는 컴퓨터 수 구함
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, hackingCnt[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (hackingCnt[i] == max) {
        sb.append(i).append(" ");
      }
    }
    System.out.println(sb.toString().trim());
  }

  public static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int currentV = queue.poll();
      // System.out.println("currentV : " + currentV);

      for (int neighbor : adjacencyList.get(currentV)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
          hackingCnt[neighbor]++;
          // System.out.println("hackingCnt[" + neighbor + "] : " + hackingCnt[neighbor]);
        }
      }
    }
  }
}
