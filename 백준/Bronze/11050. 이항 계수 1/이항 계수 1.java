import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 전체집합에서 원소개수 n개에대해 k개를 뽑는 이항계수(조합의 수)
		
		// 1. 팩토리얼 -> 오버플로우조심
		// n!/k!/(n-k)!
//		System.out.println(factorial(N)/(factorial(N-K)*factorial(K)));
		
		// 2. 이항계수 성질 이용 -> 파스칼의 법칙
		// 성질1. n개에서 k개 뽑는 = n개에서 n-k개 뽑는
		// 성질2. n개에서 k개를 뽑는 = n-1개에서 k개 + n-1개에서 k-1개 뽑는
		// 성질3. n개에서 0개 = n개에서 n개 = 1
		
		// 3. dp 동적계획법 - top-down
		dp = new int[N+1][K+1];
		System.out.println(BC(N,K));	
		
	}
	// 1. 팩토리얼
	static int factorial(int N) {
		if(N <=1) return 1; // 0!=1
		return N * factorial(N-1);
	}
	// 2. 성질
	static int BC(int n, int k) {
		// 3. dp
		// 이미 풀었던 sub문제일 경우 값 재활용
		if(dp[n][k]>0) return dp[n][k];
		// 성질3
		if(n == k || k == 0) return 1;
		// 성질2
//		return BC(n-1,k-1) + BC(n-1,k);
		return dp[n][k] = BC(n-1,k-1) + BC(n-1,k);
	}
	
}