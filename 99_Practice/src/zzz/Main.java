package zzz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int N;
	private static char result;
	public static void main(String[] args) {
		ArrayList<String> Sk = new ArrayList<>();
		Sk.add("moo");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp(Sk, 1);
		System.out.println(result);
	}
	
	private static void dp(ArrayList Sk, int index) {
		StringBuilder temp = new StringBuilder();
		temp.append("m");
		for(int i = index; i < N; i++) {
			for(int j = 0; j < i+2; j++) {
				temp.append("o");
			}
			Sk.add( Sk.get(index-1) + temp.toString() + Sk.get(index-1) =;
			if(N > Sk.get(i).toString().length())
				dp(Sk, i+1);
			else {
				result = Sk.get(i).toString().charAt(N);
				break;
			}
		}
		
	}
}
// 점화식 구하기가 중요하다.