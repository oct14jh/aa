package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int row;
	int col;
	int depth;
	int restoreTime;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(int row, int col, int depth, int restoreTime) {
		super();
		this.row = row;
		this.col = col;
		this.depth = depth;
		this.restoreTime = restoreTime;
	}
	
	
}
public class SWEA_1249_보급로_D4 {
	private static int T, N;
	private static Point[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine().trim();
				for(int j = 0; j < N; j++) {
					map[i][j] = new Point(i, j, str.charAt(j)-'0', 0);
				}
			}
			
			bfs(0,0);
			System.out.println("#" + testCase + result);
		}
	}
	
	private static void bfs(int i, int j) {
		Point current = map[i][j];
		Queue<Point> q = new LinkedList<>();
		int[][] visited = new int[N][N];
		q.offer(current);
		visited[i][j] = current.depth;
		while(!q.isEmpty()) {
			current = q.poll();
			for(int move = 0; move < 4; move++) {
				int nr = current.row + dr[move];
				int nc = current.col + dc[move];
				
				if(isLineOut(nr,nc)) continue;
				if(visited[nr][nc]==0) {	// 아예방문한적이 없는경우
					q.offer(map[nr][nc]);
					visited[nr][nc] = map[nr][nc].depth;
				}
				else {	// 방문한 적이 있기에 값이 0보다 큰 값으로 visited배열이 존재할때
					if(visited[nr][nc] > current.depth+visited[current.row][current.col]) { // 기존 visited에 저장된 거보다 복구시간 짧으면 바꿔서 넣기...
//						visited[nr][nc] = current.depth+visited[current.row][current.col];
						continue;
					}
					else {
						q.offer(map[nr][nc]);
						visited[nr][nc] += map[nr][nc].depth;
					}
				}
				
			}
		}
	}
	
	private static boolean isLineOut(int row, int col) {
		if(row < 0 || col < 0 || row >= N || col >= N)
			return true;
		return false;
	}
	
	
}
