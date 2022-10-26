import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		String s;
		
		while(true) {
			s = br.readLine();
			if(s.equals(".")) {	// 종료 조건문 
				break;
			}
			sb.append(solve(s)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);	// i 번째 문자 
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[') stack.push(c);

			// 닫는 소괄호 일 경우 
			else if(c == ')') {
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') return "no";
				else stack.pop();
				
			}
			
			else if(c == ']') {
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') return "no";
				else stack.pop();
			}
		}
		
		if(stack.empty()) return "yes";
		else return "no";
	}
}