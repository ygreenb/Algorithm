import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken()); // 올라감
		int B = Integer.parseInt(st.nextToken()); // 미끄러짐
		int V = Integer.parseInt(st.nextToken()); // 나무막대 높이

		System.out.println(HowDateSnailStick(A,B,V));
	}

	public static int HowDateSnailStick(int up, int down, int length) {
		int day = (length-down)/(up-down);
		if((length-down)%(up-down) != 0) day++;
		return day;
	}
}