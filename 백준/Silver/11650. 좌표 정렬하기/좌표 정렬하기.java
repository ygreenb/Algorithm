import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr= new int[N][2];
				
		for(int i=0;i<N;i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// x좌표 -> y좌표 오름차순 정렬
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0]==o2[0])
				return o1[1]-o2[1];
			else
				return o1[0]-o2[0];
		});
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);			
		}
	}
}
