import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String[] inputs = input.split(" ");
		int cnt = 0;

		for(int i=0;i<N;i++) {
			if(IsPrimeNumber(Integer.parseInt(inputs[i]))) cnt++;
		}
		
		System.out.println(cnt);
	}
	static boolean IsPrimeNumber(int n) {
		if(n==1) return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}