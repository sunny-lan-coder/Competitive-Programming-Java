package wcipeg;

import java.util.Scanner;

public class dp1p1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int[] V = new int[N];
		int[][] dp = new int[N + 1][2];

		for (int i = 0; i < N; i++) {
			V[i] = s.nextInt();
		}
		s.close();

		for (int i = 0; i < N; i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
		}

		dp[0][0] = 0;
		dp[0][1] = 0;

		for (int i = 0; i < N; i++) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
			dp[i + 1][1] = V[i] + dp[i][0];
		}

		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
}