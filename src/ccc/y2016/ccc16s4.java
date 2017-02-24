package ccc.y2016;

import java.util.Scanner;

public class ccc16s4 {
	static int[][] dp;

	static int[] a;
	static int[][] sum;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		dp = new int[n][n];
		sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			int tmp = 0;
			for(int j=0;j<n;j++){
				dp[i][j] = -1;
			}
			for (int j = i; j < n; j++) {
				
				tmp += a[j];
				sum[i][j] = tmp;
				System.out.println("["+i+","+j+"]="+tmp);
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("rppt");
				max = Math.max(max, f(i, j) * sum[i][j]);
			}
		}

		System.out.println(max);
	}

	static int f(int i, int j) {
		System.out.println("[i,j]=["+i+","+j+"]");
		if (dp[i][j] != -1){
			System.out.println(dp[i][j]);
			return dp[i][j];
		}

		int ret = 0;
		if (i >= j){
			System.out.println(" over");
			ret = 1;
		}	else {
			int a = i;
			int b = j;
			while (a <= b) {
				
				int c = sum[i][a];
				int d = sum[b][j];
				System.out.println("[i,a]=["+i+","+a+"]="+c+", [b,j]=["+b+","+j+"]="+d);
				if (c > d)
					b--;
				else if (c < d)
					a++;
				else {
					System.out.println("good");
					ret = f(i, a) * f(a + 1, b - 1) * f(b, j);
					System.out.println("goodgg");
					if (ret == 1)
						break;

				}
			}
		}

		dp[i][j] = ret;
		System.out.println(ret);

		return ret;
	}

}
