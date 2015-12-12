package pej;

import java.util.Scanner;

public class p129ex3 {

	static class Logarithm {
		public static double logb(double a, double b) {
			return Math.log(a) / Math.log(b);
		}

		public static double log2(double a) {
			return logb(a, 2);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long p = (long) Math.ceil(Logarithm.log2(n));
		System.out.println(Math.pow(2, p));
		s.close();
	}

}
