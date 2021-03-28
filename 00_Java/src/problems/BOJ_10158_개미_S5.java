package problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int colX;
	int rowY;
	public Point() { super(); }
	
	public Point(int colX, int rowY) {
		super();
		this.colX = colX;
		this.rowY = rowY;
	}
}

public class BOJ_10158_개미_S5 {
	private static Point[][] map;
	private static int widthCol, heightRow, time;
	private static int[] dr = {-1, -1, 1, 1};
	private static int[] dc = {1, -1, -1, 1};
	private static int resultX, resultY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		widthCol = Integer.parseInt(st.nextToken());
		heightRow = Integer.parseInt(st.nextToken());
		map = new Point[heightRow+1][widthCol+1];			
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		Point ant = new Point();	
		ant.colX = Integer.parseInt(st.nextToken());
		ant.rowY = Integer.parseInt(st.nextToken());
		
		time = Integer.parseInt(br.readLine().trim());

		for (int row = 0; row < heightRow + 1; row++) {
			for (int col = 0; col < widthCol + 1; col++) {
				map[row][col] = new Point(col, heightRow-row);
			}
		}
		int presentRow = 0, presentCol = 0;
		int countCycle = 0;
		for (int i = 0; i < heightRow+1; i++) {
			for(int j=0; j < widthCol+1; j++) {
				if(map[i][j].colX == ant.colX && map[i][j].rowY == ant.rowY) {
					presentRow = i;
					presentCol = j;
					break;
				}
			}
		}
		
		for(int i=presentRow; i<heightRow+1; i++) {
			for(int j=presentCol; j<widthCol+1; j++) {
				if(lineOut(i,j)) {
					if(countCycle == 3) {
						countCycle = -1;
					}
					countCycle++;
				}
				else {
					presentRow = i + dr[countCycle];
					presentCol = j + dc[countCycle];
					time--;
				}
				if(time < 0) {
					resultX = map[presentRow][presentCol].colX;
					resultY = map[presentRow][presentCol].rowY;
					System.out.println(resultX + " " + resultY);
					return;
				}
			}
		}
	}
	
	private static boolean lineOut(int row, int col) {
		if(row<0 || col<0 || row >= heightRow || col >= widthCol) {
			return true;
		}
		return false;
	}
}
