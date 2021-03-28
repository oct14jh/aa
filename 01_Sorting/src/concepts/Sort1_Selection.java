package concepts;

public class Sort1_Selection {
	Sort1_Selection(){};
	Sort1_Selection(int arr[]){
		for(int i=0; i<arr.length-1; i++) {
			int min = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[min] > arr[j]) 
					min = j; 
			}
			Sort_Main.swap(arr,i,min);
		}
	}
}

/*
선택정렬 : O(N^2) // 서치해서 가장 작은 값을 맨앞으로 보내고 인덱스 점프하여 그다음으로 작은 값 서치... 그런 알고리즘
 1) 하나를 선택 (큰반복문) [이 때, 선택된 인덱스 값을 min 인덱스로 생각할 것]
 2) 선택된 하나와 전체 요소들 비교 (작은반복문) [전체를 비교하면서  더 작은 것이 존재한다면, 그 작은 값이 위치한 인덱스의 값을 min 인덱스로 생각]
 3) 작은반복문 빠져나오면서 swap 해주면 최종적으로 가장 작은 값으로 골라진 min 인덱스에 위치한 값과 맨처음에 선택된 값과 교체되어진다. (고로 제일 작은 값이 맨앞으로 이동하는 셈)
*/