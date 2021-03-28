package problems;

import java.util.Scanner;

public class SWEA_1210_Ladder1_D4 {
	
	private static int N = 100;
	private static int[][] map;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int tn = sc.nextInt();
			map = new int[N][N];
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					map[x][y] = sc.nextInt();
				}
			}

			/* 도착지점 X 인덱스 찾기 */
			int arrivalX = -1;
			for (int y = 0; y < N; y++) {
				if (map[99][y] == 2) {
					arrivalX = y;
					break;
				}
			}

			/* 사다리 타기 */
			int y = arrivalX, x = 98;
			while (x > 0) {
				if (isInBound(x, y - 1) && map[x][y - 1] == 1) {
					do {
						y--;
					} while (isInBound(x, y - 1) && map[x][y - 1] == 1);
				} 
				else if (isInBound(x, y + 1) && map[x][y + 1] == 1) {
					do {
						y++;
					} while (isInBound(x, y + 1) && map[x][y + 1] == 1);
				}
				x--;
			}

			System.out.println("#" + tn + " " + y);
		}

		sc.close();
	}

	public static boolean isInBound(int x, int y) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}
}
