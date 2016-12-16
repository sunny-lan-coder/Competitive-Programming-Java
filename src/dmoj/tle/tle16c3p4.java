package dmoj.tle;

import java.util.Scanner;

public class tle16c3p4 {

	static long n;
	static long m;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextLong();
		m = s.nextLong();
		s.close();
		if (n == 1 || m == 1) {
			System.out.println("First");
			return;
		}
		
		if ((n + m) % 2 == 1) {
			System.out.println("First");
		} else {
			System.out.println("Second");
		}
	}

}
