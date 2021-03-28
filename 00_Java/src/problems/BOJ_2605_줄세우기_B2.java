package problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기_B2 {
	private static int N;
	private static int[] frontValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		frontValue = new int[N];
		
		ArrayList<Integer> line = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			frontValue[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			line.add(i-frontValue[i], i+1);
		}
		for(int i : line)
			System.out.print(i + " ");
	}
}