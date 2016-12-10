package duwei.dikj;

public class Dijk1 {
	public static void main(String[] args) {
		int n = 100;
		int src = 0;
		int[][] adj = new int[n][n];
		int[] du = new int[n];
		for (int i = 0; i < n; i++)
			du[i] = Integer.MAX_VALUE;
		du[src] = 0;
		boolean[] visited = new boolean[n];

		while (true) {

			int minidx = -1;
			int minval = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					if (du[i] < minval) {
						minidx = i;
						minval = du[i];
					}
				}
			}

			if (minidx == -1)
				break;

			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					du[i] = Math.min(du[i], adj[minidx][i]);
				}
			}

			visited[minidx] = true;
		}
	}
}
