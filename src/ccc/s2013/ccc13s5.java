package ccc.s2013;

import java.util.Scanner;

public class ccc13s5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		int[] dp = new int[n + 1];
		int[] factor = new int[n + 1];
		int[] from = new int[n + 1];
		int[] cost=new int[n+1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[1] = 0;
		for (int i = 1; i < n; i++) {

			for (int f = 1; f * f <= i; f++) {
				if (i % f == 0) {
					int f2 = i / f;
					if (i + f <= n)
						if (dp[i] + f2 < dp[i + f]) {
							dp[i + f] = dp[i] + f2;
							factor[i + f] = f;
							cost[i+f]=f2;
							from[i + f] = i;
						}
					if (i + f2 <= n)
						if (dp[i + f] + f2 < dp[i + f2]) {
							dp[i + f2] = dp[i] + f;
							cost[i+f2]=f;
							factor[i + f2] = f2;
							from[i + f2] = i;
						}
				}
			}
		}
		int currnum=n;
		do{
			System.out.print(factor[currnum]);
			System.out.print(" ");
			System.out.print(currnum);
			System.out.print(" ");
			System.out.println(cost[currnum]);
			currnum=from[currnum];
		}while(currnum!=1);

		System.out.println(dp[n]);

	}

}