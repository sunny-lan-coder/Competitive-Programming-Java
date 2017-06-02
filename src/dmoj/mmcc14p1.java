package dmoj;

import java.util.Scanner;

public class mmcc14p1 {
	static int n, s;
	static int[] m;

	static int lim;

	static int[][] dp;

	static int f(int i, int j) {
		int res = dp[i][j];
		if (res != -1)
			return res;

		res = 0;

		for (int k = 0; k < lim; k++) {
			int m1 = k & i;
			int m2 = ~k & i;
			
		}

		dp[i][j] = res;
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		s = in.nextInt();
		m = new int[n];
		lim = 1 << n;
		dp = new int[lim][s];
		for (int i = 0; i < n; i++) {
			m[i] = in.nextInt();
		}
		in.close();

	}

}
