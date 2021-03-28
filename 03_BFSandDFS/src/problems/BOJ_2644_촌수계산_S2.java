package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산_S2 {
	private static int  N, M;	// N사람수, M관계수
	private static int A, B;
	private static boolean[] visited;
	private static ArrayList<Integer> relations[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine().trim());
		visited = new boolean[N+1];
		relations = new ArrayList[N+1];
		
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i <= M; i++)
			relations[i] = new ArrayList<>();

		for(int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int father = Integer.parseInt(st.nextToken());
			int son = Integer.parseInt(st.nextToken());
			
			relations[father].add(son);
			relations[son].add(father);
		}
		
		int result = dfs(A, B, 0);
		System.out.println(result);
	}
	
	private static int dfs(int start, int end, int count) {
		visited[start] = true;
		if(start == end) {
			count += 1;
			return count;
		}
		
		while(!relations[start].isEmpty()) {
			int idx = 0;
			int next = relations[start].get(idx++);
			if(!visited[next])
				dfs(next, end, count + 1);
		}
		return 0;
	}
}