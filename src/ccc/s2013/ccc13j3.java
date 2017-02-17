package ccc.s2013;

import java.util.Scanner;

public class ccc13j3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int y = s.nextInt();
		s.close();
		outer: while (true) {
			y++;
			boolean[] dig = new boolean[10];
			String str = "" + y;
			for (int c = 0; c < str.length(); c++) {
				int val = Integer.parseInt("" + str.charAt(c));
				if (dig[val])
					continue outer;
				dig[val]=true;
			}
			System.out.println(y);
			break;
		}
	}

}
