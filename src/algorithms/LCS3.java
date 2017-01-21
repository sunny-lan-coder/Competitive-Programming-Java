package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS3 {

	static String s1;
	static String s2;

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();

		br.close();
		n = s1.length();
		m = s2.length();

		dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(LCS(n, m));

	}

	static int[][] dp;

	static int LCS(int l1, int l2) {
		if (dp[l1][l2] == -1) {
			int res;
			if (l1 == 0 || l2 == 0) {
				res = 0;
			} else {
				char c1 = s1.charAt(l1 - 1);
				char c2 = s2.charAt(l2 - 1);
				if (c1 == c2) {
					res = LCS(l1 - 1, l2 - 1) + 1;
				} else {
					res = Math.max(LCS(l1 - 1, l2), LCS(l1, l2 - 1));
				}
			}
			dp[l1][l2] = res;
			return res;
		} else

		{
			return dp[l1][l2];
		}

	}

}
