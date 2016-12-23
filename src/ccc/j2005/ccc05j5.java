package ccc.j2005;

import java.util.Scanner;

import java.util.regex.*;

public class ccc05j5 {

	static String line;
	static int N;
	static Pattern possibleMonkey = Pattern.compile("^(.+?)(?:N(.+?))$");
	static Pattern possibleA1 = Pattern.compile("^A$");
	static Pattern possibleA2 = Pattern.compile("^B(.+?)S?$");

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			line = s.nextLine();
			N = line.length();
			if (isMonkeyWord(line))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		s.close();
	}

	static String indent = "";

	static boolean isMonkeyWord(String v) {

		//System.out.println(indent + "ism(" +v + "):");
		indent += " ";
		if (isAWord(v)) {

			indent = indent.substring(1);
			return true;
		}
		Matcher m = possibleMonkey.matcher(v);

		//System.out.println(indent+"check 2:");
		if (m.matches()) {

			//System.out
				//	.println(indent + v + " matches " + "(" + m.group(1) + ")N(" + m.group(2) + ")");

			if (isAWord(m.group(1)) && isMonkeyWord(m.group(2))) {

				indent = indent.substring(1);
				return true;
			}

		}

		indent = indent.substring(1);
		return false;
	}

	static boolean isAWord(String v) {
		// System.out.println(indent + "isa(" + v + "):");

		indent += " ";
		Matcher m = possibleA1.matcher(v);
		if (m.matches()) {
			// System.out.println(indent + "matches a");
			indent = indent.substring(1);
			return true;
		}
		m = possibleA2.matcher(v);
		if (m.matches()) {
			// System.out.println(indent + v + " matches " + "B(" + m.group(1) +
			// ")S");

			if (isMonkeyWord(m.group(1))) {

				indent = indent.substring(1);
				return true;
			}
		}

		indent = indent.substring(1);
		// System.out.println(indent + "return false");
		return false;
	}

}
