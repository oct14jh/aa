package problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608_막대기_B2 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> stack = new Stack<Integer>(); 
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			while(!stack.isEmpty() && stack.peek() <= height) stack.pop();
			
			stack.push(height);
		}
		System.out.println(stack.size());
	}
}
