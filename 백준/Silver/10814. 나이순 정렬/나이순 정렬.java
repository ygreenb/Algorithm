import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String member[][] = new String[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			member[i][0] = st.nextToken();	// 나이
			member[i][1] = st.nextToken();	// 이름
		}
		
		Arrays.sort(member,(o1,o2)->{
			return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
		});

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) sb.append(member[i][0]+" "+member[i][1]+"\n");
		System.out.println(sb);
	}
}
