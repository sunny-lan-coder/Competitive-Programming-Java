package wcipeg.woburn;

import java.util.Scanner;

public class wc163s1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long m = s.nextLong();
		long k = s.nextLong();
		s.close();
		long low = Math.min(n, m);
		long area = low * (k+1);
		if (area > (n * m - 2))
			System.out.println(-1);
		else
			System.out.println(area);
	}
}
