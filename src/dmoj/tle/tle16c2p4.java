package dmoj.tle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tle16c2p4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int oxh;
		int oyh;
		int xh =  Math.abs(oxh =Integer.parseInt(tmp[0]));
		int yh = Math.abs(oyh =Integer.parseInt(tmp[1]));

		int xm;
		if (xh == 0)
			xm = 1;
		else
			xm = oxh / xh;
		int ym;
		if (yh == 0)
			ym = 1;
		else
			ym = oyh / yh;

		int t = Integer.parseInt(br.readLine());

		int[][] dc = new int[xh + 1][yh + 1];
		int[][] lc = new int[xh + 1][yh + 1];

		for (int i = 0; i < t; i++) {
			tmp = br.readLine().split(" ");

			int x = Integer.parseInt(tmp[0]) * xm;
			int y = Integer.parseInt(tmp[1]) * ym;
			

			int l = Integer.parseInt(tmp[2]);
			int yc = y + l ;
			int xc;
			for (xc = x - l ; xc <= x + l ; xc++) {
				if (xc >= 0 && xc <= xh && yc >= 0 && yc <= yh)
					dc[xc][yc]++;
			}
			xc = x + l ;
			for (yc = y - l ; yc <= y + l ; yc++) {
				if (xc >= 0 && xc <= xh && yc >= 0 && yc <= yh)
					lc[xc][yc]++;
			}
		}
		br.close();
		int[][] dp = new int[xh + 1][yh + 1];
		for (int x = 0; x <= xh; x++) {
			for (int y = 0; y <= yh; y++) {
				dp[x][y] = Integer.MAX_VALUE;
			}
		}
		dp[xh][yh] = 0;

		for (int k = xh + yh; k > 0; k--) {
			int xs = Math.max(0, k - yh);
			int xe = Math.min(xh, k);
			for (int x = xs; x <= xe; x++) {
				int y = k - x;
				if (y > 0)
					dp[x][y - 1] = Math.min(dp[x][y - 1], dp[x][y] + dc[x][y - 1]);
				if (x > 0)
					dp[x - 1][y] = Math.min(dp[x - 1][y], dp[x][y] + lc[x - 1][y]);
			}
		}

		System.out.println(dp[0][0]);
	}

}
