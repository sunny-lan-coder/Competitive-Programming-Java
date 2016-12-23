package ccc.j2013;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int Y = s.nextInt();
		s.close();
		outer: while (true) {
			Y++;
			String y = Integer.toString(Y);
			for (int dig = 0; dig < y.length(); dig++) {
				for (int ch = dig + 1; ch < y.length(); ch++) {
					if (y.charAt(dig) == y.charAt(ch)) {
						continue outer;
					}
				}
			}
			System.out.println(y);
			return;
		}
	}

}
