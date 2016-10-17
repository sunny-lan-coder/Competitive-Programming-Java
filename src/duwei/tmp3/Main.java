package duwei.tmp3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt() - 1;
		int t = s.nextInt();
		int m = s.nextInt();
		long[][] adj = new long[n][n];
		long[] du = new long[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			du[i] = -1;
			for (int j = 0; j < n; j++) {
				adj[i][j] = -1;
			}
		}

		du[e] = 0;
		for (int i = 0; i < m; i++) {
			int a = s.nextInt() - 1;
			int b = s.nextInt() - 1;
			adj[a][b] = s.nextInt();
		}

		while (true) {
			int minidx = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && du[i] != -1) {
					if (minidx == -1) {
						minidx = i;
						continue;
					}
					if (du[i] < du[minidx]) {
						minidx = i;
					}
				}
			}
//			System.out.println("currnode = " + minidx);

			if (minidx == -1)
				break;

			for (int i = 0; i < n; i++) {
				if (adj[minidx][i] != -1 && !visited[i]) {
//					System.out.println(" connection (" + minidx + ", " + i + "), d = " + adj[minidx][i]);
					if (du[i] == -1) {
//						System.out.println("  du[i] = infinity => " + du[minidx] + " + " + adj[minidx][i]+" = "+(du[minidx]+adj[minidx][i]));
						du[i] = du[minidx] + adj[minidx][i];
						continue;
					}
					if (du[minidx] + adj[minidx][i] < du[i]) {
//						System.out.println("  du[i] = "+du[i]+" => " + du[minidx] + " + " + adj[minidx][i]+" = "+(du[minidx]+adj[minidx][i]));
						du[i] = du[minidx] + adj[minidx][i];
					}
				}
			}

			visited[minidx] = true;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
//			System.out.println(du[i]);
			if (du[i] <= t && du[i]!=-1) {
//				System.out.println("y");
				count++;
			}
		}

		System.out.println(count);
		s.close();
	}

}
