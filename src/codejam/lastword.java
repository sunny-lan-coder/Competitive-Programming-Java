package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lastword {

	public static void main(String[] args) throws FileNotFoundException {
		String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner s = new Scanner(new FileInputStream("A-large.in"));
		int T = s.nextInt();
		for (int i = 1; i <= T; i++) {
			String S = s.next();
			if (S.equals("")) {
				System.out.println("");
				continue;
			}
			String last = S.charAt(0) + "";
			for (int j = 1; j < S.length(); j++) {
				int currentfirst = map.indexOf(last.charAt(0));
				int next = map.indexOf(S.charAt(j));
				if (next >= currentfirst) {
					last = S.charAt(j) + last;
				} else {
					last += S.charAt(j);
				}
			}
			System.out.println("Case #" + i + ": " + last);
		}
		s.close();
	}

}
