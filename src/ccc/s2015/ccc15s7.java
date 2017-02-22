package ccc.s2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ccc15s7 {
	static class T2 {
		public final int a;
public final long b;

		public T2(int a, long b) {
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

		long[][] dp = new long[n][201];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 200; j++) {
				dp[i][j] = -1;
			}
		}
		dp[a][k] = 0;

		PriorityQueue<T2> q = new PriorityQueue<>(new Comparator<T2>() {

			@Override
			public int compare(T2 o1, T2 o2) {
				return Long.compare(o1.b, o2.b);
			}
		});

		q.add(new T2(a, 0));


		while (!q.isEmpty()) {
			int idx = q.remove().a;
			// System.out.println("curr node " + (idx ));
			for (T3 edge : adj.get(idx)) {

				// System.out.println(" consider edge to "+edge.a+",
				// len="+edge.b+", hull_wear="+edge.c);

				
				for (int j = k; j >= 0; j--) {
					if (dp[idx][j] != -1) {
						int hull = j - edge.c;
						// System.out.println(" start hull "+j+" ->" +hull);
						if (hull > 0) {
							long u = edge.b + dp[idx][j];
							// System.out.println(" new len "+u+", old len "+
							// dp[edge.a][hull]);
							if (u < dp[edge.a][hull] || dp[edge.a][hull] == -1) {
								dp[edge.a][hull] = u;
//								if (!next[edge.a]) {
									// System.out.println(" added to queue");
									q.add(new T2(edge.a, u));
//								} else {
									// System.out.println(" alreaady in queue");
//								}
							}
						} else
							break;
					}
				}
			}
		}

		long min = -1;
		for (int i = 0; i <= k; i++) {
			if (dp[b][i] != -1)
				if (min == -1) {
					min = dp[b][i];
				} else {
					min = Math.min(min, dp[b][i]);
				}
		}
		System.out.println(min);

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