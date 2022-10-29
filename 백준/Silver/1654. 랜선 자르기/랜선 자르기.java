import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int lan[] = new int[K];
		
		long max = 0;
		for(int i=0;i<K;i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if(max < lan[i]) max = lan[i];
		}
		
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {	
			
			mid = (min+max)/2;
			
			long cnt = 0;
			
			for(int i=0;i<K;i++) {
				cnt += (lan[i]/mid);
			}
			
			if(cnt<N) max=mid;
			else min=mid+1;
		}
		
		System.out.println(min-1);
	}
}
