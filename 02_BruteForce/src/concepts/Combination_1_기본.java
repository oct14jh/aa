package concepts;

import java.util.Arrays;
import java.util.Scanner;

public class Combination_1_기본 {
	private static int N = 4, R=2;
	private static int[] numbers, inputs;	//순열 저장 배열, 입력된 숫자 배열
	private static boolean[] isSelected;	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		numbers = new int[R];	// 일단 3자리로 만들되 0부터쓸거기 때문에~ 
		inputs = new int[N];
		
		for(int i=0; i<N;i++) {
			inputs[i] = sc.nextInt();
		}
		
		combination(0,0);
	}
	
	
	//지정된 자리에 조합수 뽑기
	private static void combination(int cnt, int cnr) {	// cnt : 현재까지의 뽑은 조합의 개수, cnr : 조합에 시작점으로 시도할 원소 인덱스		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));		// 그냥 numbers 출력하면 주소뜨려나?
			return;
		}
		
		
		//시작위치 수부터 끝 수까지 시도
		for(int i=cnr; i<N; i++) {
			numbers[cnt] = inputs[i];
			combination(cnt+1,i+1);
		}
	}
	
}