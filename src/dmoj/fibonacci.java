package dmoj;

import java.util.Scanner;

public class fibonacci {
	static final int[] cornercase = { 0, 1, 1, 2, 3, 5, 8, 13 };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = Long.parseUnsignedLong(s.nextLine());
		s.close();
		if (l(n, 6)) {
			System.out.println(cornercase[(int) n]);
		}

		long fcn = 0;
		long fcnp1 = 1;

		long f2cn;

		long fnm1 = 0;
		long fn = 1;
		long fnp1;

		long f2nm1;
		long f2n;

		for (int cp = 0; cp < 64; cp++) {
			fnp1 = fn + fnm1;

			if (((n >> cp) & 1) == 1) {
				f2cn = (fn * fcnp1 % 1000000007 + fnm1 * fcn % 1000000007) % 1000000007;
				fcnp1 = (fnp1 * fcnp1 % 1000000007 + fn * fcn % 1000000007) % 1000000007;

				fcn = f2cn;
			}

			f2nm1 = (fn * fn % 1000000007 + fnm1 * fnm1 % 1000000007) % 1000000007;
			f2n = (fn * fnp1 % 1000000007 + fn * fnm1 % 1000000007) % 1000000007;

			fnm1 = f2nm1;
			fn = f2n;

		}

		System.out.println(fcn);
	}

	static boolean l(long a, long b) {
		return Long.compareUnsigned(a, b) < 0;
	}
}
