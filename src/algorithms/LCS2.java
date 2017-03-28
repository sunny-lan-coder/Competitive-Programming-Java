package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {

	static String s1;
	static String s2;
	static String s3;

	static int n;
	static int m;
	static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		s3 = br.readLine();

		br.close();
		n = s1.length();
		m = s2.length();
		l = s3.length();

		dp = new int[n + 1][m + 1][l + 1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= l; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		System.out.println(f(n, m, l));

	}

	static int[][][] dp;

	static int f(int i, int j, int k) {
		if (dp[i][j][k] == -1) {
			int res;
			if (i == 0 || j == 0 || k==0) {
				res = 0;
			} else {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(k - 1);
				if (c1 == c2 && c2 == c3) {
					res = f(i - 1, j - 1, k - 1) + 1;
				} else {
					res = Math.max(f(i - 1, j, k), Math.max(f(i, j - 1, k), f(i, j, k - 1)));
				}
			}
			dp[i][j][k] = res;
			return res;
		} else

		{
			return dp[i][j][k];
		}

	}

}
