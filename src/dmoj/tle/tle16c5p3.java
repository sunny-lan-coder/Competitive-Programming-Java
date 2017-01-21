package dmoj.tle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class tle16c5p3 {

	static class Checkpoint {
		public final long d;
		public final long a;

		public Checkpoint(int d, int a) {
			this.d = d;
			this.a = a;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long inc = s.nextLong();
		long dec = s.nextLong();
		long boost = s.nextLong();

		Checkpoint[] pts = new Checkpoint[n + 1];

		long[] dp = new long[n + 1];
		pts[0] = new Checkpoint(0, 0);
		for (int i = 1; i <= n; i++) {
			dp[i] = -1;
			pts[i] = new Checkpoint(s.nextInt(), s.nextInt());
		}
		s.close();

		Arrays.sort(pts, new Comparator<Checkpoint>() {

			@Override
			public int compare(Checkpoint o1, Checkpoint o2) {
				int res = Long.compare(o1.d, o2.d);
				if (res == 0)
					res = Long.compare(o1.a, o2.a);
				return res;
			}
		});

		for (int i = 0; i < n; i++) {

			Checkpoint src = pts[i];
			if (dp[i] != -1) {
//				 System.out.println("point:"+src.d+","+src.a);
				
				for (int j = i+1 ; j <= n; j++) {

					Checkpoint dst = pts[j];
					
					if (dst.d == src.d) {
						if (dst.a == src.a + boost) {
							dp[i] = Math.max(dp[i] + 1,dp[i]);
						}
					}

					long dist = Math.abs(dst.d - src.d);
					long high = src.a + dist * inc;
					long low = src.a - dist * dec;
					if (dst.a >= low && dst.a <= high) {
						dp[j] = Math.max(dp[i] + 1, dp[j]);

//						 System.out.println(" fly to:"+dst.d+","+dst.a+", pts="+dp[j]);
					}

				}
			}
		}

		long max = 0;
		for (int i = 0; i <= n; i++) {
			// System.out.println(dp[i]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}

}
