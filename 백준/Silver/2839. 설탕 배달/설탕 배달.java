import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int dp[] = new int[5001];
    dp[0] = 0;
    dp[1] = -1;
    dp[2] = -1;
    dp[3] = 1;
    dp[4] = -1;
    for (int i = 5; i <= n; i++) {
      if (dp[i - 5] != -1) {
        dp[i] = dp[i - 5] + 1;
      } else if (dp[i - 3] != -1) {
        dp[i] = dp[i - 3] + 1;
      } else {
        dp[i] = -1;
      }
    }
    System.out.println(dp[n]);
  }
}
