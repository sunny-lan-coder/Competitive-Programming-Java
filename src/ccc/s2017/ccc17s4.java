package ccc.s2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class ccc17s4 {
	static class T3 {
		public final int a;
		public final long b;

		public T3(int a, long b) {
			this.a = a;
			this.b = b;
		}
	}

	static BufferedReader br;
	static String[] tmp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		splitRead();
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int d = Integer.parseInt(tmp[2]);
		ArrayList<ArrayList<T3>> adj = new ArrayList<>();
		ArrayList<HashSet<Integer>> inold = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
			inold.add(new HashSet<>());
		}
		for (int i = 0; i < m; i++) {
			splitRead();
			int a = Integer.parseInt(tmp[0]) - 1;
			int b = Integer.parseInt(tmp[1]) - 1;
			long c = Long.parseLong(tmp[2]);

			adj.get(a).add(new T3(b, c));
			adj.get(b).add(new T3(a, c));
			if (i <= n - 1) {
				inold.get(a).add(b);
				inold.get(b).add(a);
			}
		}
		br.close();

		boolean[] visited = new boolean[n];
		long[] du = new long[n];
		int[] from = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = Long.MAX_VALUE;
			from[i] = -1;
		}
		du[0] = 0;

		for (int count = 0; count < n - 1; count++) {
			long minval = Long.MAX_VALUE;
			int minidx = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && (du[i] < minval)) {
					minval = du[i];
					minidx = i;
				}
			}
			if (minidx == -1)
				break;

			visited[minidx] = true;

			for (T3 t : adj.get(minidx)) {
				int i = t.a;
				long val = t.b;
				if (visited[i])
					continue;
				if (val == du[i]) {
					if (inold.get(i).contains(minidx)) {
						du[i] = val;
						from[i] = minidx;
					}
					continue;
				}
				if (val < du[i]) {
					du[i] = val;
					from[i] = minidx;
				}
			}
		}

		long cnt = 0;
		for (int i = 1; i < n; i++) {
			if (!inold.get(i).contains(from[i])) {
				cnt++;
			}

		}
		System.out.println(cnt);

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