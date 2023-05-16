import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  private static Map<Integer, Long> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = (br.readLine()); // n번째 피보나치 수 입력받음
    int n = Integer.parseInt(input);

    System.out.println(dp(n));
  }

  public static long dp(int n) {
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
