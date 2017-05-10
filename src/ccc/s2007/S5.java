	package ccc.s2007;

import java.util.Scanner;

public class S5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int testcase = 0; testcase < t; testcase++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int w = s.nextInt();

			int[] v = new int[n];
			int[][] dp = new int[n + 1][k + 1];
			int[] prefix = new int[n + 1];

			for (int i = 0; i < n; i++) {
				v[i] = s.nextInt();
				prefix[i + 1] += v[i];
				prefix[i + 1] += prefix[i];
				for (int j = 0; j <= k; j++)
					dp[i][j] = -1;
			}
			for (int j = 0; j <= k; j++)
				dp[n][j] = -1;

			dp[0][k] = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= k; j++) {
					if (dp[i][j] != -1) {
						dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
						dp[Math.min(i + w, n)][j - 1] = Math.max(dp[Math.min(i + w,n)][j - 1],
								dp[i][j] + (prefix[Math.min(i + w, n)] - prefix[i]));
					}
				}
			}

			int max = 0;
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= k; j++)
					max = Math.max(max, dp[i][j]);

			System.out.println(max);
		}
		s.close();
	}

}
