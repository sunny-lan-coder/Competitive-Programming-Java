package hackerank;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] M = new int[m];
		for (int i = 0; i < m; i++) {
			M[i] = s.nextInt();
		}
		s.close();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i <= n; i++) {

				int idx = i + M[j];
				if (idx > n)
					continue;
				dp[idx] += dp[i];
//				System.out.println("dp[" + idx + "]+=dp[" + i + "], " + dp[idx] + "+=" + dp[i]);
			}
		}

		System.out.println(dp[n]);
	}

}
