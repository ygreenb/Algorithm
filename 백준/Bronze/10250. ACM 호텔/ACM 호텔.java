import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 데이터 개수
		
		while(T>0) {
			String[] inputs = br.readLine().split(" ");
			int H = Integer.parseInt(inputs[0]); // 층 수
			int W = Integer.parseInt(inputs[1]); // 방 수
			int N = Integer.parseInt(inputs[2]); // 몇번째 손님
			
			int y = (N%H==0)?(H*100):(N%H*100); // 나머지 = 층 수
			int x = (N%H==0)?(N/H):(N/H+1); // 몫+1 = 방 수
			
			System.out.println(y+x);
			T -= 1;
		}
	}
}
