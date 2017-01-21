package duwei.cycle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] adj = new int[n][n];
		int[] du = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = -1;
			for (int j = 0; j < n; j++) {
				adj[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			int m = s.nextInt();
			for (int j = 0; j < m; j++) {
				int dst = s.nextInt();
				int len = s.nextInt();
				adj[i][dst] = len;
			}
		}

		int d = s.nextInt();
		du[d] = 0;

		boolean[] visited = new boolean[n];

		while (true) {
			int i = -1;
			int min = -1;
			for (int k = 0; k < n; k++) {
				if (!visited[k]) {
					if (i == -1 || du[k] < min) {
						min = du[k];
						i = k;
					}
				}
			}

			if (i == -1)
				break;

			for (int j = 0; j < n; j++) {
				if (!visited[j]) {
					int newval = du[i] + adj[i][j];
					if (newval < du[j]) {
						du[j] = newval;
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(i==d)
				continue;
			
		}

		s.close();
	}

}
