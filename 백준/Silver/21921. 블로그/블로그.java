import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int X = Integer.parseInt(input[1]);
    int[] visitors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int start = 0;
    int end = X;
    int cumVisitors = 0;
    int cnt = 0;
    for (int i = start; i < end; i++) {
      cumVisitors += visitors[i];
    }

    int maxVisitors = cumVisitors;
    cnt++;

    while (end < N) {
      cumVisitors -= visitors[start];
      cumVisitors += visitors[end];

      // 최대 방문자 수가 갱신될 때마다 cnt 변수를 1로 초기화해야함
      if (cumVisitors > maxVisitors) {
        maxVisitors = cumVisitors;
        cnt = 1;
      } else if (cumVisitors == maxVisitors) {
        cnt++;
      }

      start++;
      end++;
    }

    if (maxVisitors == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(maxVisitors + "\n" + cnt);
    }
  }
}
