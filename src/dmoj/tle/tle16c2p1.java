package dmoj.tle;

import java.util.Scanner;

public class tle16c2p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int debt = 0;
		int maxdebtday = -1;
		int maxdebtval = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (debt > maxdebtval) {
				maxdebtday = i;
				maxdebtval = debt;
			}
			String val = s.next();
			int x = s.nextInt();
			if (val.equals("borrow")) {
				debt += x;
			} else {
				debt -= x;
			}
		}
		if (debt > maxdebtval) {
			maxdebtday = n;
			maxdebtval = debt;
		}
		s.close();
		System.out.println(maxdebtday);
	}

}
