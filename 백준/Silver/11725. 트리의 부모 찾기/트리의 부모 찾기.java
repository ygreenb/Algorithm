import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static private int N;
  static private List<List<Integer>> adjacencyList;
  static boolean[] visited;
  static private int[] parentNode;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    adjacencyList = new ArrayList<>(N + 1);
    visited = new boolean[N + 1];
    parentNode = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      adjacencyList.get(a).add(b);
      adjacencyList.get(b).add(a);
    }

    // dfs(1);
    bfs(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(parentNode[i]);
    }
  }

  public static void dfs(int v) {
    visited[v] = true;

    for (int neighbor : adjacencyList.get(v)) {
      if (!visited[neighbor]) {
        parentNode[neighbor] = v;
        dfs(neighbor);
      }
    }
  }

  public static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int currentV = queue.poll();

      for (int neighbor : adjacencyList.get(currentV)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          parentNode[neighbor] = currentV;
          queue.offer(neighbor);
        }
      }
    }

  }
}
