package ccc.s2004;

import java.util.Scanner;

public class ccc00s4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		int n = s.nextInt();
		int[] c = new int[n];

		for (int i = 0; i < n; i++) {
			c[i] = s.nextInt();
		}
		s.close();
		int[] dp = new int[d + 1];
		for (int i = 1; i <= d; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < d; i++) {
			if (dp[i] != Integer.MAX_VALUE)
				for (int j = 0; j < n; j++) {
					if (i + c[j] <= d) {
						dp[i + c[j]] = Math.min(dp[i + c[j]], dp[i] + 1);
					}
				}
		}
		if (dp[d] == Integer.MAX_VALUE)
			System.out.println("Roberta acknowledges defeat.");
		else
			System.out.println("Roberta wins in " + dp[d] + " strokes.");

	}

}
