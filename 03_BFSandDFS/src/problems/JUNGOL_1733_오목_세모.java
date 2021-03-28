package problems;

import java.util.Scanner;

/**  
 * @author khyun 
 */
public class JUNGOL_1733_오목_세모 {
	static int[][] map = new int[19][19];
	
	// 오목에선 8방을 다 탐색할 필요가 없다. 북동, 동, 남동, 남쪽 총 4방향만 체크해주면 됨. (0,0부터 시작하기 때문에ㅇㅇ..그림그려보면 이해하기 수월할 것이다)
	static int[] dr = {-1, 0, 1, 1};
	static int[] dc = {1, 1, 1, 0};
	
	static int winner, winnerRow, winnerCol;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				for(int move = 0; move < 4; move++)
					dfs(i, j, move, 1);				
			}
		}
			
		
		System.out.println(winner);
		System.out.println(winnerRow + " " + winnerCol);
		
	}

	private static void dfs(int row, int col, int direction, int count) {
		int pr, pc;
		
		if(count>=6)
			return;
		if(count==5) {
			winner = map[row][col];
			winnerRow = row - (dr[direction]*4) + 1;
			winnerCol = col - (dc[direction]*4) + 1;
			return;
		}
		pr = row + dr[direction];
		pc = col + dc[direction];
		if(!isLineOut(pr, pc) && (map[row][col] != 0)) {
			if(map[row][col] == map[pr][pc])
				dfs(pr, pc, direction, count+1);
		}
		
	}

	private static boolean isLineOut(int row, int col) {
		if(row<0 || col<0 || row>=19 || col>=19)
			return true;
		return false;
	}
}