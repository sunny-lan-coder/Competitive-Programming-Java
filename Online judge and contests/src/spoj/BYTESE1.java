package spoj;

import java.util.Scanner;

public class BYTESE1 {

	static final int infinity = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		for (int testCase = 0; testCase < K; testCase++) {
			int M = s.nextInt();
			int N = s.nextInt();
			int[][] guards = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					guards[i][j] = s.nextInt();
				}
			}
			int a = s.nextInt() - 1;
			int b = s.nextInt() - 1;
			int T = s.nextInt();

			int[][] du = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					du[i][j] = infinity;
				}
			}
			du[0][0] = guards[0][0];

			boolean[][] visited = new boolean[M][N];

			while (true) {
				int minNodeValue = infinity;
				int minNodeI = 0;
				int minNodeJ = 0;
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j]) {
							if (sl(du[i][j], minNodeValue)) {
								minNodeI = i;
								minNodeJ = j;
								minNodeValue = du[i][j];
							}
						}
					}
				}

				if (minNodeValue == infinity)
					continue;

				visited[minNodeI][minNodeJ] = true;
				if (visited[a][b])
					break;

				int i, j;
				i = minNodeI + 1;
				j = minNodeJ;
				if (!(i < 0 || j < 0 || i >= M || j >= N))
					if (!visited[i][j]) {
						int newVal = minNodeValue + guards[i][j];
						// System.out.print(" select subnode " + i + "," + j +
						// ", du=" + du[i][j]);
						if (sl(newVal, du[i][j])) {
							du[i][j] = newVal;
							// System.out.print(", update value to " +
							// du[i][j]);
						}
						// System.out.println();
					}
				i = minNodeI - 1;
				j = minNodeJ;
				if (!(i < 0 || j < 0 || i >= M || j >= N))
					if (!visited[i][j]) {
						int newVal = minNodeValue + guards[i][j];
						// System.out.print(" select subnode " + i + "," + j +
						// ", du=" + du[i][j]);
						if (sl(newVal, du[i][j])) {
							du[i][j] = newVal;
							// System.out.print(", update value to " +
							// du[i][j]);
						}
						// System.out.println();
					}
				i = minNodeI;
				j = minNodeJ + 1;
				if (!(i < 0 || j < 0 || i >= M || j >= N))
					if (!visited[i][j]) {
						int newVal = minNodeValue + guards[i][j];
						// System.out.print(" select subnode " + i + "," + j +
						// ", du=" + du[i][j]);
						if (sl(newVal, du[i][j])) {
							du[i][j] = newVal;
							// System.out.print(", update value to " +
							// du[i][j]);
						}
						// System.out.println();
					}
				i = minNodeI;
				j = minNodeJ - 1;
				if (!(i < 0 || j < 0 || i >= M || j >= N))
					if (!visited[i][j]) {
						int newVal = minNodeValue + guards[i][j];
						// System.out.print(" select subnode " + i + "," + j +
						// ", du=" + du[i][j]);
						if (sl(newVal, du[i][j])) {
							du[i][j] = newVal;
							// System.out.print(", update value to " +
							// du[i][j]);
						}
						// System.out.println();
					}
			}
			// System.out.println(du[a][b]);
			if (du[a][b] == infinity) {
				System.out.println("NO");
			} else {
				if (T - du[a][b] < 0) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
					System.out.println(T - du[a][b]);
				}
			}
		}
		s.close();
	}

	static boolean sl(int a, int b) {
		if (a == infinity && b != infinity)
			return false;
		if (a != infinity && b == infinity)
			return true;
		if (a == infinity && b == infinity)
			return false;
		return a < b;
	}

}
