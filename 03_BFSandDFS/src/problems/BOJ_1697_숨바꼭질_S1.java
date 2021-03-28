package problems;

import java.util.Scanner;

public class BOJ_1697_숨바꼭질_S1{
	private static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result = dfs(N, K, 0);

		System.out.println(result);
	}
	
	private static int dfs(int n, int k, int count) {
		if(n == k) {
			return count;
		}
		
		int temp1 = n-1;
		int temp2 = n+1;
		int temp3 = n*2;
			
		if(!isLineOut(temp1)) {
			dfs(temp1, k, count+1);
		}
		else if(!isLineOut(temp2)) {
			dfs(temp2, k, count+1);
		}
		else {
			dfs(temp3, k, count+1);
		}
		return 0;		
	}
	
	private static boolean isLineOut(int index) {
		if(index < 0 || index >= 100001 || visited[index] == true) {
			return true;
		}
		return false;
	}
}