package ccc.s2008;

import java.util.Scanner;

public class ccc08s1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in)

		;
		String in;
		String minn="";
		int min = Integer.MAX_VALUE;
		do {
			in = s.next();
			int v = s.nextInt();
			if (v < min) {
				minn = in;
				min = v;
			}
		} while (!in.equals("Waterloo"));
		System.out.println(minn);
	}

}
