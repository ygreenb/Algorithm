import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    int stairs[] = new int[cnt + 1];
    for (int i = 1; i <= cnt; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    int dp[] = new int[cnt + 1];
    dp[1] = stairs[1];
    if (cnt == 1) {
      System.out.println(dp[1]);
      return;
    }

    dp[2] = stairs[1] + stairs[2];
    for (int i = 3; i <= cnt; i++) {
      dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
    }
    System.out.println(dp[cnt]);
  }
}