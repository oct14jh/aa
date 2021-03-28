package problems;

import java.util.Scanner;

public class SWEA_1952_수영장_모의역테 {
	private static int T;
	private static int result = Integer.MAX_VALUE;
	private static int[] fee = new int[4];
	private static int[] schedule = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < 4; i++)
				fee[i] = sc.nextInt();

			for (int i = 0; i < 12; i++)
				schedule[i] = sc.nextInt();

			if (result > fee[3])
				result = fee[3];

			dfs(0, 0);

			System.out.println("#" + testCase + " " + result);
		}

	}

	private static void dfs(int month, int totalFee) {
		if (month >= 12) {
			if (result > totalFee)
				result = totalFee;
			return;
		}

		if (schedule[month] == 0)
			dfs(month + 1, totalFee);
		else {
			dfs(month + 1, totalFee + (fee[0] * schedule[month]));
			dfs(month + 1, totalFee + fee[1]);
			dfs(month + 3, totalFee + fee[2]);
		}

	}
}

/*
이 문제를 접근했을 때, 경우의 수 엄청 나온다는 것을 알 수 있따... 그 때 딱 '아 이건 완탐'이라고 생각하면 된다?
어떻게 완탐이느냐? 모든 달을 1일 이용금으로 끊은 경우로 끝까지 체크를 해보고, 한달 앞으로 돌아가서 다음달만 1달 이용권끊은경우, 3달이용권끊은경우(단, 12-1-2월 안되기때문에 month >= 12 시 끝내는것으로 처리해버림)

1년 이용권만 미리 계산을 해두고, dfs 를 돌려보는 것이다.
*/