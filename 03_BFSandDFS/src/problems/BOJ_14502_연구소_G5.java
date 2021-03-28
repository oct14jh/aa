package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 우왕ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 이걸ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
 * 딱 보니, 벽(1) 3개를 우선처리해서 배치시켜놓고(조합)
 * 그상태에서 2를 확장시키는거지(bfs) 그래가지고, 안전영역 개수 체크하는거지
 * 그리고, 최소 개수 출력
 * 
 * 고러면으,, 조합 안에서 bfs를 돌리네? 조합 기저조건(벽3개뽑았을때) 내에서 ㅇㅇㅇ
 * 
 */
public class BOJ_14502_연구소_G5 {
	static class Point {
		int row;
		int col;

		public Point() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
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
	}

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int N, M;
	private static int[][] map;
	private static ArrayList<Point> zeroPoint = new ArrayList<>();
	private static int resultMax = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeroPoint.add(new Point(i, j));
				}
			}
		}
		Combination(0, 0, map);
		System.out.println(resultMax);
		br.close();
	}

	private static void Combination(int start, int count, int[][] arr) {
		if (count == 3) {
			bfs(arr);
			return;
		}
		for (int i = start; i < zeroPoint.size(); i++) {
			int r = zeroPoint.get(i).row;
			int c = zeroPoint.get(i).col;

			arr[r][c] = 1;
			Combination(i + 1, count + 1, arr);
			arr[r][c] = 0;
		}
	}

	private static void bfs(int[][] arr) {
		int zeroCount = 0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		ArrayList<Point> tempAL = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2) {
					tempAL.add(new Point(i,j));
				}
			}
		}
		for(int i=0;i<tempAL.size(); i++) {
			q.offer(tempAL.get(i));
			visited[tempAL.get(i).row][tempAL.get(i).col] = true;
			while(!q.isEmpty()) {
				Point tempPoint = q.poll();
				for(int move=0; move<4; move++) {
					int nr = tempPoint.row + dr[move];
					int nc = tempPoint.col + dc[move];
					
					if(!isLineOut(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 0) {
						arr[nr][nc] = 2;
						q.offer(new Point(nr,nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0)
					zeroCount++;
			}
		}
		if(zeroCount > resultMax) {
			resultMax = zeroCount;
		}
	}

	private static boolean isLineOut(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return true;
		}
		return false;
	}

}
