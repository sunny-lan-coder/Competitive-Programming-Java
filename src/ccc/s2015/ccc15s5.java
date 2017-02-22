package ccc.s2015;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.max;

public class ccc15s5 {

	static long[] b;
	static long[] a;

	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		m = s.nextInt();
		b = new long[m+1];
		//offset b by one, to prevent index out of bounds
		for (int i = 1; i <= m; i++) {
			b[i] = s.nextInt();
		}
		s.close();
		//give dp array extra room for base cases
		dp = new long[n+1][m+2][m+2][2];
		for(int line=0;line<=n;line++){
			for (int i = 0; i <= m+1; i++) {
				for (int j = 0; j <= m+1; j++) {
					dp[line][i][j][0]=-1;
					dp[line][i][j][1]=-1;
				}
			}
		}
		Arrays.sort(b);
		
		//start i=1, so j will never become -1
		System.out.println(maxPies(0, 1, m, 0));
	}

	static long[][][][] dp;

	static long maxPies(int line, int i, int j, int prev) {
		long res = dp[line][i][j][prev];
		if (res != -1)
			return res;
		else
			res = 0;

		// if last pie wasn't taken
		if (prev == 0) {
			// then we can take another pie, with two options:
			// 1. from the line, if we aren't at the end of the line
			if (line < n)
				res = max(res, maxPies(line + 1, i, j, 1) + a[line]);
			
			// 2. from the pile, if we aren't out of pies in the pile
			if (i <= j) // always take the highest pie from the pile
				res = max(res, maxPies(line, i, j - 1, 1) + b[j]);
		}

		// we can always skip a pie, with also two options:
		// 1. from the line, if we aren't at the end of the line
		if (line < n)
			res = max(res, maxPies(line + 1, i, j, 0));
		// 2. from the pile, if we aren't out of pies in the pile
		if (i <= j) // always skip the lowest pie from the pile
			res = max(res, maxPies(line, i + 1, j, 0));

		dp[line][i][j][prev] = res;
		return res;
	}

}
