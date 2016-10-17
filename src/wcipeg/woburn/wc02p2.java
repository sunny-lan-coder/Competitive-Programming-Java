package wcipeg.woburn;

import java.util.Scanner;

public class wc02p2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {
			int a = s.nextInt();
			int b = s.nextInt();
			for (int iteration = 0; iteration < b; iteration++) {
				if (isPrime(a)) {
					// System.out.println("prime");
					a = a * 11;
					// System.out.println(a);
				} else if (isSquare(a)) {
					// System.out.println("square");
					a = a + Integer.parseInt(new StringBuilder(Integer.toString(a)).reverse().toString());
				} else if (isPalindrome(Integer.toString(a))) {
					// System.out.println("palin");
					a = Integer.parseInt(a + "4");

					// System.out.println(a);
				} else if (Integer.toString(a).charAt(0) == '2') {
					// System.out.println("startwith 2");
					a = Integer.parseInt("5" + a);
					// System.out.println(a);
				} else if (Integer.toString(a).contains("7")) {
					// System.out.println("contains 7");
					a = Integer.parseInt("0" + Integer.toString(a).substring(0, Integer.toString(a).length() - 1));

					// System.out.println(a);
				} else if (a % 6 == 0) {
					// System.out.println("divisible 6");
					a = Integer.parseInt("0" + Integer.toString(a).substring(1));

					// System.out.println(a);
				} else if (Integer.toString(a).length() % 2 == 0) {
					// System.out.println("length even");
					a = Integer.parseInt(Integer.toString(a).substring(0, Integer.toString(a).length() / 2) + "1"

					+ Integer.toString(a).substring(Integer.toString(a).length() / 2));

					// System.out.println(a);
				} else if (Integer.toString(a).length() % 2 == 1) {
					// System.out.println("length odd");
					a = a + 231;
					// System.out.println(a);
				}
			}
			System.out.println(a);
		}
		s.close();
	}

	static boolean isPrime(int n) {
		int sqrt = (int) (Math.sqrt(n) + 1);
		if (n == 2)
			return true;

		if (n % 2 == 0)
			return false;
		for (int factor = 3; factor <= sqrt; factor++) {
			if (n % factor == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isSquare(int n) {
		// loop through all the numbers till the target
		for (int i = 0; i < Math.sqrt(n) + 1; i++) {
			// if we have a match
			if ((i * i) == n) {
				return true;
			}
		}

		// no matching number could be squared
		return false;
	}

	static boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() == 1)
			return true;
		char first = s.charAt(0);
		char last = s.charAt(s.length() - 1);
		if (first == last) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

}
