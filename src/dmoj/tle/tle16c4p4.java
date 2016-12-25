package dmoj.tle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tle16c4p4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int q = s.nextInt();

		int[][] adj = new int[n][n];
		int[] degs = new int[n];
		int ltmp = -1;
		for (int i = 0; i < m; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			int l = s.nextInt();
			adj[u][v] = l;
			adj[v][u] = l;
			degs[u]++;
			degs[v]++;
			ltmp = l;
		}
		s.close();

		if (m == 1) {
			int mleft = (n - 1) - m;
			if (q == 1) {
				System.out.println(ltmp + mleft);
			} else {
				System.out.println(ltmp);
			}
			return;
		}

		if (m == n - 1) {
//			if (q == 2) {
				int[] max = new int[n];
				Queue<Integer> toRemove = new LinkedList<>();
				for (int i = 0; i < n; i++) {
					if (degs[i] == 1) {
						toRemove.add(i);
					}
				}
				int maxval = 0;
				while (!toRemove.isEmpty()) {
					int curr = toRemove.remove();
					for (int i = 0; i < n; i++) {
						if (adj[curr][i] != 0) {
							max[i] = Math.max(max[i], max[curr] + adj[curr][i]);
							maxval = Math.max(max[i], maxval);
							adj[curr][i] = 0;
							adj[i][curr] = 0;
							degs[i]--;
							degs[curr]--;
							if (degs[i] == 1)
								toRemove.add(i);
						}
					}
				}
				System.out.println(maxval);
//			} else {
//
//			}
			return;
		}

		System.out.println("friendshipismagic");
	}
	
	
}
