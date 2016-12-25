package dmoj.tle;

import java.util.Scanner;

public class tle16c4p2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long r = s.nextLong();
		long c = s.nextLong();
		long k = s.nextLong();
		s.close();

		long rows = (long) Math.sqrt(k);
		if (rows > r && rows > c) {
			rows = Math.min(Math.max(r, c), rows);
		} else {
			rows = Math.min(Math.min(r, c), rows);
		}
		long cols = (long) Math.ceil(((double) k) / rows);
		System.out.println(cols * 2 + rows * 2);

	}

}
