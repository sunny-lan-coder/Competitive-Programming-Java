package codejam.y2017.r2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Ratatouille {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		 s= new Scanner(new File("B-small-attempt0.in"));
//		s = new Scanner(System.in);
		PrintStream out;
		 out = new PrintStream("B_small_output.txt");
//		out = System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int p = s.nextInt();
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				r[i] = s.nextInt();
			}
			int[][] q = new int[n][p];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < p; j++) {
					q[i][j] = s.nextInt();
				}
			}
			if (n == 1) {
				int cnt = 0;
				for (int i = 0; i < p; i++) {
					double rounded = Math.round(1.0 * q[0][i] / r[0]) * r[0];
					double high = rounded * 1.1;
					double low = rounded * 0.9;
					// System.out.println("high=" + high + ", low=" + low + ",
					// mid" + rounded);
					if (q[0][i] >= low && q[0][i] <= high) {
						cnt++;
					}
				}
				out.println("Case #" + test + ": " + cnt);
			} else if (n == 2) {
				HashSet<Integer> avail1 = new HashSet<>();

				for (int i = 0; i < p; i++) {
					for (int rounded = r[0]; rounded < 2000000; rounded += r[0]) {
						double high = rounded * 1.1;
						double low = rounded * 0.9;
						// System.out.println("high=" + high + ", low=" + low +
						// ",
						// mid" + rounded);
						if (q[0][i] >= low && q[0][i] <= high) {
							avail1.add((int) (rounded / r[0]));
						}

					}
				}
				int cnt = 0;
				outer: for (int i = 0; i < p; i++) {
					for (int rounded = r[1]; rounded < 2000000; rounded += r[1]) {
						double high = rounded * 1.1;
						double low = rounded * 0.9;
						// System.out.println("high=" + high + ", low=" + low +
						// ",
						// mid" + rounded);
						if (q[1][i] >= low && q[1][i] <= high) {
							if (avail1.contains((int) (rounded / r[1]))) {
								cnt++;
								continue outer;
							}
						}

					}
				}

				out.println("Case #" + test + ": " + cnt);
			}else{
				System.err.println("fuck");
				out.println("Fuck");
			}
		}
		s.close();
		out.close();
	}

}
