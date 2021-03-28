package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기_모의역테 {
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	private static int N,W,H,min;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase <=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + testCase + min);
		}
	}
	//i번째 구슬 떨어뜨리기
	private static void go(int count, int[][] map) {
		// 던져질 구슬개수, 이전구슬까지의 2차원배열
		
		if(count == N) {
			int result = getRemain(map);
			return;
		}
		
		int[][] newMap = new int[N][N];
		
		for(int c = 0; c< W; c++) {
			int r = 0;
			while(r < H && map[r][c] == 0)
				++r;
			
			if(r==H)
				go(count+1, map);
			else {
				copy(map, newMap);
				boom(newMap, r, c);
				
				down(newMap);
				
				go(count+1, newMap);
			}
		}
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0)
					++ count;
			}
		}
		return count;
	}
	private static void down(int[][] map) {
		for(int c = 0; c < W; c++) {
			int r = H-1;
			while(r > 0) {
				if(map[r][c] == 0) {
					int nr = r-1;
					while(map[nr][c] == 0)
						--nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}
		
	}
	private static void boom(int[][] map, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		if(map[r][c] > 1) {
			q.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;    
 		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.cnt == 1)
				continue;
			
			int nr = p.r, nc = p.c;
			for(int d = 0; d < 4; d++) {
				for(int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr >= 0 && nr < H && nc>=0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) {
							q.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
		
	}
	private static void copy(int[][] map, int[][] newMap) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
	}
}
