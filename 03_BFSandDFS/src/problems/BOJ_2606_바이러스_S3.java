package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606_바이러스_S3 {
	private static ArrayList<Integer> table[]; 
	private static boolean[] visited;
	private static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		visited = new boolean[N];
		table = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			table[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < L; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			table[from].add(to);
			table[to].add(from);
		}
//		for(int i = 0; i < N ; i++) {
//			System.out.println(table[i].toString());
//		}
		
		// 1-0하면 왜안돼 왜안돼 개빡치네.. 하.. 이거땜에 안되었다 ㅠㅠㅠㅠㅠㅠㅠㅠㅠ
		bfs(0);
		
//		System.out.println("####");
//		for(ArrayList<Integer> tmp : table) {
//			System.out.println(tmp.toString());
//		}
		System.out.println(result);
	}

	private static void bfs(int startIdx) {
		Queue<ArrayList<Integer>> q = new LinkedList<>();
		q.offer(table[startIdx]);
		visited[startIdx] = true;
		while(!q.isEmpty()) {
			ArrayList<Integer> temp = q.poll();
			
			for(int i = 0; i < temp.size(); i++) {
				int tempValue = temp.get(i);
//				System.out.print(tempValue + " ");
				if(!visited[tempValue]) {
					q.offer(table[tempValue]);
					visited[tempValue] = true;
					result++;
				}
			}
//			System.out.println();
		}
	}
}
