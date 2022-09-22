import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N,M;
	static boolean[] visit;
	static int ans[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		ans = new int[M];
		// 1~N 까지 중복없이 M개 출력
		getNext(0);
		System.out.println(sb);
		
	}

	public static void getNext(int depth) {
		if(depth == M) {
			// 수열 M개 채워지면 출력
			for(int a : ans)
				sb.append(a).append(' ');
			sb.append('\n');
			return;
		}

		for(int i=1;i<=N;i++) {	
			if(!visit[i]) {
				visit[i]=true;
				ans[depth] = i;
				getNext(depth+1); // 재귀호출
				// 자식노드 방문 후 방문초기화
				visit[i]=false;
				
			}
		}
	};
	
}