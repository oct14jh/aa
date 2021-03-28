package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수_S2 {
	private static int N, M;
	private static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		for(int i = 0; i < N+1; i++) {
			bfs(i, 0);
		}
	}
	private static void bfs(int i, int count) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int start = i;
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			start = q
		}
	}
	
		
		
		
		
	}
	
}
