package concepts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author : 김지현
 * @date : 2020. 12. 17
 * @description : NextPermutation으로 순열...
 * 우선 ,NP는 순열과 조합 둘다 가능함 + 시뮬레이션 알고리즘 풀 때 매우 유용하다 
 * 사전적의미 : 현 순열에서 사전 순으로 다음 순열 생성
 * 알고리즘 
 * 	1. NP사용전, 필히 숫자 배열들 오름차순으로 한번 정렬하기
 *  2. do ~ while ( np() ) 문... => while(np()) { ~~~ } 로 쓰게 되면, 가장 작은 순열 형태의 경우는 넘어간 상태로 시작하기때문에 do ~ while문 씀.
 *  3. np의 알고리즘
 *  	- 뒤부터 탐색하며 교환위치 찾기 [i가 꼭대기라 할때, i 인덱스 앞인 i-1의 인덱스의 값 찾기]
 *  	- 교환 위치(i-1)와 교환할 큰 값(j) 찾기 [j는 i-1보다 큰 값들 중 가장 작은 값]
 *		- 두 위치 (i-1, j) 교환
 *		- 꼭대기 위치부터 맨뒤까지 오름차순 정렬
 *			- 이때의 오름차순 정렬은 swap 형태 => 꼭대기위치~맨뒤는 내림차순 정렬 형태이기 때문에...
 */

public class Permutation_2_NP형 {
	
	static int N, R;
	static int[] input;
	static int totalCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		/* 쓴 값을 오름차순 최초 한번 오름차순 정렬해주고 시작 */
		Arrays.sort(input);		
		do {
			System.out.println(Arrays.toString(input));	
		} while(nextPermutation(input));
		
	}
	
	private static boolean nextPermutation(int[] numbers) {				
		//step1. 꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;	// 인덱스 생각해보자 => 0보다 큰값이여야함 + 꼭대기의 가장 큰위치 파악해야하니 --i
		
		// 이부분이 수행한다는 건, i가 0보다 크지 않거나 / 내려온 형태다...(step2)
		if(i==0) return false;		// 마지막 순열의 상태이면 다음 순열 없음
		
		//step2. i-1 위치와 교환할 다음단계 큰 수 뒤쪽에서 찾기
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;		// i-1보다 큰 j는 항상 존재한다. => 꼭대기 i가 있었기 때문에 i-1이 존재하는 것이기때문에
		
		//step3. i-1위치값과 j 위치값 교환
		swap(numbers, i-1, j);
		
		//step4. i위치부터 맨 뒤까지 오름차순 정렬 (내림차순 되어있는 것을 오름차순으로 정렬)
		int k = N-1;	// 맨뒤를 가리키는 k
		while(i<k) {	// 둘이 만나지 않았다는 조건
			swap(numbers, i++, k--);	// 증감은.. 스왑할 앞과 뒤의 인덱스를 이제 좁혀야한다했으니
		}

		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}

//Bitmask 코드에서 변형..
// 처음 생성된 순열에서 계쏙 개선해나가는것이기때문에 numbers배열 필요가없음
