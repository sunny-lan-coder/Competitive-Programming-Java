package ccc.s2015;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.max;

public class ccc15s6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		int m = s.nextInt();
		long[] b = new long[m + 1];
		// offset b by one, to prevent index out of bounds
		for (int i = 1; i <= m; i++) {
			b[i] = s.nextInt();
		}
		s.close();
		// give dp array extra room for base cases
		long[][][] dp = new long[n + 1][m + 2][m + 2];
		for (int line = 0; line <= n; line++) {
			for (int i = 0; i <= m + 1; i++) {
				for (int j = 0; j <= m + 1; j++) {
					dp[line][i][j] = -1;
				}
			}
		}
		Arrays.sort(b);

	}

}
