package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author khyun
 * @description 한 공간 내 양과 늑대 개수 체크를 통한 bfs
 * 
 *              공간 분리를 하면서, 한 공간 내에서 양과 늑대의 개수를 바로 체크해서 한 공간 내 양>늑대 시,N 늑대 수 0으로
 *              고려해서 전역변수 늑대에 계산... 이런식으로 하는건데 주의해야할 점은, 첫 접근할 때(bfs에서)
 *              빼먹지말아야함.. 첫접근에서의 늑대인지 양인지 체킹도 꼭해주어야함!!!!!!!!!
 *              
 *              별도로 공간분리할때도 visited와 lineout 체크 필히해주어야함!!(이거자주하는실수임;)
 */

public class BOJ_3184_양_S2 {
	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int R, C;
	private static char[][] map;
	private static int Lamp, Wolf;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isLineOut(i, j) && !visited[i][j])
					bfs(i, j);
			}
		}

		System.out.println(Lamp + " " + Wolf);
	}

	private static void bfs(int r, int c) {
		int checkWolf = 0;
		int checkLamp = 0;

		Point current = new Point(r, c);
		Queue<Point> q = new LinkedList<>();

		q.offer(current);
		visited[r][c] = true;
		if (map[r][c] == 'v')
			checkWolf++;
		if (map[r][c] == 'o')
			checkLamp++;
		while (!q.isEmpty()) {
			current = q.poll();

			for (int move = 0; move < 4; move++) {
				int nr = current.row + dr[move];
				int nc = current.col + dc[move];
				if (isLineOut(nr, nc) || visited[nr][nc])
					continue;
				q.offer(new Point(nr, nc));
				visited[nr][nc] = true;
				if (map[nr][nc] == 'v')
					checkWolf++;
				if (map[nr][nc] == 'o')
					checkLamp++;
			}
		}
		if (checkWolf < checkLamp) {
			checkWolf = 0;
			Wolf += checkWolf;
			Lamp += checkLamp;
		} else {
			checkLamp = 0;
			Wolf += checkWolf;
			Lamp += checkLamp;
		}
	}

	private static boolean isLineOut(int row, int col) {
		if (row < 0 || col < 0 || row >= R || col >= C || map[row][col] == '#')
			return true;
		return false;
	}
}
