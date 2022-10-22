import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int l : list) sb.append(l).append('\n');
		System.out.println(sb);
	}
}
