package concepts;

class Sort4_MergeTD {
	static int temp[] = new int[10000];
	public Sort4_MergeTD(){};
	public Sort4_MergeTD(int arr[]){
		int start = 0;
		int end = arr.length-1;
		merge_sort(arr,start,end);
	}
	
	
	void merge_sort(int arr[], int first, int last) {
		if(first < last) {
			int middle = (first+last)/2;
			merge_sort(arr,first,middle);
			merge_sort(arr,middle+1,last);
			merge(arr,first,middle,last);
		}
	}
	
	void merge(int arr[], int first, int middle, int last) {
		int x1 = first;
		int x2 = middle+1;
		int xx = first;
		
		while(x1 <= middle && x2 <= last) {
			if(arr[x1] < arr[x2]) 
				temp[xx++] = arr[x1++];
			else
				temp[xx++] = arr[x2++];
		}
		if(x1 > middle) {
			for(int i=x2; i<=last; i++)
				temp[xx++] = arr[i];
		}
		else {
			for(int i=x1; i<=middle; i++)
				temp[xx++] = arr[i];
		}
		
		for(int i=first; i<=last; i++)
			arr[i] = temp[i];
	}
}

/*
병합정렬 : O(N*logN) // 반으로 나뉘어진 조각 내에서 정렬하여 합치는(병합) 모양의 알고리즘
 1) 큰 형태로 보았을 땐, merge_sort()메소드와 merge()메소드를 활용한다. [merge_sort메소드 안에 재귀적으로 2번하되 마무리로 merge메소드 활용]
 
 2) merge_sort()메소드의 인자로는 시작값과 끝값만 고려하는 인자만 있으면된다.
 3) 시작값이 끝값 미만이라는 가정 하에서, middle이라는 값을 정의해주고 merge_sort(시작,중간), merge_sort(중간+1,끝), merge(시작,중간,끝) 이렇게 활용
 
 4) merge() 메소드의 인자로는  합치는 것이기에 시작, 중간, 끝이라는 인자를 고려해야한다.
 5) 조각1의 시작점(시작값), 조각2의 시작점(중간+1값) 그리고 조각1+2한 큰조각의 시작점(시작값)이라는 것을 정의내려준 후에
 6) 조각1의 시작점이 조각1의 끝점이하, 조각2의 시작점이 조각2의 끝점이하라는 가정하 무한반복을 돌려서
 7) 조각1과 2의 인덱스 0부터 시작하여 누가 더작냐를 비교하여 작은 값을 넣어주고 이용된 조각의 인덱스도 증가, 그리고 큰조각의 인덱스도 증가
 8) 제일 중요한건 조각 1,2 중에서 다 써서 비교할 게 없어진 경우인데 이 때, 이제 남는거를 다 때려박을 수 있도록 새로운 포문을 활용하는 것이다.
 
 - 추가적으로 BottomUp의 개선된 병합정렬도 있는데, 이 알고리즘은 조각을 2,4,6,8씩으로 정렬하는 것이라 정도만 알아두자.
*/