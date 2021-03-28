package concepts;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 해당 코드는 인접행렬을 기준으로 BFS를 구현한 것이다. */

/*
 * BFS[너비우선탐색] 이론 => 인접행렬시 O(N^2), 인접리스트 시 O(N+E) [N은 노드수, E는 간선수] 완전탐색 알고리즘으로서,
 * 모든 경우의 수를 탐색할 때 DFS와 함께 주로 쓰인다. (물론, BFS/DFS + @ 알고리즘 형태의 문제가 대다수임) 트리형태에서
 * 너비(같은레벨) 기준으로 탐색을 다 도는 것이다. (즉, 같은 레벨의 노드들을 탐색하는 것) BFS는 보통, 모든 경우의 수를 다 고려해서
 * 탐색하는 문제 때 주로 쓰인다. - 어떤 한 지점에서부터 어떤 지점까지의 최단경로 구할 때(현재 정점에 연결된 가까운 정점들부터 검색)
 */

/*
 * BFS 코드 
 * 1. 큐를 생성 
 * 2. 맨 처음엔, 루트 노드를 큐에 삽입하고 시작한다. 
 * 3. 무한반복(큐가 빌때까지) 
 * 3-1. 큐에 하나를 꺼낸다. (임의 변수에 저장) 
 * 3-2. 방문처리(방문 처리 배열의 인덱스값을 임의변수 값으로) 
 * 3-3. 반복문(임의변수와 연결된 것들을 다 체크하기 위함) => 연결된 다른 노드값을 방문처리하고, 큐에 삽입... 
 * *. 중요 포인트는 큐에 들어갈 때, 방문처리를 해줘야한다.[BFS2] (나올 때 방문처리 중복된 노드가 큐에 삽입될수있다 : BFS1 (주석부분을 해제하면, 문제 해결되긴함))
 * *. 추가로, 방문처리하는 배열은 BFS에선 내부로 선언해줘도된다.(큐는 재귀를 적용하기에 공유하는 것처럼 사용해야함.. 즉, staic으로)
 */

public class 개념_인접행렬_BFS {
	static int N;
	static boolean adjMatrix[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int E = sc.nextInt(); // 간선수

		adjMatrix = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < E; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}

		bfs1();
		System.out.println("==================");
		bfs2();

	}

	private static boolean[] visited;

	// 나와서 방문 처리
	private static void bfs1() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];

		int current = 0;
		queue.offer(current);

		while (!queue.isEmpty()) {
			current = queue.poll();
//			if(visited[current])		// 방문한적있는 값이면 skip~ 
//				continue;				// 이거 써줘야 큐에 중복값 안드감.. 안써주면 큐에 eefff 이런 경우생김
			visited[current] = true; // 방법1 : 나올 때 방문 처리
			System.out.println((char) (current + 65));
			for (int i = 0; i < N; ++i) {
				if (adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
				}
			}
		}
	}

	// 들어갈 때 방문 처리.. 들어갈때방문처리를 해보자.
	private static void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];

		int current = 0;
		queue.offer(current);
		visited[current] = true;

		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char) (current + 65));

			for (int i = 0; i < N; ++i) {
				if (adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true; // 방법2 : 들어갈때 방문 처리
				}
			}
		}
	}
}

/**
 * 7 8 0 1 0 2 1 3 1 4 2 4 3 5 4 5 5 6
 */