import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
      
      for (int i = 0; i < M - 7; i++) {
         for (int j = 0; j < N - 7; j++) {
            find(i, j);
         }
      }
      
      System.out.println(min);
   }
   public static void find(int x, int y) {
      int end_x = x + 8;
      int end_y = y + 8;
      boolean TF = board[x][y]; 
      int count = 0;
      
      for (int i = x; i < x + 8; i++) {
         for (int j = y; j < (y+8) ; j++) {
            if(board[i][j] != TF)
               count++;

            TF = !TF;
         }
         TF = !TF;
      }
      
      count = Math.min(count, 64-count);
      min = Math.min(min, count);
   };
}