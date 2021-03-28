package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳_G4_X {
	static int R,C, MAX, b;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited[map[0][0]-65] = true;
		dfs(0,0,1);
		//		for(int i=0; i<R; i++) {
		//			for(int j=0; j<C; j++) {
		//				dfs(i, j, 1);
		//			}
		//		}
		System.out.println(MAX);

	}

	private static void dfs(int row, int col, int count) {
		int nr, nc;
		int indexing = map[row][col] - 65;

		if(visited[indexing] == true) {
			if(MAX==Integer.MIN_VALUE || MAX <= count) {
				MAX = count;
			}
			//return;
		}

		for(int move = 0; move < 4; move++) {
			nr = row + dr[move];
			nc = col + dc[move];
			if(!isLineOut(nr, nc)) {
				indexing = map[nr][nc] - 65;
				if(!visited[indexing]) {
					visited[indexing] = true;
					dfs(nr, nc, count+1);
					visited[indexing] = false;
				}
			}
		}
	}

	private static boolean isLineOut(int row, int col) {
		if(row<0 || col<0 || row>=R || col>=C)
			return true;
		return false;
	}
}
