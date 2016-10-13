package duwei.tmp8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int k =Integer.parseInt(s.readLine());
		String[] line;
		for (int t = 0; t < k; t++) {
			line=s.readLine().split(" ");
			String n = line[0];
			int m = Integer.parseInt(line[1]);
			int l = n.length();

			BigInteger[][] dp = new BigInteger[l + 1][m + 1];
			for (int i = 0; i <= l; i++)
				for (int j = 0; j <= m; j++) {
					dp[i][j] = BigInteger.ZERO;
				}

			dp[0][0] = BigInteger.ONE;

			for (int j = 0; j < m; j++)
				for (int i = 0; i < l; i++)
					for (int p = i + 1; p <= l; p++) {
						dp[p][j + 1] = dp[p][j + 1].max(dp[i][j].multiply(new BigInteger(n.substring(i, p))));
					}

			System.out.println(dp[l][m]);
		}
		s.close();
	}
}
