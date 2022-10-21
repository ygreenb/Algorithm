import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num=0, cnt=0;
		
		while(cnt<N) {
			num++;
			if(String.valueOf(num).contains("666")) cnt++;
		}
		
		System.out.println(num);
	}
}