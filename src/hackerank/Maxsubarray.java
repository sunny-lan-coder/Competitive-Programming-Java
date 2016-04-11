package hackerank;

import java.util.Arrays;
import java.util.Scanner;

public class Maxsubarray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 0; t < T; t++) {
			int N = s.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = s.nextInt();
			}

			// contiguous
			int[] dp = new int[N];
			dp[0] = A[0];
			int max = dp[0];
			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
				max = Math.max(max, dp[i]);
			}

			System.out.print(max + " ");

			// non contiguous
			int[] sorted = Arrays.copyOf(A, N);
			Arrays.sort(sorted);
			max = sorted[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (max > max + sorted[i])
					break;
				max += sorted[i];
			}
			System.out.println(max);
		}
		s.close();
	}

}
