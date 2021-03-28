package concepts;

public class Sort7_Counting {
	public Sort7_Counting() {};
	public Sort7_Counting(int arr[]) {
		int count_value[] = new int[20];
		
		for(int i=0; i<count_value.length;i++)
			count_value[i] = 0;
		
		for(int i=0; i<arr.length; i++)
			count_value[arr[i]-1]++;
		
		for(int i=0; i<count_value.length; i++) {
			if(count_value[i] != 0) {
				for(int j=0; j<count_value[i]; j++)
					arr[i]=i+1;
			}
		}
	}
}

/*
계수정렬 : O(N) // 값의 범위가 정해져있는 경우 쓰이는 알고리즘... 즉 존재하는 최대값을 크기로 잡는 새 배열을 만들어서 해당 인덱스 값을 카운팅하며 인덱스0부터 출력하는 것이다.
*/