package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Given n lines, finds the minimum of all the lines for a certain x
//Preprocessing time=O(n)
//Query time=O(log n) - with binary search. May be reducible to O(1)
public class GraphMin {

	static class Pair implements Comparable<Pair> {
		int m, b;

		public Pair(int mi, int bi) {
			m = mi;
			b = bi;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(m, o.m);
		}

		@Override
		public String toString() {
			return "[m=" + m + ", b=" + b+"]";
		}
	}

	static double intersection(double m, double b, double n, double c) {
		return (c - b) / (m - n);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Pair[] b = new Pair[n];
		for (int i = 0; i < n; i++) {
			b[i] = new Pair(s.nextInt(), s.nextInt());
		}
		Arrays.sort(b);
		double lastInt = -Double.MAX_VALUE;
		Pair lastPoint = b[n - 1];

		ArrayList<Double> ints = new ArrayList<>();
		ArrayList<Pair> points = new ArrayList<>();

		for (int idx = n - 2; idx >= 0; idx--) {
			double inter = intersection(b[idx + 1].m, b[idx + 1].b, b[idx].m, b[idx].b);
			if (inter >= lastInt) {
				ints.add(lastInt);
				points.add(lastPoint);
				lastInt = inter;
				lastPoint = b[idx];
			} else {
				lastInt = intersection(lastPoint.m, lastPoint.b, b[idx].m, b[idx].b);
				lastPoint = b[idx];
			}
		}
		ints.add(lastInt);
		points.add(lastPoint);
		ints.add(Double.MAX_VALUE);

		while (s.hasNext()) {
			int c = s.nextInt();
			for (int i = 1; i < ints.size(); i++) {
				if (ints.get(i - 1) <= c && ints.get(i) >= c) {
					Pair pt = points.get(i - 1);
					System.out.println(pt.m * c + pt.b);
					break;
				}
			}
		}
		s.close();

	}

}
