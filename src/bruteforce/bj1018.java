package bruteforce;

/*
 * bj1018.java
 * 백준 1018번 : 체스판 다시 칠하기
 * version 1.0
 * data 2022.08.16
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1018 {
   public static boolean[][] board;
   public static int min = 64;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      
      board = new boolean[M][N];
      
      for(int i=0;i<M;i++) {
         String str = br.readLine();
         for(int j=0;j<N;j++) {
            if(str.charAt(j)=='W')
               board[i][j] = true; // W면 true
            else
               board[i][j] = false; // B면 false
         }
      }
      
      int M_row = M - 7;
      int N_col = N - 7;
      // 경우의 수만큼 find() 실행
      for (int i = 0; i < M_row; i++) {
         for (int j = 0; j < N_col; j++) {
            find(i, j);
         }
      }
      
      System.out.println(min);
   }
   public static void find(int x, int y) {
      int end_x = x + 8;
      int end_y = y + 8;
      boolean TF = board[x][y]; // 첫번째 칸의 색
      int count = 0;
      
      // 다시 칠해야하는 count 구함
      for (int i = x; i < x + 8; i++) {
         for (int j = y; j < (y+8) ; j++) {
            // 칠해야하는 색과 다르면 count 증가
            if(board[i][j] != TF)
               count++;
            // 다음칸을 넘어가기 전 색 변경
            TF = !TF;
         }
         // 다음줄을 넘어가기전 색 변경
         TF = !TF;
      }
      
      // 첫번쨰 칸의 색이 같을떄와 다를때를 비교해 최솟값 구함
      count = Math.min(count, 64-count);
      // 이전의 칠해야하는 값들 중 최솟값 구함
      min = Math.min(min, count);
   };
}