import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	
		int K = Integer.parseInt(st.nextToken());	

		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++) list.add(i);

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index = 0; // 리스트에서 삭제할 요소의 인덱스
		
		while(N>1) {
			index = (index + (K-1)) % N; // 범위 밖 참조 에러 방지
			
			// index 요소 삭제+출력
			sb.append(list.remove(index)).append(", ");
			N--;
		}		

		//마지막 요소 삭제+출력
		sb.append(list.remove()).append(">");
		System.out.println(sb);
	}
}
