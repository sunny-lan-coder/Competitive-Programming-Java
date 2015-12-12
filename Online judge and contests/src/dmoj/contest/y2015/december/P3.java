package dmoj.contest.y2015.december;

import java.util.Scanner;

public class P3 {

	static int N;
	static int[][] A;
	static int[] d;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		N = s.nextInt();
		int M = s.nextInt();

		A = new int[N][N];

		for (int k = 0; k < M; k++) {
			int i = s.nextInt() - 1;
			int j = s.nextInt() - 1;
			A[i][j] = 1;
			A[j][i] = 1;
		}

		for (int i = 0; i < N; i++) {

			visited = new boolean[N];

			if (dfs(1, i, i)) {
				System.out.println("YES");
				s.close();
				return;
			}
		}
		System.out.println("NO");

		s.close();
	}

	static boolean[] visited;

	static String indent = " ";

	static boolean dfs(int loopCount, int node, int startNode) {
		visited[node] = true;
		for (int i = 0; i < N; i++) {
			if (A[node][i] == 1) {
				if (loopCount == 6 && i == startNode)
					return true;
				if (!visited[i])
					if (dfs(loopCount + 1, i, startNode))
						return true;
			}
		}
		visited[node] = false;
		return false;
	}

}
