package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미로탐색은 bfs알고리즘을 활용하면서도, 사방탐색을 하는것이다.
 * 해당 문제에서 출력값은 도착지점에 할 수 있는 최단경로값을 출력하는 것이라 count 처리가 필요하다.
 * 내가 범한 실수는 count 처리를 옳게 못한 것이다(즉, bfs는 dfs처럼 잘못된 길이면 뒤로 빽하면서 count-- 이런걸 못하고, 그냥 큐에 처리되면 무조건적으로 count++ 되기때문에 최단경로 값이 안뜬다.
 * 고로, 여기에 고민할 필요가 있는데, 이 고민 해결점이 Point라는 클래스 객체 활용하는 것이다.
 * count라는 변수를 추가해서 각 배열마다 count값을 넣어주는 것이다. 니가 몇번째 큐에서 나왔으니 넌 카운트값이 얼마겠구나 하고 저장해두는것이다.
 * 그럴때, 이제 도착지점으로 사방탐색 바로 직전의 포인트에서 count값을 +1 한것이 도착지점의 count가 되는것이고 해당값이 도착했을때의 최단경로 카운트값이 되는것이다
 * 
 * 해당 문제는 크기 제한이 문제가 되지않기때문에 인접행렬로 풀어도 된다. (뭐,,간선리스트로 못할건없다.)
 */

class Point {
	int r;
	int c;
	int count;
	
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Point(int r, int c, int count) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
	}
	
	
}
public class BOJ_2178_미로탐색_S1 {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Point[] arr = new Point[N*M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				arr[(i*M)+j] = new Point(i, j);
			}
		}
		bfs(0, 0, 1);
		System.out.println(result);
		
	}
	private static void bfs(int i, int j, int count) {
		Queue<Point> q = new LinkedList<>();
		Point current = new Point(i, j, count);
		q.offer(current);
		while(!q.isEmpty()) {
			current = q.poll();
			
			if(current.r == N-1 && current.c == M-1) {
				result = count;
				return;
			}
			visited[current.r][current.c] = true;
			int nr = 0;
			int nc = 0;
			for(int m = 0; m < 4; m++) {
				nr = current.r + dr[m];
				nc = current.c + dc[m];
				
				if(isLineOut(nr,nc))
					continue;
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					q.offer(new Point(nr, nc, count++));
					visited[nr][nc] = true;
				}
			}
		}
	}
	private static boolean isLineOut(int r, int c) {
		if(r < 0 || r > N-1 || c < 0 || c > M-1)
			return true;
		return false;
	}
	
	
}
