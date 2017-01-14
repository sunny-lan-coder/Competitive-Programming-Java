package duwei.p1307;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int ts = 0; ts < t; ts++) {
			int n = s.nextInt();
			int[] c = new int[n];
			for (int i = 0; i < n; i++) {
				c[i] = s.nextInt();
			}

			int[][] dp = new int[n][n + 1];
			for(int i=0;i<n;i++){
				for (int j = 0; j <= n; j++) {
					dp[i][j]=Integer.MAX_VALUE;
				}
			}
			
			for(int i=0;i<n;i++){
				dp[i][i]=0;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j <= n; j++) {
					dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+1);
					
				}
			}

			System.out.println(dp[0][n]);
		}
		s.close();

	}

}
