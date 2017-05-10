package dmoj.dmopc;

import java.util.ArrayList;
import java.util.Scanner;

public class dmopc14c4p6_2 {

	static ArrayList<ArrayList<Integer>> adj;

	static ArrayList<ArrayList<Integer>> c;
	static int[] p;

	static int[] df;
	static int[] dg;

	static int f(int i) {
		int res = df[i];
		if (res != -1)
			return res;

		res = 0;

		for (int neigh : c.get(i))
			res = Math.max(res, f(neigh));

		df[i] = ++res;
		return res;
	}

	static int g(int i) {
		int res = dg[i];
		if (res != -1)
			return res;

		res = 0;

		if (i == 0) {
			res = f(i);
		} else {
			if (p[i] == 0) {
				for (int neigh : c.get(0))
					if (neigh != i)
						res = Math.max(res, f(neigh));
				res += 2;
			} else {
				res = g(p[i]) + 1;

				for (int neigh : c.get(p[i]))
					if (neigh != i)
						res = Math.max(res, f(neigh) + 2);
			}
		}
		dg[i] = res;
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		c = new ArrayList<>(n);
		adj = new ArrayList<>(n);
		df = new int[n];
		dg = new int[n];
		p = new int[n];

		for (int i = 0; i < n; i++) {
			c.add(new ArrayList<>());
			adj.add(new ArrayList<>());
			df[i] = dg[i] = -1;
		}

		for (int i = 0; i < n - 1; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		s.close();

		dfs(0, -1);

		for (int i = 0; i < n; i++)
			System.out.println(Math.max(f(i), g(i)));
	}

	static void dfs(int i, int j) {
		p[i] = j;
		for (int neigh : adj.get(i)) {
			if (neigh != j) {
				c.get(i).add(neigh);
				dfs(neigh, i);
			}
		}
	}
}
