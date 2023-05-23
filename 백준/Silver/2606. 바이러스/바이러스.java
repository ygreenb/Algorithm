import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  static boolean[] visited;
  static private List<List<Integer>> adjacencyList; // 인접리스트

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int computerCount = Integer.parseInt(br.readLine()) + 1;
    int vertexCount = Integer.parseInt(br.readLine());

    visited = new boolean[computerCount];
    // 인접리스트 초기화
    adjacencyList = new ArrayList<>(computerCount);
    for (int i = 0; i < computerCount; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    // 그래프 초기화
    for (int i = 0; i < vertexCount; i++) {
      String input[] = br.readLine().split(" ");
      int source = Integer.parseInt(input[0]);
      int destination = Integer.parseInt(input[1]);
      adjacencyList.get(source).add(destination);
      adjacencyList.get(destination).add(source);
    }

    System.out.println(DFS(1));
  }

  static public int DFS(int startVertex) {
    int worm = 0; // 감염된 컴퓨터 수
    Stack<Integer> stack = new Stack<>();

    // 1번 컴퓨터 감염
    visited[startVertex] = true;
    stack.push(startVertex);

    while (!stack.isEmpty()) {
      int currentVertex = stack.pop();
      List<Integer> neighbors = adjacencyList.get(currentVertex);

      for (int neighbor : neighbors) {
        if (!visited[neighbor]) {
          worm++;
          visited[neighbor] = true;
          stack.push(neighbor);
        }
      }
    }

    return worm;
  }

}
