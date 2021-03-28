package problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	private static int N;
	private static char[] result;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		result = new char[N];
		
		for(int i = 0; i < N; i++) {
			int sizeP1=0, sizeP2=0;
			int[] P1 = new int[4];
			int[] P2 = new int[4];
			sizeP1 = sc.nextInt();
			for(int j = 0; j < sizeP1; j++) {
				P1[sc.nextInt() - 1] += 1;
			}
			sizeP2 = sc.nextInt();
			for(int j=0; j<sizeP2; j++) {
				P2[sc.nextInt() - 1] += 1;
			}
			result[i] = roundWin(P1, P2);
			
		}
		
		for(char c : result) {
			System.out.println(c);
		}
	}

	private static char roundWin(int[] p1, int[] p2) {
		for(int i = 3; i >= 0; i--) {
			if(p1[i] > p2[i]) {
				return 'A';
			}
			else if(p1[i] == p2[i]) {
				if(i==0)
					return 'D';
				continue;
			}
			else if(p1[i] < p2[i])
				return 'B';
		}
		return 0;
	}
	

}
