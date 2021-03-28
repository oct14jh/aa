package concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * 인접행렬은 쓸데없는 메모리 낭비 등이 심할 수 있기에, N,M 등의 문제에 제시된 최대값을 잘고려해봐야함.
 * 고로, 이 문제는 간선리스트로 DFS와 BFS를 구현한 문제다.
 * DFS와 BFS는 개념 코드를 봐도되고, 이코드를 보면서 좀더 숙달하면 됨
 */

/*
 * 간선리스트 구현 시 주의해야할 점
 * List<Integer> arr = new LinkedList<>(); 보통 이렇게 쓰는데
 * 이제 간선리스트는 배열적으로도 접근이 필요하기에
 * List<Integer> arr[] = new LinkedList<>()[N]; 이러고 싶을 거다 근데 절대안됨.. 그럼 어떻게 하느냐?!
 * 
 * List<Integer> arr[] = new LinkedList[N];	// 이렇게 배열틀이라는 것을 먼저 선언해준뒤
 * for(int i = 0; i<N; i++){
 * 	arr[i] = new LinkedList<Integer>();
 * 요런식으로 써먹어줘야한다!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 그리고 가장 주의해야할 점은 from - to 무향일 땐, 양방향이므로 from-to 인 것은 to-from 도 연결된 것이기에 add 2번..(from.add(to), to.add(from) 이런식)
 */

public class BOJ_1260_DFS와BFS_S2 {
	private static int N, M, V;	// 정점 수, 간선 수, 시작정점
	private static List<Integer> a[];
	private static boolean[] visitedDFS;	// dfs 시, 방문했는지 체크하고자 쓰는 boolean형 배열
	private static boolean[] visitedBFS;	// bfs 시, 방문했는지 체크하고자 쓰는 boolean형 배열 (bfs는 재귀가 아니기에, 지역적으로 선언해도됨)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		visitedDFS = new boolean[N+1];	
		visitedBFS = new boolean[N+1];
		
		a = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			a[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			a[from].add(to);
			a[to].add(from);
		}
		for(int i = 1; i<N+1;i++) {
			a[i].sort(null);
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
		sc.close();
	}
	
	private static void dfs(int v) {
		visitedDFS[v] = true;
		System.out.print(v + " ");
		
		for(int current : a[v]) {
			if(!visitedDFS[current])
				dfs(current);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		int current = v;

		q.offer(current);
		visitedBFS[v] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.print(current + " ");
			
			for(int temp : a[current]) {
				if(!visitedBFS[temp]) {
					q.offer(temp);
					visitedBFS[temp] = true;
				}
			}
		}
	}
}