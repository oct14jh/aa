package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1224_계산기3_D4 {
	private static int N; // 최초 식의 길이
	private static Stack<Character> operatorStack = new Stack<>(); // 후위연산으로 바꿀 때 쓰이는 연산자 스택
	private static Stack<Integer> operandStack = new Stack<>(); // 후위연산을 계산할 때 쓰이는 피연산자 스택
	private static int result; // 결과값

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int testCase = 1; testCase <= 1; testCase++) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine().trim());
			String exp = br.readLine().trim();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				char temp = exp.charAt(i);
				if (Character.isDigit(temp)) { // 숫자인 경우
					sb.append(temp);
				}
				else if (temp == ')') {
					
				}else {
					
				}
				
				
				System.out.println("#" + testCase + " " + result);
			}
		}
	}

	private static int priorityOperator(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		default:
			return 0;
		}
	}

	private static int priorityOperatorStack(char operator) {
		switch (operatorStack.peek()) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return 0;
		}
	}
}
