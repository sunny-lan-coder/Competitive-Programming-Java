package dmoj.tle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class tle16c5p3copy {

	static class Checkpoint {
		public final long d;
		public final long a;

		public Checkpoint(int d, int a) {
			this.d = d;
			this.a = a;
		}
	}

	private static int n;
	private static long inc;
	private static long dec;
	private static long boost;
	private static Checkpoint[] pts;
	private static long[] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		 n = s.nextInt();
		 inc = s.nextLong();
		 dec = s.nextLong();
		 boost = s.nextLong();

		 pts = new Checkpoint[n + 1];

		 dp = new long[n + 1];
		pts[0] = new Checkpoint(0, 0);
		for (int i = 1; i <= n; i++) {
			dp[i] = -1;
			pts[i] = new Checkpoint(s.nextInt(), s.nextInt());
		}
		dp[0]=-1;
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

		
	}
	
	public long f(int n){
		if(dp[n]!=-1)
			return dp[n];
		if(n==tle16c5p3copy.n){
			return 1;
		}
		
		
	}
	
	

}
