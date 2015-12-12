package usaco.bronze2014.december;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class LearningByExample {

	private static final boolean debug = true;

	private static final String name = "learning";

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
		int A = s.nextInt();
		int B = s.nextInt();

		if (A == B)
//derp this is messed
			for (int i = 0; i < N; i++) {

			}

		s.close();
		out.close();
	}
}
