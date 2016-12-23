package ccc.s2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		ArrayList<ArrayList<Tuple>> adj = new ArrayList<>(n);
		int[] p = new int[n];
		int[] du = new int[n];
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
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
			adj.get(x).add(new Tuple(y, c));
			adj.get(y).add(new Tuple(x, c));
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

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a1, Integer b1) {
				int a = du[a1];
				int b = du[b1];
				if (e(a, b))
					return 0;
				if (g(a, b))
					return 1;
				return -1;
			}
		});
		q.add(d);
		du[d] = 0;
		boolean[] visited = new boolean[n];
		while (!q.isEmpty()) {
			int minnode = q.remove();
			int mindist = du[minnode];

			if (!visited[minnode]) {
				visited[minnode] = true;
				for (Tuple adjacent : adj.get(minnode)) {
					int newdist = adjacent.t2 + mindist;
					if (!visited[adjacent.t1] && l( newdist , du[adjacent.t1])) {
						du[adjacent.t1] = newdist;
						q.add(adjacent.t1);
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
//			System.out.println(du[i]+"  "+p[i]);
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
