package dmoj;

import java.util.Scanner;

public class coci07c1p4 {

	static final long mod = 100000;

	static String v;
	static long[][] dp;

	static char v(int i) {
		return v.charAt(i);
	}

	static boolean open(int i) {
		return v(i) == '{' || v(i) == '[' || v(i) == '(' || v(i) == '?';
	}

	static boolean close(int i) {
		return v(i) == '}' || v(i) == ']' || v(i) == ')' || v(i) == '?';
	}

	static char inv(char i) {
		switch (i) {
		case '{':
			return '}';
		case '[':
			return ']';
		case '(':
			return ')';
		case '}':
			return '{';
		case ']':
			return '[';
		case ')':
			return '(';
		}
		throw new RuntimeException();
	}

	static boolean cmp(int i, int j) {
		if (v(i) == '?')
			return true;
		if (v(j) == '?')
			return true;
		return inv(v(j)) == v(i);
	}

	static long f(int i, int j) {
		if (i > j)
			return 1;
		if ((j - i + 1) % 2 == 1)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		long ret = 0;
		if (open(i) && close(j)) {
			for (int k = i + 1; k <= j; k++) {
				long ret1 = 0;
				if (close(k) && cmp(i, k)) {
					if (v(i) == '?' && v(k) == '?')
						ret1 = 3 * f(i + 1, k - 1) % mod;
					else
						ret1 = f(i + 1, k - 1) % mod;
				}
				ret += ret1 * f(k + 1, j) % mod;
				ret %= mod;
			}
		}
		ret %= mod;
		dp[i][j] = ret;
		return ret;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		dp = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		v = s.next();
		long out = f(0, n - 1);
		System.out.println(out);
		s.close();
	}

}
