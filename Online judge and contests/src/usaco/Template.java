package usaco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Template {

	private static final boolean debug = true;

	private static final String name = "";

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

		s.close();
		out.close();
	}
}
