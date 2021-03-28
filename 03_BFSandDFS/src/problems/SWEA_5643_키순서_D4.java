package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서_D4 {
	
	static int N, M, adj[][];
	static int gtCnt, LtCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1];
			StringTokenizer st = null;
			int i,j;
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			
			int answer = 0;
			for(int k = 1; k <= N; k++) {
				gtCnt = LtCnt = 0;
				gtBFS(k);
				ltBFS(k);
				if(gtCnt + LtCnt == N-1)
					answer++;
			}
			System.out.println("#" + testCase + answer);
		}
	}
	
	private static void gtBFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i = 1; i <= N; i++) {
				if(adj[k][i] == 1 && !visited[i]){
					q.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}
	private static void ltBFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i = 1; i <= N; i++) {
				if(adj[i][k] == 1 && !visited[i]){
					q.offer(i);
					visited[i] = true;
					LtCnt++;
				}
			}
		}
	}
}
