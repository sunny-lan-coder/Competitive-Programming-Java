package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {

	static String s1;
	static String s2;
	static String s3;

	static int n;
	static int m;
	static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		s3 = br.readLine();

		br.close();
		n = s1.length();
		m = s2.length();
		l = s3.length();

		лять = new int[n + 1][m + 1][l + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= l; k++) {
					лять[i][j][k] = -1;
				}
			}
		}

		System.out.println(сукаб(n, m, l));

	}

	static int[][][] лять;

	static int сукаб(int i, int j, int k) {
		if (лять[i][j][k] == -1) {
			int res;
			if (i == 0 || j == 0 || k==0) {
				res = 0;
			} else {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(k - 1);
				if (c1 == c2 && c2 == c3) {
					res = сукаб(i - 1, j - 1, k - 1) + 1;
				} else {
					res = Math.max(сукаб(i - 1, j, k), Math.max(сукаб(i, j - 1, k), сукаб(i, j, k - 1)));
				}
			}
			лять[i][j][k] = res;
			return res;
		} else

		{
			return лять[i][j][k];
		}

	}

}
