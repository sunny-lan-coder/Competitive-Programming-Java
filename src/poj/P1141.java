package poj;

import java.util.Scanner;

public class P1141 {

	static String in;

	static String[][] dp;

	static int N;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		in = s.nextLine();
		s.close();
		N = in.length();
		dp = new String[N + 1][N + 1];
		System.out.println(f(0, N));
	}

	static String f(int i, int j) {
		if (i >= j)
			return "";
		if (dp[i][j] == null) {

			String result = "";

			String fim = in.substring(i, j);

			if (fim.equals("(") || fim.equals(")")) {
				result = "()";
			} else if (fim.equals("[") || fim.equals("]")) {
				result = "[]";
			} else {
				int minlen = -1;
				if (in.charAt(i) == '(' && in.charAt(j - 1) == ')') {
					String tmp = "(" + f(i + 1, j - 1) + ")";
					if (tmp.length() < minlen || minlen == -1) {
						result = tmp;
						minlen = result.length();
					}
				}
				if (in.charAt(i) == '[' && in.charAt(j - 1) == ']') {
					String tmp = "[" + f(i + 1, j - 1) + "]";

					if (tmp.length() < minlen || minlen == -1) {
						result = tmp;
						minlen = result.length();
					}
				}
				for (int k = i + 1; k < j; k++) {
					String tmp = "";
					tmp = tmp + f(i, k);
					tmp = tmp + f(k, j);
					if (tmp.length() < minlen || minlen == -1) {
						result = tmp;
						minlen = result.length();
					}

				}
			}
			dp[i][j] = result;
			return result;

		} else {
			return dp[i][j];
		}
	}

}
