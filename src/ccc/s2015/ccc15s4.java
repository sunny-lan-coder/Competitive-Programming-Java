package ccc.s2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc15s4 {
	static class T2 {
		public final int a, b;

		public T2(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static class T3 {
		public final int a, b, c;

		public T3(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static BufferedReader br;
	static String[] tmp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		splitRead();
		int k = Integer.parseInt(tmp[0]);
		int n = Integer.parseInt(tmp[1]);
		int m = Integer.parseInt(tmp[2]);

		ArrayList<ArrayList<T3>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			splitRead();
			int a = Integer.parseInt(tmp[0]) - 1;
			int b = Integer.parseInt(tmp[1]) - 1;
			int t = Integer.parseInt(tmp[2]);
			int h = Integer.parseInt(tmp[3]);
			adj.get(a).add(new T3(b, t, h));
			adj.get(b).add(new T3(a, t, h));
		}
		splitRead();
		int a = Integer.parseInt(tmp[0]) - 1;
		int b = Integer.parseInt(tmp[1]) - 1;
		br.close();

		int[][] dp = new int[n][k+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = -1;
			}
		}
		dp[a][0] = 0;

		boolean[] visited = new boolean[n];

		int[] du = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = -1;
		}
		du[a] = 0;

		while (true) {
			int idx = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && du[i] != -1 && (idx == -1 || du[i] < du[idx])) {
					idx = i;
				}
			}
			if (idx == -1)
				break;
			for (T3 edge : adj.get(idx)) {
				int i = edge.a;
				if (visited[i]) {
					continue;
				}
				for (int j = 0; j+edge.c <k; j++) {
					if (dp[idx][j] != -1) {
						int hull = j + edge.c;
						
							int u = edge.b + dp[idx][j];

							if (u < dp[i][hull] || dp[i][hull] == -1) {
								dp[i][hull] = u;

								du[i] = Math.min(du[i], u);
								if (du[i] == -1)
									du[i] = u;

							}
						
					}
				}
			}
			visited[idx] = true;
		}

		System.out.println(du[b]);

	}

	static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static long readLong() throws IOException {
		return Long.parseLong(br.readLine());
	}

	static void splitRead() throws IOException {
		tmp = br.readLine().split(" ");
	}
}
