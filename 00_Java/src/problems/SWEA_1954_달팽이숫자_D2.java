package problems;
import java.util.Scanner;

/**
 * 
 * @author : 김지현
 * @date : 2021. 1. 7
 * @description : 배열을 활용한 달팽이 문제로 일정한 규칙을 찾기만 하면 수월한 문제다.
 *
 */
public class SWEA_1954_달팽이숫자_D2 {
	private static int[][] arr;
	private static int n;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		int[] tn;
		T=sc.nextInt();
		tn = new int[T];
		for(int a=0;a<T;a++){
			tn[a] = sc.nextInt();
		}
		for(int test_case = 1; test_case <= T; test_case++){
			n = tn[test_case-1];
			arr = new int[n][n];
			int contents = 1, count = n*n, x=0, y=0, horizon = n, vertical = n-1;
			
			while(contents<=count) {
				for(int i=0; i<horizon;i++) {
					arr[x][y++] = contents++;
				}horizon--; x++; y--;
				for(int i=0; i<vertical; i++) {
					arr[x++][y] = contents++;
				} vertical--;x--;y--;
				for(int i=0; i<horizon;i++) {
					arr[x][y--] = contents++;
				}horizon--;x--;y++;
				for(int i=0; i<vertical; i++) {
					arr[x--][y] = contents++;
				} vertical--;x++;y++;
			}
			
			System.out.println("#"+test_case);
			for(int i=0;i <n;i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
