package concepts;

public class Sort2_Bubble {
	public Sort2_Bubble() {};
	public Sort2_Bubble(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					Sort_Main.swap(arr, j, j+1);
				}
			}
		}
	}
}

/*
버블정렬 : O(N^2) // 인덱스 01, 12, 23 처럼 겹쳐서 2개씩 값비교를 하여 계속해서 필요 시 swap 해주는 알고리즘... 가장 큰 값이 맨 뒤로 가는 그런 모양새를 보인다.
 1) 작은 반복문에서 j와 j+1를 비교하기 때문에, 조건 범위 잘 잡아줘야함
 2) 작은 반복문 다 수행하면 가장 큰값이 맨뒤로 가고, 이제 큰반복문은 일종의 횟수로 생각하면된다
*/