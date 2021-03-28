package concepts;

import java.util.Arrays;
import java.util.*;

// 1~N까지의 수를 모두 뽑아 순서적으로 나열	//두번재는 입력받은 N개의 숫자중 R개를 선택하는 순열
public class Permutation_1_기본 {
	private static int N = 4, R=2;
	private static int[] numbers, inputs;	//순열 저장 배열, 입력된 숫자 배열
	private static boolean[] isSelected;	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		numbers = new int[R];	// 일단 3자리로 만들되 0부터쓸거기 때문에~ 
		inputs = new int[N];
		isSelected = new boolean[N];
		for(int i=0; i<N;i++) {
			inputs[i] = sc.nextInt();
		}
		
		permutation(0);
	}
	
	
	//지정된 자리의 순열 뽑기 (1번수행할때마다 자리라 생각하면될듯)
	private static void permutation(int cnt) {	// cnt : 현재까지의 뽑은 순열의 개수
		
		//끝을 만나긴 해야하니깐(기저조건)
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i])	continue;
			numbers[cnt] = i;	// i숫자를 선택하되, 지정된 자리에 들어가야하므로 cnt를인덱스로 넣는다. 즉, 해당숫자 사용
			isSelected[i] = true;	//이제 사용했다고 표시
			
			permutation(cnt+1);	// 자리바꿔주고, 그 자리가 뽑은 갯수가된다

		}
	}
	
}