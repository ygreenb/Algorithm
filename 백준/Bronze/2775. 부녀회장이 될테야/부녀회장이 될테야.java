import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 아파트 생성
		int[][] APT = new int[15][15];
		for(int i=0;i<15;i++) {
			APT[i][1] = 1;
			APT[0][i] = i;
		}
		for(int i=1;i<15;i++) {
			for(int j=2;j<15;j++)
				APT[i][j] = APT[i][j-1] + APT[i-1][j];
		}
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(APT[k][n]);	
			T--;
		}	
	}
}