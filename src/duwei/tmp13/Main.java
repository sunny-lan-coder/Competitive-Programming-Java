package duwei.tmp13;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static BigInteger[] dp = new BigInteger[400];

	public static void main(String[] args) {
		for (int i = 0; i < 400; i++) {
			dp[i] = BigInteger.valueOf(-1);
		}
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		Scanner s = new Scanner(System.in);
		int n;
		while ((n = s.nextInt()) != 0) {
			System.out.println(f(n));
		}
		s.close();
	}

	static BigInteger f(int x) {
		if (dp[x] != BigInteger.valueOf(-1))
			return dp[x];

		BigInteger total = BigInteger.ZERO;

		for (int i = 1; i <= x; i++) {
			total = total.add(f(i - 1).multiply(f(x - i)));
		}

		return dp[x] = total;

	}

}
