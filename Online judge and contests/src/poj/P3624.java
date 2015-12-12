package poj;

import static java.lang.Math.max;

import java.util.Scanner;

public class P3624 {

	static int[] W;
	static int[] D;
	static int N;
	static int M;

	static int[][] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		W = new int[N + 1];
		D = new int[N + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			W[i] = s.nextInt();
			D[i] = s.nextByte();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (W[i] <= j) {
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - W[i]] + D[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][M]);
		s.close();
	}
}
