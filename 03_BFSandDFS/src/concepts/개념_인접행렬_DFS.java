package concepts;

import java.util.*;

/** 해당 코드는 인접행렬을 기준으로 DFS를 구현한 것이다. */

/*
 * DFS[깊이우선탐색] 이론 => 인접행렬시 O(N^2), 인접리스트 시 O(N+E) [N은 노드수, E는 간선수] 완전탐색 알고리즘으로서,
 * 모든 경우의 수를 탐색할 때 BFS와 함께 주로 쓰인다. (물론, DFS/BFS + @ 알고리즘 형태의 문제가 대다수임) 트리형태에서
 * 깊이 기준으로 탐색을 도는 것이다. (즉, 한 쪽을 끝까지 파고들고나서, 리프노드 찍었다면 한레벨 위로올라가 다른 방향 탐색)
 * 깊이우선은 한 우물을 끝까지 파고드는 그런 형식의 탐색이다.
 * 깊이우선과 너비우선을 너무 구분 지으려고 하지말자. 완전탐색을 한다는것은 공통이다.
 * 즉, 완전탐색을 하는데 있어서
 *  - 모든 노드를 방문하는 것이 주목적일 땐 => 둘 다 가능
 *  - 미로찾기나, 최단 경로를 구할 땐 => BFS가 유리 (DFS는 아님말고 형식으로 탐색하기에 BFS에 비해 비효율)
 *  - 경로의 특징을 저장해야하는 (어떤 조건에 한해) 경우 = DFS가 유리 (아님말고 식이지만, 각 노드를 다 체크하는 것이기에)
 *  - 검색 대상 그래프가 엄청 크다면, DFS가 유리
 *  - 검색 시작 지점으로부터 원하는 대상이 별로 멀지않고 그래프가 작다면, BFS가 유리
 */

/*
 * DFS 코드 (스택을 사용한다고는 하지만, 사실상 재귀함수로 처리) 
 * 1. 방문처리 (매개변수로 받는 노드)
 * 2. 반복문(매개변수로 받은 노드와 연관된 노드들 체크)
 * 2-1. 조건 처리 내 (방문하지않았고 + ~~) 나온 어떤 노드
 * 2-1. 재귀호출 => DFS(어떤노드);
 */

public class 개념_인접행렬_DFS {
	private static boolean[] visited;

	static int N;
	static boolean adjMatrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int E = sc.nextInt(); // 간선수
		
		adjMatrix = new boolean[N][N];
		visited = new boolean[N];
		for(int i = 0; i < E; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}
		System.out.println("=========dfs============");
		dfs(0);
	}
	
	private static void dfs(int current) {
		
		visited[current] = true;
		System.out.println((char)(current+65));
		
		for(int i=0; i<N; ++i) {
			if(adjMatrix[current][i] 
					&& !visited[i]) {
				dfs(i);
			}
		}
	}
}


/**
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/