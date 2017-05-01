package dmoj.tle;

import java.util.Scanner;

public class tle16c8p4 {

	public static void main(String[] args) {
		int mod = 1000000007;
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		if (x == 1) {
			int d = s.nextInt();
			int n = s.nextInt();
			int p = s.nextInt();

			int[] refuel = new int[100010];
			for (int i = 0; i < 100010; i++)
				refuel[i] = -1;
			for (int i = 0; i < p; i++) {
				refuel[s.nextInt()] = s.nextInt();
			}
			refuel[0] = n;

			long[] dp = new long[d + 1];
			long[] prefix = new long[d + 2];
			dp[0] = 1;
			long sum = 0;
			for (int i = 0; i <= d; i++) {
				// go back down
				sum = (sum % mod - prefix[i] % mod + mod) % mod;
				if (i > 0)
					dp[i] = sum % mod;
				// System.out.println("At planet "+i+", number ways is "+dp[i]);
				// if planet is refeulable
				if (refuel[i] != -1) {
					// the amount of fuel
					int fuel = refuel[i];

					// increment segment
					sum = (sum % mod + dp[i] % mod + mod) % mod;
					if (i + fuel <= d)
						prefix[i + fuel + 1] = (prefix[i + fuel + 1] % mod + dp[i] % mod + mod) % mod;
					// System.out.println(" Refeulable by "+fuel+". Adding to
					// range "+i+","+(i+fuel));
				}
				// System.out.println(dp[i]);
			}

			System.out.println(dp[d] % mod);
		} else {
			long w = s.nextInt();
			if (w == 0) {
				System.out.println("10 1 2");
				System.out.println("1 1");
				System.out.println("2 1");
				s.close();
				return;
			}
			int n = (int) (Math.ceil(Math.log(w) / Math.log(2) + 2));

			long[] pow = new long[n];
			pow[1] = 1;
			long[] fuel = new long[n];
			for (int i = 1; i < n - 1; i++) {
				fuel[i] = (n - i - 1);
				pow[i + 1] = pow[i] * 2;
			}

			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			for (int i = n - 1; i >= 1; i--) {
				if (pow[i] <= w) {
					fuel[i] += 1;
					w -= pow[i];
				}
				if (fuel[i] > 0) {
					sb.append(i + " " + fuel[i] + "\n");
					cnt++;
				}
			}
			System.out.println(n + " " + (n - 1) + " " + cnt);
			System.out.println(sb);
		}
		s.close();

	}

}
