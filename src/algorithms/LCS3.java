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

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][m]);

	}

	static int[][] dp;

}
