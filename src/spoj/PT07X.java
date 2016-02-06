package spoj;

import java.util.Scanner;

public class PT07X {
	static int N;
	static boolean[][] adjmat;

	static int[][] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		adjmat = new boolean[N + 3][N + 3];
		dp = new int[N + 3][2];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < N - 1; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			adjmat[u][v] = true;
			adjmat[v][u] = true;
		}
		s.close();

		System.out.println(f(1, 0));
	}

	static int f(int node, int select) {
		if (dp[node][select] == -1) {
			int result = 0;
			if (select == 0) {
				int a = 1;
				int b = 0;
				for (int i = 0; i <= N; i++) {
					if (adjmat[node][i]) {
						adjmat[i][node] = false;
						a += f(i, 0);
						b += f(i, 1);
					}
				}
				result = Math.min(a, b);
			} else {
				result = 1;
				for (int i = 0; i <= N; i++) {
					if (adjmat[node][i]) {
						adjmat[i][node] = false;
						result += f(i, 0);
					}
				}
			}

			dp[node][select] = result;
			return result;
		} else {
			return dp[node][select];
		}
	}
}