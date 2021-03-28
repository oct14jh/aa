package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브_G4 {
	static class Dragon {
		int x;	// col
		int y;	// row
		int d;	// direction
		int g;	// generation
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		public int getG() {
			return g;
		}
		public void setG(int g) {
			this.g = g;
		}
		public Dragon() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Dragon(int x, int y, int d, int g) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
		@Override
		public String toString() {
			return "Dragon [x=" + x + ", y=" + y + ", d=" + d + ", g=" + g + "]";
		}
		
		
	}
	private static int N;
	private static boolean[][] visited = new boolean[100][100];
	private static ArrayList<Dragon> dragonArr = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i < N; i++) {
			int x, y, d, g;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				g = Integer.parseInt(st.nextToken());
				dragonArr.add(new Dragon(x, y, d, g));
			}
		}
		
		
	}
}


/*
0 -> 우 => x값(col) +1
1 -> 상 => y값(row) -1
2 -> 좌 => x값(col) -1
3 -> 하 => y값(row) +1


-- 루틴
세대 0세대 => 방향값 받기(a)
세대 1세대 => 방향값 받기(a) + a에서+1한 값(b)
세대 2세대 => 방향값 받기(a) + a에서+1한 값(b) + b+1 + a+1
...
이렇게 방향 다 잡아주고나서, 방문체크 처리 다해주고
for(i 0~98)
	for(j 0~98)
		visited[i][j] = true 면서,
		visited[i+1][j] = true 면서,
		visited[i][j+1] = true 면서,
		visited[i+1][j+1] = true 
		4개의 조건 다 부합할경우 사각형 개수(squareCount)++ 해준다.
		
		
*/