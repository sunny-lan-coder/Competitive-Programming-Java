package hackerank;

import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] r = new int[N];
		for (int i = 0; i < N; i++) {
			r[i] = s.nextInt();
		}
		s.close();

		int[] dp = new int[N];

		for (int i = 0; i < N; i++)
			dp[i] = 1;
		
		// go left
		for (int j = N - 2; j >= 0; j--) {
			int val = 1;
			if (r[j] > r[j + 1])
				val = dp[j + 1] + 1;

			dp[j] = Math.max(dp[j], val);
		}

		// go right
		for (int j = 1; j < N; j++) {
			int val = 1;
			if (r[j] > r[j - 1])
				val = dp[j - 1] + 1;

			dp[j] = Math.max(dp[j], val);
		}

		int sum = 0;
		for (int val : dp) {
			sum += val;
		}
		System.out.println(sum);
	}

}
