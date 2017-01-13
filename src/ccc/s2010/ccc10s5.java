package ccc.s2010;

import java.util.Scanner;

public class ccc10s5 {

	static int maxidx = 0;

	static int[] point;

	static int[][] dp, dpL, dpR;

	static int x;
	static int n;

	static void mkTree(String val, int idx) {
		maxidx = Math.max(maxidx, idx);
		if (!val.contains("(")) {
			int num = Integer.parseInt(val);
			for (int i = 0; i <= x; i++) {
				dp[i][idx] = num + i;
			}
			return;
		}
		val = val.substring(1, val.length() - 1);
		val = val.trim();
		int splitIdx;
		int cnt = 0;
		String left = "";
		for (splitIdx = 0; splitIdx < val.length(); splitIdx++) {
			char curr = val.charAt(splitIdx);
			if (curr == '(')
				cnt++;
			if (curr == ')')
				cnt--;
			if (curr == ' ' && cnt == 0)
				break;
			left += curr;
		}

		left = left.trim();
		String right = val.substring(splitIdx).trim();
		mkTree(left, idx * 2 + 1);
		mkTree(right, idx * 2 + 2);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String tree = s.nextLine();
		x = Integer.parseInt(s.nextLine());
		s.close();
		dp = new int[2501][401];
		dpL = new int[2501][401];
		dpR = new int[2501][401];
		for (int i = 0; i <= 2500; i++) {
			for (int j = 0; j <= 400; j++) {
				dp[i][j] = -1;
			}
		}
		mkTree(tree, 0);
		for (int n = maxidx/2; n >= 0; n--) {
			if(dp[x][n]!=-1)
				continue;
			int branch;
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= i; j++) {
					branch=(1 + j);
					branch*=branch;
					dpL[i][n] = Math.max(dpL[i][n], Math.min(branch, dp[i - j][n * 2 + 1]));
					dpR[i][n] = Math.max(dpR[i][n], Math.min(branch, dp[i - j][n * 2 + 2]));
				}
			}
			
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= i; j++) {
					dp[i][n] = Math.max(dp[i][n], dpL[j][n] + dpR[i - j][n]);
				}
			}
		}
		System.out.println(dp[x][0]);
	}
}
