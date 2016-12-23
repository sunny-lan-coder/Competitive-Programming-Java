package ccc.s2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc09s4 {

	static class Tuple {
		public final int t1;
		public final int t2;

		public Tuple(int t1, int t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] adj = new int[n][n];
		int[] p = new int[n];
		int[] du = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = -1;
			}
			p[i] = -1;
			du[i] = -1;
		}
		int t = Integer.parseInt(br.readLine());
		String[] tmp;
		for (int i = 0; i < t; i++) {
			tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]) - 1;
			int y = Integer.parseInt(tmp[1]) - 1;
			int c = Integer.parseInt(tmp[2]);
			adj[x][y] = c;
			adj[y][x] = c;
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			tmp = br.readLine().split(" ");
			int z = Integer.parseInt(tmp[0]) - 1;
			int pz = Integer.parseInt(tmp[1]);
			p[z] = pz;
		}
		int d = Integer.parseInt(br.readLine()) - 1;
		br.close();

		du[d] = 0;
		boolean[] visited = new boolean[n];
		while (true) {
			int minnode = -1;
			int mindist = -1;

			for (int i = 0; i < n; i++) {
				if (!visited[i] && l(du[i], mindist)) {
					minnode = i;
					mindist = du[i];
				}
			}

			if (mindist == -1)
				break;

			visited[minnode] = true;
			for (int i = 0; i < n; i++) {
				if (adj[minnode][i] != -1) {
					int newdist = adj[minnode][i] + mindist;
					if (!visited[i] && l(newdist, du[i])) {
						du[i] = newdist;
					}
				}
			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			// System.out.println(du[i]+" "+p[i]);
			if (p[i] == -1 || du[i] == -1)
				continue;
			min = Math.min(min, du[i] + p[i]);
		}
		System.out.println(min);
	}

	static boolean g(int a, int b) {
		if (b == -1)
			return false;
		if (a == -1)
			return true;
		return a > b;
	}

	static boolean l(int a, int b) {
		return (!e(a, b)) && (!g(a, b));
	}

	static boolean e(int a, int b) {
		return a == b;
	}

}
