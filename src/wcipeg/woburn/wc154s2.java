package wcipeg.woburn;

import java.util.Scanner;

public class wc154s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] C = new int[N];
		int[] dp = new int[N];
		for (int j = 0; j < N; j++) {
			C[j] = s.nextInt() - 1;
			dp[j] = -1;
		}
		s.close();

		int[] map = new int[N];
		for (int i = 0; i < N; i++) {
			if (dp[i] == -1) {
				int current = i;
				do {
					System.out.println("traverse "+current+" to "+C[current]);
					map[i]++;
					dp[current] = i;
					current = C[current];
				} while (current != i);
				System.out.println(map[i]);
			} else {
				System.out.println(map[dp[i]]);
			}
		}
	}

}
