package dmoj.tle;

import java.util.Scanner;

public class tle16c2p3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = s.nextInt();
		long[] thing = new long[c];
		for (int i = 0; i < c; i++) {
			long val = s.nextLong();
			thing[i] = val;
		}
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			long val = s.nextLong();
			for (int j = 0; j < c; j++) {
				while (val % thing[j] == 0)
					val /= thing[j];

				long g;
				while ((g = gcd(val, thing[j])) != 1)
					val /= g;
			}
			if (val != 1)
				flag = false;
		}

		s.close();
		if (flag)
			System.out.println("Y");
		else {
			System.out.println("N");
		}
	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}
