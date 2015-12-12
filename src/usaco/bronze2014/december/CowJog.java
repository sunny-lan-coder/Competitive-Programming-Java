package usaco.bronze2014.december;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CowJog {

	private static final boolean debug = true;

	private static final String name = "cowjog";

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
			s = new Scanner(new FileInputStream(name + ".in"));
			out = new PrintStream(name + ".out");
		}

		int N = s.nextInt();
		int[] speed = new int[N];
		int[] location = new int[N];

		for (int line = 0; line < N; line++) {
			location[line] = s.nextInt();
			speed[line] = s.nextInt();
		}

		int groups = 1;

		int lastSpeed = speed[N - 1];

		for (int i = N - 2; i >= 0; i--) {
			if (speed[i] <= lastSpeed) {
				groups++;
				lastSpeed = speed[i];
			}
		}

		out.println(groups);

		s.close();
		out.close();
	}
}
