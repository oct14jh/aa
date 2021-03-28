package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설_모의역테 {
	private static int N;
	private static int X;
	private static int[][] map;
	private static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); 
			X = Integer.parseInt(st.nextToken());
			count = 0;
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			process();
			System.out.println("#" + testCase + " " + count);
		}
		
	}
	
	private static void process() {
		for(int i = 0; i < N; i++) {
			if(makeRoadByRow(i)) ++count;
			if(makeRoadByCol(i)) ++count;
		}
	}
	
	private static boolean makeRoadByRow(int i) {
		int beforeHeight;
		int size;
		
		beforeHeight = map[i][0];
		size = 1;
		for(int j = 1; j < N; j++) {
			if(beforeHeight == map[i][j]) {
				++size;
			}
			else if(beforeHeight + 1 == map[i][j]) {
				if(size < X) {
					return false;
				}
				beforeHeight++;
				size = 1;
			}
			else if(beforeHeight - 1 == map[i][j]) {
				int count = 0;
				for(int k = j; k < N; k++) {
					if(map[i][k] != beforeHeight - 1)
						break;
					count++;
				}
				if(count < X)
					return false;
				j += X - 1;
				beforeHeight--;
				size = 0;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean makeRoadByCol(int i) {
		int beforeHeight;
		int size;
		
		beforeHeight = map[0][i];
		size = 1;
		for(int j = 1; j < N; j++) {
			if(beforeHeight == map[j][i]) {
				++size;
			}
			else if(beforeHeight + 1 == map[j][i]) {
				if(size < X) {
					return false;
				}
				beforeHeight++;
				size = 1;
			}
			else if(beforeHeight - 1 == map[j][i]) {
				int count = 0;
				for(int k = j; k < N; k++) {
					if(map[k][i] != beforeHeight - 1)
						break;
					count++;
				}
				if(count < X)
					return false;
				j += X - 1;
				beforeHeight--;
				size = 0;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
