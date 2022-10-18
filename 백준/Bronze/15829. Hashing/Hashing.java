import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();
		long result = 0;
		long pow = 1;
		for(int i=0;i<L;i++) {
			result +=((S.charAt(i) - 96) * pow);
			pow = (pow * 31) % 1234567891; // long의 범위를 넘어서지 않기 위해 나눠줌
		}
		System.out.println(result % 1234567891);
		
	}
}
