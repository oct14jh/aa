package concepts;

public class Sort6_Heap {
	public Sort6_Heap() {};
	public Sort6_Heap(int arr[]) {
		for(int i=(arr.length/2)-1; i>=0; i--) {
			heapify(arr, arr.length, i);
		}
		
		for(int i=arr.length-1; i>0; i--) {
			Sort_Main.swap(arr, 0, i);
			heapify(arr ,i, 0);
		}
	}
	
	public static void heapify(int arr[], int size, int i) {
		int parent = i;
		int left = i*2 + 1;
		int right = i*2 + 2;
		
		if(left<size && arr[parent] < arr[left])
			parent = left;
		
		if(right<size && arr[parent] < arr[right])
			parent = right;
		
		if(i != parent) {
			Sort_Main.swap(arr, parent, i);
			heapify(arr, size, parent);
		}
	}
}

/*
힙정렬 : O(N*logN) // 완전이진트리 형태[왼쪽부터 차례대로 삽입함] + 루트에 최댓값/최솟값을 잡을 수 있는 heap[무조건 부모>자식 or 부모<자식임]이라는 자료구조를 활용한 알고리즘
 1) 모든 정렬이 일단 오름차순을 기준으로 정렬하기에 힙정렬의 경우도 최대힙정렬을 기준으로 하겠다
 2) (최대)힙을 이용한 것이므로 우선적으로 루트에는 가장 큰 값이 위치해야한다(부모>자식 이므로)
 3) 루트를 제외한 나머지 노드에 위치한 값들은 뒤죽박죽일 수 있는데 이런경우 다무시하고 제일 큰값에 위치한 루트값을 완전이진트리의 마지막 노드와 swap 해준다. 이런 알고리즘을 돌면서 정렬하는 것이다.
 
 4) 코드적으로 덧붙이자면, 첫 반복문에서는 힙을 먼저 하는 것이다(정렬이아니고 루트에 최댓값을 갖다놓기) [이 반복문에서 조건은 완전이진트리 구성을 고려하면 사이즈/2에서 -1한 값을 시작으로 0까지 감소연산]
 5) 사실.. 이 힙정렬만큼은 코드를 반복하고 손코딩하면서 눈에 익히는게 낫다.(이해가 잘안되니 우선적으로.. /2 이거 이해가 관건인듯)
 - 가장 크거나 작은 값을 구할 때
 - 최대 k만큼 떨어진 요소들을 정리할 때(삽입정렬을 통해서도 해결 가능)
*/
