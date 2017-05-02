package algorithms;

//catalan numbers - very useful in combinatorics
//one example - the number of ways to form a valid sequence of parenthesis of length n
public class Catalan {

	static long dp(int n) {
		long[] catalan = new long[n + 1];
		catalan[0] = catalan[1] = 1;
		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}
		}
		return catalan[n];
	}

	static long binomial(int n, int k) {
		long res = 1;
		if (k > n - k)
			k = n - k;

		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

	static long cbin(int n) {
		return binomial(2 * n, n) / (n + 1);
	}

	public static void main(String[] args) {
		 for (int i = 0; i < 10; i++)
			System.out.println( cbin(i));
	}

}
