import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int body[][] = new int[N][2];
		int rank[] = new int[N];
		
		for(int i=0;i<N;i++) {
			String inputs[] = br.readLine().split(" ");
			body[i][0] = Integer.parseInt(inputs[0]);
			body[i][1] = Integer.parseInt(inputs[1]);
		}
		
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(body[i][0]<body[j][0]&&body[i][1]<body[j][1]) cnt++;
			}
			rank[i]=cnt+1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r : rank) sb.append(r+" ");
		System.out.println(sb);
			
	}
}
