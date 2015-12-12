package poj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P2411 {

	// global info
	static int w;
	static int h;
	static int lim;

	// map of 1 row
	static Map<Integer, Set<Integer>> FiM;

	// cache
	static long[][] dp;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			// in
			h = input.nextInt();
			w = input.nextInt();

			// end
			if (w == 0 && h == 0)
				break;

			// odd input
			if (h * w % 2 == 1) {
				System.out.println(0);
				continue;
			}

			// initialize
			lim = 1 << w;
			dp = new long[h][lim];
			FiM = new HashMap<Integer, Set<Integer>>(lim);

			// brute force 1 row
			Set<Integer> z = new HashSet<Integer>();
			outer: for (int i = 0; i < lim; i++) {
				// fill dp array
				for (int j = 0; j < h; j++) {
					dp[j][i] = -1;
				}

				// check
				int tmp = i;
				int count = 0;
				for (int d = 0; d < w; d++) {
					int digit = 1 & tmp;
					if (digit == 0) {
						count++;
					} else {
						if (count % 2 == 1) {
							continue outer;
						}
						count = 0;
					}
					tmp = tmp >> 1;
				}
				if (count % 2 == 1) {
					continue outer;
				}
				z.add(i);
			}
			FiM.put(0, z);

			for (int i = 0; i < lim; i++) {
				Set<Integer> t = new HashSet<Integer>();
				for (int j = 0; j < lim; j++) {
					if ((j & i) == 0) {
						if (z.contains(j | i))
							t.add(j);
					}
				}

				FiM.put(i, t);
			}

			// call recursive function with base case 1
			System.out.println(f(0, 0));
		}
		input.close();

	}

	// recursive function
	static long f(int row, int lastState) {
		// base case 2
		if (row == h) {
			if (lastState == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		// read cache
		if (dp[row][lastState] != -1)
			return dp[row][lastState];

		// recurse
		long total = 0;
		for (int d : FiM.get(lastState)) {
			total = total + f(row + 1, d);
		}

		// write cache
		dp[row][lastState] = total;

		return total;
	}
}
