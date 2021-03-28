package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동_G5 {
	static class Point{
		private boolean united;
		private int people;
		public Point() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Point(boolean united, int people) {
			super();
			this.united = united;
			this.people = people;
		}
		public boolean isUnited() {
			return united;
		}
		public void setUnited(boolean united) {
			this.united = united;
		}
		public int getPeople() {
			return people;
		}
		public void setPeople(int people) {
			this.people = people;
		}
		@Override
		public String toString() {
			return "Point [united=" + united + ", people=" + people + "]";
		}
	}
	private static int N, L, R;
	private static Point[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new Point[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = new Point(false, Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bfs(i, j, result);
			}
		}
		
		
	}
	private static void bfs(int row, int col, int result) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		Point current = map[row][col];
		
		q.offer(current);
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			
		}
	}
	private static boolean isLineOut(int r, int c) {
		if(r<0 || c<0 || r>=N || c>=N)
			return true;
		return false;
	}
}
