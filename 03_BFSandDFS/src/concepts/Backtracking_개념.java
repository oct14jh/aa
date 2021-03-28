package concepts;

import java.util.Scanner;

/**
 * 
 * @author : 김지현
 * @date : 2020. 12. 18
 * @description : 백트랙킹 알고리즘을 N-Queen 문제로 설명함.. [체스판이라고 2차원배열로 표현X => 단순 행,열 값으로 체킹가능하기때문에]
 * 
 *
 */

// N-Queen 문제 기반..
public class Backtracking_개념 {
	static int N;
	static int[] col;	// 각 행의 퀸의 위치를 저장할 배열
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];	// 0행은 안쓴다고 생각하고 할거라 +1
		
		setQueens(1);	// 퀸을 현재 행에 놓기 (1행)
		System.out.println(N+"개의 Queen이 체스판에 다 놓아진 최초의 경우를 찾은 동안 서치한 횟수 : " + answer);
	}
	
	// 퀸을 하나씩 놓는 메소드 => 퀸을 현재 행에 놓기
	public static void setQueens(int row) {	// 매개변수는 메소드 부를때마다 항상 값이 달라지는 것을 집어넣으면 되기에, row라는 변수 삽입		
		if(row > N) {	// 유망한 경우에만 row가 증가된 것으로 setQueen메소드 실행하기에 결과적으로 4개의 퀸을 놓는게 성공했다는 것이기에.. 즉 
			answer++;
			return;
		}
		
		//현재 행에 놓을 수 있는 가능한 선택지 
		for(int j = 1; j <= N; j++) {	// 모든 경우(1열~N열)를 다 체크해보는 것이다.
			col[row] = j;			// 퀸을 해당 row 자리에 놓아보고
			if(checking(row))		// 여기 놓아도 되는 곳이니 판단하는 메소드 (놓아도 된다고 판단되는경우에만 다음 퀸(setQueens) 놓겠다.
				setQueens(row+1);		// 그리고 다음 row에 퀸을 놓겠다..
			
			//2차원배열이라면, 놓았던 저걸 0으로 (다시미방문) 처리할 필요가 있는데 1차원배열로하면 되돌려 놓을 일이 없다!!
//			col[row] = 0; 	//같은 자리를 계쏙 덮어버리기에 필요가없다.
		}
	}

	// row행의 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true, 없다면 false를 반환
	private static boolean checking(int row) {
		// 체킹방법 : 현재 퀸을 기점으로 이전에 놓았던 퀸의 공격범위를 고려해서 범위에 해당하지 않으면 놓을 수 있다는 것이다.
		for(int i = 1; i < row; i++) {		// 첫번째 퀸부터 직전 퀸까지를 비교하고자 반복값을 1부터 row-1로 줌.
			
			// 현재 퀸과 이전의 퀸들의 열위치가 같다면, 같은 열에 존재한다는 것이다. || 대각선(X자) 체크 =>규칙성 파악 필요(그림그려가면서)=>현재퀸 값과 이전퀸 값에서 행차이와 열차이가 같으면 대각선
			if((col[row] == col[i]) || Math.abs(col[row]-col[i]) == row - i) { 
				return false; 
			} // 이러한 조건들이라면 놓을 수 없다는 것이기에 false로 반환
		}
		return true;
	}
}

/*
 setQueens메소드에서 모든 경우의 수를 체크할 경우 기저조건 아래에
 //현재 행에 놓을 수 있는 가능한 선택지 (즉, 옳은 경우든말든 간에 다 놓아보는 거임)
		for(int j = 1; j <= N; j++) {	// 모든 경우(1열~N열)를 다 체크해보는 것이다.
			col[row] = j;			// 퀸을 해당 row 자리에 놓겠다.
			setQueens(row+1);		// 그리고 다음 row에 퀸을 놓겠다..
		}
*/