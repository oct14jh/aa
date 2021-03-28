package concepts;

import java.util.Scanner;

/**
 * 
 * @author : 김지현
 * @date : 2020. 12. 18
 * @description : 부분집합을 비트마스킹으로 표현하기 => Binary Counting
 *  - 이 알고리즘을 사용하는 것은, 부분집합은 2^n 값(10진수)을 비트화 해서 해당 비트의 인덱스로 부분집합 처리하는 것이다. 
 *  - 성능은 사실상 크게 차이가 없다...(일반 부분집합 알고리즘과 비교했을 때)
 *  - 제일 중요한 것은, 비트 인덱스와 숫자 배열의 인덱스 매칭은 거꾸로 (즉 비트 인덱스 0,1,2,3 이면 숫자배열 인덱스의 매칭은 3,2,1,0 으로)
 *  	=> left shift를 통해 & 연산을 통해 o/x여부 체크 때문에...
 *
 */
// binaryCounting
public class Subset_2_비트마스킹 {
	static int N;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int caseCount = 1 << N;		// 입력한 원소 인덱스 접근을 위한 변수 caseCount (2^N인셈)
		generateSubset(caseCount);
	}

	private static void generateSubset(int caseCount) {
		// 십진수 0~(2^n - 1) 즉,, flag의 각 비트자리르 확인하여 원소 선택 유무를 판단한다.	
		// 부분집합 경우의 수만큼 반복
		for(int flag = 0; flag < caseCount; flag++) {		// 적어도 1개 이상의 원소가 선택된 경우의 수 출력을 원하면, 시작값으로 flag = 1로 둔다.
			
			for(int i = 0; i < N; i++) {	// 자리수 만큼 반복 
				if((flag & (1<<i)) != 0) {			// (1<<i)는 내가 확인하고싶은 원소의 인덱스... 0이 아닌 것은 1이라는 의미. 즉, 사용한다는 의미
					System.out.print(numbers[i] + " ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		
	}
}
