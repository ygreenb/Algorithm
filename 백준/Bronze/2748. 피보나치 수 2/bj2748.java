import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj2748 {
  private static long[] dp = new long[91];
  private static Map<Integer, Long> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = (br.readLine()); // n번째 피보나치 수 입력받음
    int n = Integer.parseInt(input);

    // 1. 재귀호출 : n이 25만 넘어가도 눈에띄게 상당한 시간이 소요됨.
    long start = System.currentTimeMillis();
    long result = Fibonacci(n);
    long end = System.currentTimeMillis();
    System.out.println(result + ":" + Long.toString(end - start));

    // 2. DP : 동적계획법
    start = System.currentTimeMillis();
    result = dp(n);
    end = System.currentTimeMillis();
    System.out.println(result + ":" + Long.toString(end - start));

    start = System.currentTimeMillis();
    result = dp2(n);
    end = System.currentTimeMillis();
    System.out.println(result + ":" + Long.toString(end - start));
  }

  public static long Fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return Fibonacci(n - 1) + Fibonacci(n - 2);
  }

  public static long dp(int n) {
    if (n <= 1) {
      return n;
    }

    if (dp[n] != 0) {
      return dp[n];
    }

    long result = dp(n - 1) + dp(n - 2);
    dp[n] = result;
    return result;
  }

  public static long dp2(int n) {
    if (n <= 1) {
      return n;
    }

    if (map.containsKey(n)) {
      return map.get(n);
    }

    long result = dp(n - 1) + dp(n - 2);
    map.put(n, result);
    return result;
  }
}
