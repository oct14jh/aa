package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥_G5_X {

	static int N, d, k, c, dMAX = Integer.MIN_VALUE, result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		br.close();
		
		for(int i=0; i<N; i++) {
			if(i>=N-k+1)		
				break;
			
			int start = i;
			int end = i+k;
			checkEat(start, end);
		}
		System.out.println(result);
	}
	private static void checkEat(int start, int end) {
		int count = 0;
		
		int[] sushi = new int[d+1];
		Arrays.fill(sushi,0);
		
		for(int i = start; i<end; i++) {
			sushi[arr[i]]++;
		}
		for(int dCheck : sushi) {
			if(dCheck >= 1)
				count++;
		}
		
		if(dMAX == Integer.MIN_VALUE) {		
			dMAX = count;
			result = dMAX;
			return;
		}
		
		if(dMAX <= count) {
			dMAX = count;
			if(sushi[c]==0) {
				result = dMAX + 1;
			}else {
				result = dMAX;
			}
		}
		else
			return;
	}
	
}
