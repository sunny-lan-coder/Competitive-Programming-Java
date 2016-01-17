package ccc.y2015;

import java.util.Scanner;

public class J5 {

	static int[][][] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		dp = new int[n + 1][k + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				for (int d = 0; d <= n; d++) {
					dp[i][j][d] = -1;
				}
			}
		}
		s.close();
		System.out.println(ways(k, n, 1));
	}

	static int ways(int k, int n, int l) {
		if (n < k)
			return 0;
		if (n < l)
			return 0;
		if (n == k) {
			if (1 >= l)
				return 1;
			else
				return 0;
		}
		if (k == 1) {
			if (n >= l)
				return 1;
			else
				return 0;
		}
		// System.out.println(" dp");

		if (dp[n][k][l] != -1)
			return dp[n][k][l];

		int tot = 0;
		for (int i = l; i < n; i++) {
			tot += ways(k - 1, n - i, i);
		}
		dp[n][k][l] = tot;
		return tot;
	}
}
