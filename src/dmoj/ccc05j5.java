package dmoj;

import java.util.Scanner;

import java.util.regex.*;

public class ccc05j5 {

	static String line;
	static int N;
	static Pattern possibleMonkey = Pattern.compile("^(.+?)(?:N(.+?))$");
	static Pattern possibleA1 = Pattern.compile("^A$");
	static Pattern possibleA2 = Pattern.compile("^B(.+?)S$");

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			line = s.nextLine();
			N = line.length();
			if (isMonkeyWord(0, N))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		s.close();
	}

	static String indent = "";

	static boolean isMonkeyWord(int i, int j) {

		System.out.println(indent + "ism(" + line.substring(i, j) + "):");
		indent += " ";
		if (isAWord(i, j)) {

			indent = indent.substring(1);
			return true;
		}
		Matcher m = possibleMonkey.matcher(line.substring(i, j));

		System.out.println(indent+"check 2:");
		if (m.matches()) {

			System.out
					.println(indent + line.substring(i, j) + " matches " + "(" + m.group(1) + ")N(" + m.group(2) + ")");

			if (isAWord(m.start(1), m.end(1)) && isMonkeyWord(m.start(2), m.end(2))) {

				indent = indent.substring(1);
				return true;
			}

		}

		indent = indent.substring(1);
		return false;
	}

	static boolean isAWord(int i, int j) {
		System.out.println(indent + "isa(" + line.substring(i, j) + "):");

		indent += " ";
		Matcher m = possibleA1.matcher(line.substring(i, j));
		if (m.matches()) {
			System.out.println(indent + "matches a");
			indent = indent.substring(1);
			return true;
		}
		m = possibleA2.matcher(line.substring(i, j));
		if (m.matches()) {
			System.out.println(indent + line.substring(i, j) + " matches " + "B(" + m.group(1) + ")S");

			if (isMonkeyWord(m.start(1), m.end(1))) {

				indent = indent.substring(1);
				return true;
			}
		}

		indent = indent.substring(1);
		System.out.println(indent + "return false");
		return false;
	}

}
