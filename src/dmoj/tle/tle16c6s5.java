package dmoj.tle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class tle16c6s5 {

	static class Pair {
		int m;
		long b;

		public Pair(int mi, long bi) {
			m = mi;
			b = bi;
		}

		@Override
		public String toString() {
			return "[m=" + m + ", b=" + b + "]";
		}
	}

	static int n, m;
	static ArrayList<HashMap<Integer, Long>> adj;

	static long[][] dp;
	static boolean[][] visited;
	static ArrayList<ArrayList<Pair>> best;

	static long f(int i, int j) {
		if (visited[i][j])
			return dp[i][j];

		long res = Long.MAX_VALUE;
		if (j == 0) {
			if (i == 0)
				res = 0;
		} else
			for (Entry<Integer, Long> neigh : adj.get(i).entrySet()) {
				long alt = f(neigh.getKey(), j - 1);
				if (alt != Long.MAX_VALUE)
					res = Math.min(res, alt + neigh.getValue());
			}

		dp[i][j] = res;
		visited[i][j] = true;

		if (res != Long.MAX_VALUE)
			best.get(i).add(new Pair(j, res));

		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		int q = s.nextInt();

		adj = new ArrayList<>(n);
		best = new ArrayList<>(n);

		dp = new long[n][m + 1];
		visited = new boolean[n][m + 1];
		for (int i = 0; i < n; i++) {
			adj.add(new HashMap<>());
			best.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			long t = s.nextLong();

			u--;
			v--;

			long oldval = Long.MAX_VALUE;
			if (adj.get(v).containsKey(u))
				oldval = adj.get(v).get(u);

			adj.get(v).put(u, Math.min(oldval, t));
		}

		ArrayList<ArrayList<Double>> ints = new ArrayList<>(n);
		ArrayList<ArrayList<Pair>> points = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= m; j++)
				f(i, j);

			ArrayList<Pair> b = best.get(i);
			b.sort(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return Integer.compare(o1.m, o2.m);
				}
			});

			ArrayList<Double> cInts = new ArrayList<>();
			ArrayList<Pair> cPoints = new ArrayList<>();

			if (b.size() == 0) {
				ints.add(cInts);
				points.add(cPoints);
				continue;
			}

			double lastInt = -Double.MAX_VALUE;
			Pair lastCrossed = null;

			for (int idx = b.size() - 2; idx >= 0; idx--) {
				double inter = intersection(b.get(idx + 1).m, b.get(idx + 1).b, b.get(idx).m, b.get(idx).b);
				if (inter >= lastInt) {
					cInts.add(lastInt);
					cPoints.add(b.get(idx + 1));
					lastInt = inter;
					lastCrossed = b.get(idx + 1);
				} else {
					lastInt = intersection(lastCrossed.m, lastCrossed.b, b.get(idx).m, b.get(idx).b);
				}
			}
			cInts.add(lastInt);
			cPoints.add(b.get(0));

			ints.add(cInts);
			points.add(cPoints);
		}

		long c = 0;
		for (int i = 0; i < q; i++) {
			c += s.nextLong();
			int d = s.nextInt();
			d--;
			int idx = upperBound(ints.get(d), c);
			if (idx == -1) {
				System.out.println("Cannot Deliver");
				continue;
			}
			Pair pt = points.get(d).get(idx);
			long output = pt.m * c + pt.b;
			System.out.println(output);
		}
		s.close();

	}

	static double intersection(double m, double b, double n, double c) {
		return (c - b) / (m - n);
	}

	static int upperBound(ArrayList<Double> s, long t) {
		if (s.size() == 0)
			return -1;
		int lo = 0;
		int hi = s.size() - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			if (s.get(mid) <= t)
				lo = mid;
			else
				hi = mid - 1;
		}

		if (s.get(lo) > t)
			return -1;

		return lo;
	}
}
