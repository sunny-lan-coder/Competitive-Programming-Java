package bssjudge;

import java.util.Scanner;

public class bsspc17p6 {

	static int[] dp;
	static int n;
	static int[] a;

	static int f(int i) {
		if (i >= n)
			return 0;
		int res = dp[i];
		if (res != -1)
			return res;
		res = Math.max(f(i + 1), f(i + 2) + a[i]);
		dp[i] = res;
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		a = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
			dp[i] = -1;
		}
		s.close();
		System.out.println(f(0));
	}

}
