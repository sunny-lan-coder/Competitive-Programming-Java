package ccc.y2016;

import java.util.Scanner;

public class ccc16s4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] dp = new int[n + 1][n + 2];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			dp[i][i+1] = s.nextInt();
		}
		s.close();
		
		
		//loop through block sizes
		for(int bs=2;bs<=n;bs++){
			for(int start=0;start<n-bs;start++){
				//two block combinations
				
			}
		}
	}

}
