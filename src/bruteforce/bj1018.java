package bruteforce;

/*
 * bj1018.java
 * ���� 1018�� : ü���� �ٽ� ĥ�ϱ�
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
               board[i][j] = true; // W�� true
            else
               board[i][j] = false; // B�� false
         }
      }
      
      int M_row = M - 7;
      int N_col = N - 7;
      // ����� ����ŭ find() ����
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
      boolean TF = board[x][y]; // ù��° ĭ�� ��
      int count = 0;
      
      // �ٽ� ĥ�ؾ��ϴ� count ����
      for (int i = x; i < x + 8; i++) {
         for (int j = y; j < (y+8) ; j++) {
            // ĥ�ؾ��ϴ� ���� �ٸ��� count ����
            if(board[i][j] != TF)
               count++;
            // ����ĭ�� �Ѿ�� �� �� ����
            TF = !TF;
         }
         // �������� �Ѿ���� �� ����
         TF = !TF;
      }
      
      // ù���� ĭ�� ���� �������� �ٸ����� ���� �ּڰ� ����
      count = Math.min(count, 64-count);
      // ������ ĥ�ؾ��ϴ� ���� �� �ּڰ� ����
      min = Math.min(min, count);
   };
}