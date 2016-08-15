package ccc.y2016;

import java.util.Scanner;

public class ccc16s5 {
	static int n;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		long t = s.nextLong();
		String x0 = s.next();
		s.close();
		long i = 0;
		String xi = x0;
		while (i != t) {
			long pow = 1;
//			System.out.println("i="+i);
			while ((pow*2 )+ i < t) {
				pow *= 2;
//				System.out.println(" test pow="+pow+", pow+i="+(pow+i));
			}
//			System.out.println(" pow="+pow);
			xi = fpow2(xi, pow);
			i += pow;
		}
		System.out.println(xi);
	}

	static String fpow2(String s, long pow) {
		StringBuilder sb = new StringBuilder();
		int xi;
		int yi;
		char x;
		char y;
		for (int i = 0; i < n; i++) {
			xi = (int) ((i - pow) % n);
			if (xi < 0)
				xi += n;
			yi = (int) ((i + pow) % n);
			x = s.charAt(xi);
			y = s.charAt(yi);
			if (x == y) {
				sb.append("0");
			} else {
				sb.append("1");
			}
		}
		return sb.toString();
	}

	static String f(String s) {
		return xor(shiftLeft(s), shiftRight(s));
	}

	static String shiftLeft(String s) {
		return s.substring(1) + s.charAt(0);
	}

	static String shiftRight(String s) {
		return s.charAt(n - 1) + s.substring(0, n - 1);
	}

	static String xor(String a, String b) {
		StringBuilder sb = new StringBuilder();
		char x;
		char y;
		for (int i = 0; i < n; i++) {
			x = a.charAt(i);
			y = b.charAt(i);
			if (x == y) {
				sb.append("0");
			} else {
				sb.append("1");
			}
		}
		return sb.toString();
	}
}
