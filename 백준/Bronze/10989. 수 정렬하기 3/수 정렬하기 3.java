import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		// 1. Arrays.sort
		//		int arr[] = new int[N];
//		
//		for(int i =0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
//		
//		Arrays.sort(arr);
//	
//		StringBuilder sb = new StringBuilder();
//		for(int a : arr) sb.append(a).append('\n');
		
		//2. 카운팅 정렬
		int[]cnt = new int[10001];
		
		// 해당 숫자의 위치 배열의 값 1 증가시킴
		for(int i =0;i<N;i++) cnt[Integer.parseInt(br.readLine())] ++;
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<10001;i++) {
			// i 값 개수가 0이 될때 까지 출력(빈도수)
			while(cnt[i]>0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		
		System.out.println(sb);
	}
}