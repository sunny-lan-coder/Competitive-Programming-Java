package duwei.tmp7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		boolean[][] adjmat = new boolean[n + 1][n + 1];// [higher][lower]
		int[] degrees = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int k = s.nextInt();
			boolean[] stations = new boolean[n + 1];
			for (int j = 0; j < k; j++)
				stations[s.nextInt()] = true;

			for (int j = 1; j <= n; j++)
				if (stations[j])
					for (int l = 1; l <= n; l++)
						if (!stations[l]) {
							adjmat[j][l] = true;
							degrees[l]++;
						}

		}
		s.close();

		int nodesleft = n;
		int count = 0;
		while (nodesleft > 0) {
			for (int i = 1; i <= n; i++) {
				if (degrees[i] == 0) {
					for (int j = 1; j <= n; j++) {
						if (adjmat[i][j]) {
							adjmat[i][j] = false;
							degrees[j]--;
						}
					}
					nodesleft--;
				}
			}
			count++;
		}

		System.out.println(count);
	}

}
