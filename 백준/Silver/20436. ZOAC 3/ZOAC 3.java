import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class KeyPoint {
  int x, y;

  public KeyPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {
  static HashMap<String, KeyPoint> jkb;
  static HashMap<String, KeyPoint> mkb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    String sl = st.nextToken();
    String sr = st.nextToken();
    String str = br.readLine();

    jkb = new HashMap<>();
    mkb = new HashMap<>();
    makeKeyboard();
    calcTime(str, sl, sr);
  }

  static void makeKeyboard() {
    // 1줄
    jkb.put("q", new KeyPoint(0, 0));
    jkb.put("w", new KeyPoint(1, 0));
    jkb.put("e", new KeyPoint(2, 0));
    jkb.put("r", new KeyPoint(3, 0));
    jkb.put("t", new KeyPoint(4, 0));
    mkb.put("y", new KeyPoint(5, 0));
    mkb.put("u", new KeyPoint(6, 0));
    mkb.put("i", new KeyPoint(7, 0));
    mkb.put("o", new KeyPoint(8, 0));
    mkb.put("p", new KeyPoint(9, 0));
    // 2줄
    jkb.put("a", new KeyPoint(0, 1));
    jkb.put("s", new KeyPoint(1, 1));
    jkb.put("d", new KeyPoint(2, 1));
    jkb.put("f", new KeyPoint(3, 1));
    jkb.put("g", new KeyPoint(4, 1));
    mkb.put("h", new KeyPoint(5, 1));
    mkb.put("j", new KeyPoint(6, 1));
    mkb.put("k", new KeyPoint(7, 1));
    mkb.put("l", new KeyPoint(8, 1));
    // 3줄
    jkb.put("z", new KeyPoint(0, 2));
    jkb.put("x", new KeyPoint(1, 2));
    jkb.put("c", new KeyPoint(2, 2));
    jkb.put("v", new KeyPoint(3, 2));
    mkb.put("b", new KeyPoint(4, 2));
    mkb.put("n", new KeyPoint(5, 2));
    mkb.put("m", new KeyPoint(6, 2));
  }

  static void calcTime(String str, String sl, String sr) {
    int time = 0;
    for (int i = 0; i < str.length(); i++) {
      String c = str.charAt(i) + "";
      if (jkb.containsKey(c)) {
        KeyPoint L = jkb.get(sl);
        KeyPoint kp = jkb.get(c);
        time += Math.abs(L.x - kp.x) + Math.abs(L.y - kp.y);
        time++;
        sl = c;
      } else if (mkb.containsKey(c)) {
        KeyPoint R = mkb.get(sr);
        KeyPoint kp = mkb.get(c);
        time += Math.abs(R.x - kp.x) + Math.abs(R.y - kp.y);
        time++;
        sr = c;
      }
    }

    System.out.println(time);
  }
}
