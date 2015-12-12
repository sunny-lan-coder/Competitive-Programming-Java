package usaco.bronze2014.december;

import static java.lang.Math.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Marathon {

	private static final boolean debug = false;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		PrintStream out;
		if (debug) {
			s = new Scanner(System.in);
			out = System.out;
		} else {
			s = new Scanner(new FileInputStream("marathon.in"));
			out = new PrintStream("marathon.out");
		}
		int N = s.nextInt();

		int[] x = new int[N];
		int[] y = new int[N];

		for (int line = 0; line < N; line++) {
			x[line] = s.nextInt();
			y[line] = s.nextInt();
		}

		int maxDistSaved = Integer.MIN_VALUE;
		int totDist = 0;
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		int x3 = 0;
		int y3 = 0;
		for (int i = 0; i < N - 2; i++) {
			x1 = x[i];
			y1 = y[i];
			x2 = x[i + 1];
			y2 = y[i + 1];
			x3 = x[i + 2];
			y3 = y[i + 2];

			totDist += d(x1, y1, x2, y2);

			int before = d(x1, y1, x2, y2) + d(x2, y2, x3, y3);
			// out.println("before omit "+(i+1)+": "+before);
			int after = d(x1, y1, x3, y3);
			// out.println("after omit "+(i+1)+": "+after);
			int saved = before - after;
			// out.println("saving "+(i+1)+": "+saved);

			maxDistSaved = max(maxDistSaved, saved);
			// out.println("best: "+maxDistSaved);
		}
		totDist += d(x2, y2, x3, y3);

		if (maxDistSaved < 1)
			out.println(totDist);
		else
			out.println(totDist - maxDistSaved);

		s.close();
		out.close();
	}

	static int d(int x1, int y1, int x2, int y2) {
		return abs(x1 - x2) + abs(y1 - y2);
	}

}
