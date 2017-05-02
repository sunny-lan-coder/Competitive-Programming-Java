package dmoj.tle;

import java.util.ArrayList;
import java.util.Comparator;
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
			return "[" + m + "," + b + "]";
		}
	}

	static int n, m;
	static ArrayList<ArrayList<Pair>> adj;

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
			for (Pair neigh : adj.get(i)) {
				long alt = f(neigh.m, j - 1);
				if (alt != Long.MAX_VALUE)
					res = Math.min(res, alt + neigh.b);
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
			adj.add(new ArrayList<>());
			best.add(new ArrayList<>(m + 1));
		}

		for (int i = 0; i < m; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			long t = s.nextLong();
			adj.get(v).add(new Pair(u, t));
		}
		
		ArrayList<ArrayList<Double>> ints=new ArrayList<>(n);
		ArrayList<ArrayList<Pair>> points=new ArrayList<>(n);

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

			double lastInt = -Double.MAX_VALUE;
			Pair lastPoint = b.get(n - 1);

			ArrayList<Double> cInts = new ArrayList<>();
			ArrayList<Pair> cPoints = new ArrayList<>();

			for (int idx = n - 2; idx >= 0; idx--) {
				double inter = intersection(b.get(idx + 1).m, b.get(idx + 1).b, b.get(idx).m, b.get(idx).b);
				if (inter >= lastInt) {
					cInts.add(lastInt);
					cPoints.add(lastPoint);
					lastInt = inter;
					lastPoint = b.get(idx);
				} else {
					lastInt = intersection(lastPoint.m, lastPoint.b, b.get(idx).m, b.get(idx).b);
					lastPoint = b.get(idx);
				}
			}
			
			ints.add(cInts);
			points.add(cPoints);
		}

		for (int i = 0; i < q; i++) {
			int c = s.nextInt();
			int d = s.nextInt() - 1;
			
		}
		s.close();
	}

	static double intersection(double m, double b, double n, double c) {
		return (c - b) / (m - n);
	}
	
//	static int binarySearch(int lo, int hi){
//		
//	}
}
