package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

//Given n lines, finds the minimum of all the lines for a certain x
//Preprocessing time=O(n)
//Query time=O(log n) - with binary search. May be reducible to O(1)
public class GraphMin {

	static double intersection(double m, double b, double n, double c) {
		// System.out.println(b);
		// System.out.println(c);
		return (c - b) / (m - n);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] b = new int[n + 1];
		for (int i = 0; i < n; i++) {
			b[n - i] = s.nextInt();
		}
		double lastInt = -Double.MAX_VALUE;
		int lastSlope = n;

		ArrayList<Double> ints = new ArrayList<>();
		ArrayList<Integer> slopes = new ArrayList<>();

		for (int slope = n - 1; slope >= 1; slope--) {
			double inter = intersection(slope + 1, b[slope + 1], slope, b[slope]);
			// System.out.println("intersection between " + slope + " and " +
			// (slope + 1) + " => " + inter);
			if (inter >= lastInt) {
				// System.out.println("intersection is further than prev, prev
				// is valid");
				ints.add(lastInt);
				slopes.add(lastSlope);
				lastInt = inter;
				lastSlope = slope;
			} else {
				// System.out.println("intersection is closer than prev, set
				// prev");
				lastInt = intersection(lastSlope, b[lastSlope], slope, b[slope]);
				lastSlope = slope;
			}
		}
		ints.add(lastInt);
		slopes.add(lastSlope);
		ints.add(Double.MAX_VALUE);
		slopes.add(0);

		// for (int i = 0; i < ints.size(); i++) {
		// System.out.println("Int => " + ints.get(i) + ", slope => " +
		// slopes.get(i));
		// }
		while (s.hasNext()) {
			int c = s.nextInt();
			for (int i = 1; i < ints.size(); i++) {
				if (ints.get(i - 1) <= c && ints.get(i) >= c) {
					int slope = slopes.get(i - 1);
					System.out.println(slope * c + b[slope]);
					break;
				}
			}
		}
		s.close();

	}

}
