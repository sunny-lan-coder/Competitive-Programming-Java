package ccc.s2007;

import java.util.Scanner;

public class S5 {
	static int n;
	static int k;
	static int w;
	static int[] v;
	static int[][] dp;
	static int W;
	static int[] sum;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int testcase = 0; testcase < t; testcase++) {
			n = s.nextInt();
			k = s.nextInt();
			w = s.nextInt();
			W = w;// + w + 1;

			v = new int[n];
			dp = new int[n + 1][k + 1];

			

			for (int i = 0; i < n; i++) {
				v[i] = s.nextInt();
				for (int j = 0; j <= k; j++)
					dp[i][j] = -1;
			}
			for (int j = 0; j <= k; j++)
				dp[n][j] = -1;
			
			sum = new int[n];
			for (int j = 0; j < n; j++) {
				int hax = Math.min(n, j + W);

				for (int l = j; l < hax; l++) {
					sum[j] += v[l];
				}
			}
			System.out.println(f(0, k));
		}
		s.close();
		// indent = "";
	}

	// static String indent;

	static int f(int i, int k) {
		if (k == 0)
			return 0;

		if (i >= n)
			return 0;

		if (dp[i][k] == -1) {
			// indent += " ";
			int max = 0;
			for (int j = i; j < n; j++) {
				// System.out.print(indent + "start " + i + ", test " + j + " to
				// " +
				// (j + W) + ": ");
				
				// System.out.println(" = " + sum);
				int d = f(j + W, k - 1);
				// System.out.println(indent + " result " + d);
				max = Math.max(max, d + sum[j]);
			}
			// indent = indent.substring(1);
			dp[i][k] = max;
			return max;
		}

		return dp[i][k];
	}

}
