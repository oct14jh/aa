package concepts;

class Sort5_Quick {
	public Sort5_Quick(){};
	public Sort5_Quick(int arr[]){
		int start = 0;
		int end = arr.length-1;
		quick_sort(arr, start, end);
	}
	
	void quick_sort(int arr[], int start, int end) {
		if(start >= end)
			return;
		
		int pivot = start;
		int i = start + 1;
		int j = end;
		
		while(i <= j) {
			while((i <= end) && (arr[i] <= arr[pivot])) i++;
			while((j > start) && (arr[j] >= arr[pivot])) j--;
			
			if(i < j)
				Sort_Main.swap(arr, i, j);
			else
				Sort_Main.swap(arr, j, pivot);
			
			quick_sort(arr, j+1, end);
			quick_sort(arr, start, j-1);
		}
	}
}

/*
퀵정렬 : O(N*logN) // pivot이라는 기준 값 잡고 우로 검색하면서는 기준값보다 큰값, 끝에서 좌로 검색하는건 기준값보다 작은 값을 찾아 swap + 서치 시 엇갈린 경우엔 작은 값과 pivot을 swap 해주는 알고리즘
 1) pivot이라는 기준값을 잡고 시작점부터 우로 이동하면서 기준값보다 큰 값(start), 끝점부터 좌로 이동하면서 기준값보다 작은 값(end)를 찾아 start와 end를 swap
 2) 우로 이동, 좌로 이동하다보면 둘이 엇갈리는 경우가 있다.(즉, 1번에서 swap이 안된경우는 다 이런경우라고 보면 됨)
 3) 이 땐, pivot과 end를 swap 해주는 것이다. (이렇게 swap 된 후 pivot값이 위치한 곳을 기준으로 좌측조각, 우측조각으로 보고 각 조각별로 다시 1)부터 수행)
 4) pivot은 조각별로 첫 인덱스값에 위치한 값이라 생각하면 된다.
 
 5) 코드적으로 설명을 덧붙이자면, 인자로는 시작점과 끝점만 고려하는 quick_sort()메소드를 재귀적으로 활용하는 것인데
 6) 우선 start값이 end 이상인 경우에는 종료를 한다.
 7) 그리고 pivot값은 start값으로, 우로 이동할 인덱스 체크 i는 start+1, 좌로이동할 인덱스 체크 j는 end로 잡아준다.
 8) i <= j 즉, 엇갈리지않는다는 가정하 무한반복을 돌려주는데, 그 반복은 i가 우로이동하면서 pivot보다 작은값, j가 좌로이동하면서 pivot보다 큰값을 서치하는 것이다.(+ i는 end, j는 start 넘으면안됨)
 9) 그래서 찾으면 arr[i]과 arr[j]의 값을 swap해주고, 엇갈린 경우엔 arr[j]와 arr[pivot]을 swap하는 것이다.
 [이 때, 8) 족너에서 엇갈리지않는다는 조건걸지 않았냐할수있는데, i++, j--를 계속해주기에 반복분 내에서 엇갈리는 경우가 발생할 수 있음. ]
 10) 그렇게 돌고 나면, 원래 pivot위치에 존재하던 값은 j+1와 swap 되었기에 스왑된 그곳을 기준으로 조각1(j+1~end)과 조각2(start~j-1)로 구분되어지는 것이다.
 
 - 평균적으로 제일 빠른 알고리즘이지만, 최악의경우엔 O(N^2) 성능을 보인다. 그 경우는 이미 정렬된 경우다. (이유:이미 정렬되어있는데 좌에서 큰값, 우에서 큰값 다 서치하므로)
*/