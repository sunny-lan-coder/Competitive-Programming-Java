package cco;

import java.util.HashMap;
import java.util.Scanner;

public class cco17p2 {

	static HashMap<Long, Integer> min;
	static HashMap<Long, Integer> max;

	static long enc(int n, int m) {
		return n << 30 + m;
	}

	static int n(long v) {
		return (int) (v >> 30);
	}

	static int m(long v) {
		return (int) (v & (1 << 30) - 1);
	}

	static int min(int n, int m) {
		if (n < m)
			return min(m, n);

		if (m == 0)
			return 0;

		if (n == 2 * m)
			return 1;

		long key = enc(n, m);
		if (min.containsKey(key))
			return min.get(key);

		int res = Integer.MAX_VALUE;

		// if long enough to chop blocks of m by 2*m
		if (n > 2 * m) {
			// try chop off, then process whole remainder
			int rem = n % (2 * m);
			int numBlocks = n / (2 * m);
			res = Math.min(res, min(m, rem) + numBlocks);

			// if m is even, then can chop off blocks of m by m/2
			if (m % 2 == 0) {
				int rbs = m / 2;
				// if not enough, borrow from big blocks
				if (rem < rbs) {
					numBlocks--;
					rem += 2 * m;
				}
				int numrb = rem / rbs;
				res = Math.min(res, min(m, rem - numrb * rbs - numBlocks * 2 * m) + numBlocks + numrb);
			}
		}

		if (n < 2 * m) {
			if (n % 2 == 0 && m >= n / 2)
				res = Math.min(res, min(n - m / 2, m) + 1);
			else if (m % 2 == 0 && n >= m / 2)
				res = Math.min(res, min(m - n / 2, n) + 1);
			else
				res = 1;
		}
		min.put(key, res);
		return res;

	}

	static int max(int n, int m) {

		if (n < m)
			return max(m, n);

		if (m == 0)
			return 0;

		long key = enc(n, m);
		if (max.containsKey(key))
			return max.get(key);
		int res = Integer.MIN_VALUE;

		if (n == 2 * m) {
			res = Math.max(res, 1);
			if (m % 2 == 0)
				res = Math.max(max(n - m / 2, m) + 1, res);
		}

		// if long enough to chop blocks of m by 2*m
		if (n > 2 * m) {
			// try chop off, then process whole remainder
			int bs = (2 * m);
			int rem = n % bs;
			int numBlocks = n / bs;

			// each block can be divided into 4 more parts
			res = Math.max(res, max(m, rem) + 4 * numBlocks);

			// if m is even, then can chop off blocks of m by m/2
			if (m % 2 == 0) {
				int rbs = m / 2;
				// each block can be divided into 4 more parts
				if (rem < rbs) {
					numBlocks--;
					rem += 2 * m;
				}
				int numrb = rem / rbs;
				res = Math.max(res, max(m, rem - (numrb * rbs)) + numBlocks * 4 + numrb);
			}
		}

		if (n < 2 * m) {
			if (m % 2 == 0 && m >= n / 2)
				res = Math.max(res, max(n - m / 2, m) + 1);
			if (n % 2 == 0 && n >= m / 2)
				res = Math.max(res, max(m - n / 2, n) + 1);
		}
		// System.out.println(res);
		max.put(key, res);
		return res;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		s.close();
		min = new HashMap<>();
		max = new HashMap<>();
		System.out.print(min(n, m) + " ");
		System.out.println(max(n, m));
	}

}
