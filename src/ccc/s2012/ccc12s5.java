package ccc.s2012;

import java.util.Scanner;

public class ccc12s5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int c = s.nextInt();
		int k = s.nextInt();
		boolean[][] cages = new boolean[r][c];
		for (int i = 0; i < k; i++) {
			int kr = s.nextInt() - 1;
			int kc = s.nextInt() - 1;
			cages[kr][kc] = true;
		}
		s.close();
		int[][] dp = new int[r][c];
		dp[0][0] = 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (cages[i][j])
					continue;
				if (i + 1 < r)
					dp[i + 1][j] += dp[i][j];
				if (j + 1 < c)
					dp[i][j + 1] += dp[i][j];
			}
		}
		System.out.println(dp[r - 1][c - 1]);
	}

}
