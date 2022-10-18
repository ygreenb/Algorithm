import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine(); 
			if(str.equals("0")) break;

			// 수 뒤집어서 비교
//			StringBuffer sb = new StringBuffer();
//			for(int i=str.length()-1;i>=0;i--) {
//				sb.append(str.charAt(i));
//			}
//			if(str.equals(sb.toString())) System.out.println("yes");
//			else System.out.println("no");
			
			// 반 쪼개서 비교
			int cnt = 0;
			for(int i=0; i<str.length()/2;i++) {
				if(str.charAt(i)== str.charAt(str.length()-1-i)) cnt++;
			}
			if(cnt==str.length()/2) System.out.println("yes");
			else System.out.println("no");
		}
	}
}