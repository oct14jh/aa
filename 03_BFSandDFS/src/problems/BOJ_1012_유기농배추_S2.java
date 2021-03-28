package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추_S2 {
	static class Point {
		int row;
		int col;
		int groupValue;
		public Point() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Point(int row, int col, int groupValue) {
			super();
			this.row = row;
			this.col = col;
			this.groupValue = groupValue;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getCol() {
			return col;
		}
		public void setCol(int col) {
			this.col = col;
		}
		public int getGroupValue() {
			return groupValue;
		}
		public void setGroupValue(int groupValue) {
			this.groupValue = groupValue;
		}
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", groupValue=" + groupValue + "]";
		}
	}
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int T, M, N, K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int groupCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			groupCount = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j])
						bfs(i, j, groupCount++);
				}
			}
			System.out.println(groupCount);
		}
		sc.close();
	}
	private static void bfs(int row, int col, int groupVal) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, groupVal));
		visited[row][col] = true;
		while(!q.isEmpty()) {
			Point current = q.poll();
			for(int move = 0; move < 4; move++) {
				int nr = current.row + dr[move];
				int nc = current.col + dc[move];
				
				if(!isLineOut(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new Point(nr, nc, groupVal));
					visited[nr][nc] = true;
				}
			}
		}
	}
	private static boolean isLineOut(int row, int col) {
		if(row < 0 || col < 0 || row >= N || col >= M)
			return true;
		return false;
	}
}
