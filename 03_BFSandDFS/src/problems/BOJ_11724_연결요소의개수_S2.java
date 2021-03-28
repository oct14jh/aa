package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수_S2 {
	private static ArrayList<Integer> datas[];
	private static boolean[] visited;
	private static int result;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		int N = sc.nextInt();
//		int M = sc.nextInt();
		visited = new boolean[N];
		datas = new ArrayList[N];
		
		
		for(int i=0; i<N; i++) {
			datas[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
//			int from = sc.nextInt() - 1;
//			int to = sc.nextInt() - 1;
			datas[from].add(to);
			datas[to].add(from);
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				bfs(i);
				result++;
			}
			
		}
		System.out.println(result);
//		sc.close();
		br.close();
	}
	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i]=true;
		
		while(!q.isEmpty()) {
			ArrayList<Integer> temp = datas[q.poll()];
			for(int tmp : temp) {
				if(!visited[tmp]) {
					q.offer(tmp);
					visited[tmp] = true;
				}
			}
		}
	}
}