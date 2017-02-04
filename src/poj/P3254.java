package poj;

import java.util.Scanner;

public class P3254 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] things = new int[n];
		for (int i = 0; i < n; i++) {
			int tmp = 0;
			for (int j = 0; j < m; j++) {
				if (s.nextInt() == 1) {
					tmp |= 1 << j;
				}
			}
			things[i] = tmp;
		}
		s.close();

		int lim = (1 << m);
		long[][] dp = new long[n][lim];

		for (int j = 0; j < lim; j++) {
			if ((j & ~things[0]) == 0) {
				if ((j << 1 & j) == 0 || (j >> 1 & j) == 0) {
					dp[0][j] = 1;
				}
			}

		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < lim; j++) {
				if ((j & ~things[i]) == 0) {
					if ((j << 1 & j) == 0 || (j >> 1 & j) == 0) {
						for (int k = 0; k < lim; k++) {
							if ((k & j) == 0) {
								dp[i][j] += dp[i - 1][k];
								dp[i][j] %= 1000000000;
							}
						}
					}
				}
			}
		}

		int sum = 0;
		for (int j = 0; j < lim; j++) {
			sum += dp[n - 1][j];
			sum %= 1000000000;
		}
		System.out.println(sum);
	}

}
