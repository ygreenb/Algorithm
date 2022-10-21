import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String words[] = new String[N];
		
		for(int i=0;i<N;i++) {
			words[i]= br.readLine();
		}
		
		// 길이가 짧은 순
		Arrays.sort(words, (o1,o2) ->{
			if(o1.toString().length()==o2.toString().length()) // 사전순
				return o1.compareTo(o2);
			else
				return o1.toString().length() - o2.toString().length(); // 양수면 순서변경
		});

		for(int i =0;i<N;i++) {
			if(i != N-1 && words[i].equals(words[i+1])) continue;
			System.out.println(words[i]);
		}

	}
	
}