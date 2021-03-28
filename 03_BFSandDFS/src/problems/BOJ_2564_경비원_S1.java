package problems;

import java.util.Scanner;

public class BOJ_2564_경비원_S1 {
	static int R, C;
	static int circumFerence;
	static int N;
	static int[] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int myDist = 0;
		int answer = 0;
		
		C = sc.nextInt();
		R = sc.nextInt();
		circumFerence = (C+R)*2;
		N = sc.nextInt();
		dist = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			int idx = sc.nextInt();
			int pos = sc.nextInt();
			dist[i] = distCalc(idx, pos);
		}
		myDist = dist[N];
		
		for(int i = 0; i < N; i++) {
			int clockWise = Math.abs(myDist - dist[i]);
			answer += Math.min(clockWise, circumFerence-clockWise);
		}
		System.out.println(answer);
	}
	
	private static int distCalc(int idx, int pos) {
		if(idx == 1)
			return pos;
		else if(idx == 2)
			return C + R + C - pos;
		else if(idx == 3)
			return C + R + C + R - pos;
		else
			return C + pos;
	}
}
