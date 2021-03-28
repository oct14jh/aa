package concepts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author : 김지현
 * @date : 2020. 12. 18
 * @description : 최소신장트리 중 하나인 Prim 알고리즘
 * 임의의 시작 정점에서 간선들 중 최소 간선 연결된 다음 노드
 * 시작정점과 다음 노드에 연결되어있는 모든 간선들 중 최소 간선 연결된 그다음 노드...
 * 이런식으로 체킹하는 것이다...
 * 간선이 많을 땐, 크루스칼 보다 더 유용하지만 간선이 무수히 많으면 프림 알고리즘도 문제 발생
 * 		- 간만프인 이유 : 간선이 많게되면 크루스칼에선 사이클 체킹을 많이 해야하므로...(사이클 유발시, 처리간선 많아짐)
 * 		- 프림도 안되는 경우 : PriorityQueue를 활용해서 프림 알고리즘 구현
 *
 */
public class Prim {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] input = new int[N][N];	// 입력 배열
		int[] minEdge = new int[N];	// 내가 누구랑 연결했을 때 가장 최소인지 관리해주는 배열
		boolean[] visited = new boolean[N];	// 신장트리에 포함되었는지 정점 체크하고자 쓰이는 배열
		
		
		// i노드에서 j노드까지의 비용을 모두 배열에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;	// 최소값을 관리해주고자 일단 초기화는 무조건 큰값선언해주고 시작..(따져보면서 작은비용으로 업데이트) 
		}	
		
		int minVertex, min, result = 0;
		
		//임의 정점에서 출발하면되는데, 0번 정점으로 시작한다고 가정하고 코드작성..
		minEdge[0] = 0;	// 처음 시작점으로 쓸 땐 최소 간선비용으로 0으로 두고 출발 시작.
		
		for (int c = 0; c < N; c++) {	// 정점 수만큼 반복. (정점 N개를 연결해야하므로)
			//신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
			min = Integer.MAX_VALUE;	// 일단 최소값은 최대값으로 선언
			minVertex = 0;				// 이때 minVertex가 누군지 기억하고자 선언
			for (int i = 0; i < N; i++) {	//N번 들여다보면서 => 전체 정점 중 간선비용이 최소인 것을 찾는 거임.(pq접목시키면 매우 효율적이게 된다)
				if(!visited[i] && (min > minEdge[i])) {	// 신장트리에 포함되지않았고(visited==false) + 현재 자신의 minEdge비용이 min보다 작다면 
					min = minEdge[i];		// 해당의 minEdge값을 min값으로 잡아준다. 
					minVertex = i;			
				}
			}
			
			// 최소비용의 합을 구해야 함 => 신장트리 비용 누적
			result += min;
			visited[minVertex] = true;	//신장트리에 포함 시켰다고 처리.
			
			//선택된 최소비용 정점 기준으로, 신장트리에 포함되지 않은 다른 정점으로의 비용 계산하여 최소값 갱신
			for (int i = 0; i < N; i++) {	
				// 신장트리에 포함되지않은 정점이면서 + 0이 아니고(인접한애들만 가능하다는말) + 다른 정점에서 올 수 있는 최소비용과 현 내가 가려는 정점비용과 비교해서 더 작을 때
				if(!visited[i] && (input[minVertex][i] != 0) && (minEdge[i] > input[minVertex][i]))
						minEdge[i] = input[minVertex][i];	// 현재정점에서 가는 비용이 더 작다면, minEdge를 업데이트
			}
		}
		System.out.println(result);
	}
}
