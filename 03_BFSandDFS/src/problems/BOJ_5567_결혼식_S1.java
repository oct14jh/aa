package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식_S1 {


	private static int N, M;
	private static int result;
	
	private static List<Integer> relations[];
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		relations = new ArrayList[N];

		for(int i = 0; i < N; i++)
			relations[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
	 		int b = Integer.parseInt(st.nextToken()) - 1;
	 		
	 		relations[a].add(b);
	 		
		}
		
		bfs(0, 0);
		System.out.println(result);
	}


	private static void bfs(int sanggeun, int count) {
		Queue<ArrayList<Integer>> q = new LinkedList<>();
		int sanggeunFriend = 0;
		int current = sanggeun;
		
		q.offer((ArrayList<Integer>) relations[current]);
		visited[sanggeun] = true;
		
		while(!q.isEmpty()) {
			count += 1;
			current = q.poll().get(sanggeunFriend++);
			if(count >= 2)
				break;
			for(int i = 0; i < relations[current].size(); i++) {
				int nextFriend = relations[current].get(i);
				if(!visited[nextFriend]) {
					q.offer((ArrayList<Integer>) relations[nextFriend]);
					visited[nextFriend] = true;
				}
			}
			
		}
		
	}

	

}
