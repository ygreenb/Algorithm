import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] bingo = new int[5][5];
  static int bingoCount = 0;

  public static void main(String args[]) throws Exception {
    int turn = 1;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        bingo[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 빙고시작
    // 하나씩 부를때마다 0으로 값바꾸고, 빙고되는지 전부확인해보자.
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        int num = Integer.parseInt(st.nextToken());

        for (int k = 0; k < 5; k++) {
          for (int l = 0; l < 5; l++) {
            if (bingo[k][l] == num) {
              bingo[k][l] = 0;
            }
          }
        }

        col();
        row();
        diag1();
        diag2();

        if (bingoCount >= 3) {
          System.out.println(turn);
          System.exit(0);
          ;
        }

        bingoCount = 0;
        turn++;
      }
    }

  }

  // 열 체크
  public static void col() {
    for (int i = 0; i < 5; i++) {
      int zeroCount = 0;
      for (int j = 0; j < 5; j++) {
        if (bingo[i][j] == 0)
          zeroCount++;
        if (zeroCount == 5)
          bingoCount++;
      }
    }
  }

  // 행 체크
  public static void row() {
    for (int i = 0; i < 5; i++) {
      int zeroCount = 0;
      for (int j = 0; j < 5; j++) {
        if (bingo[j][i] == 0)
          zeroCount++;
        if (zeroCount == 5)
          bingoCount++;
      }
    }
  }

  // 대각선1 체크
  public static void diag1() {
    int zeroCount = 0;
    for (int i = 0; i < 5; i++) {
      if (bingo[i][i] == 0)
        zeroCount++;
    }
    if (zeroCount == 5)
      bingoCount++;
  }

  // 대각선2 체크
  public static void diag2() {
    int zeroCount = 0;
    for (int i = 0; i < 5; i++) {
      if (bingo[i][4 - i] == 0)
        zeroCount++;
    }
    if (zeroCount == 5)
      bingoCount++;
  }
}