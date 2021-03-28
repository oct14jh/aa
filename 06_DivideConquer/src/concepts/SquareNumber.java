package concepts;

import java.util.Scanner;

public class SquareNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// x^y 값 구하기
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(exp(x,y));
	}
	
	// x^y 값 구하기....
	private static int exp(int x, int y) { // x는 값, y는 지수
		if(y==1) 
			return x;
		
		int result = exp(x, y/2);
		result = result*result;
		
		if(y%2 != 0) 	// 홀수인경우 ... x^5 = x^2 * x^2 에다가 * x를 하기 위함
			result = result * x;
		
		return result;
	}
}
