import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(test>0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서인덱스
			
			LinkedList<int[]> q = new LinkedList<>();
			// 문서인덱스와 중요도 입력받아 저장
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				q.offer(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0; // 인쇄순서
			// 인쇄는 현재 자신보다 중요도가 높은 문서가 있다면 뒤로 보냄
			while(!q.isEmpty()) {
				int[] now = q.get(0); // [0,1] [1,0]
				boolean isMax = false;
				
				// 자기보다 중요도 높은 문서 있는지 확인
				for(int i=0;i<q.size();i++) {
					if(now[1]<q.get(i)[1]) {
						isMax = true;
					}
				}
				
				// 중요도 높은 문서가 있다면
				if(isMax) {
					q.offer(q.poll()); // 뒤로보냄

				}
				// 없다면 인쇄함
				else {
					cnt++;
					q.poll(); // 인쇄
					// 인덱스가 M인 문서가 인쇄된 순서를 구함
					if(now[0]==M) break;
				}
			}
			// 답 sb에 넣어놓고 한번에 출력
			sb.append(cnt).append("\n");						
			test--;
		}
		System.out.println(sb);
	}	
}
