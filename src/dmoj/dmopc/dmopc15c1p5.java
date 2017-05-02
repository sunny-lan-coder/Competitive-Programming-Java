package dmoj.dmopc;

import java.util.Scanner;

public class dmopc15c1p5 {

	static int[][] pre;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int w = s.nextInt();
		int h = s.nextInt();
		int n = s.nextInt();
		int[][] m = new int[h][w];
		int[][] pre2 = new int[h + 1][w + 1];
		pre = new int[h + 1][w + 1];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				m[i][j] = s.nextInt();
				pre2[i][j + 1] += m[i][j];
				pre2[i][j + 1] += pre2[i][j];
			}
		}

		for (int i = 1; i <= w; i++) {
			int sum = 0;
			for (int j = 0; j < h; j++) {
				sum += pre2[j][i];
				pre[j + 1][i] = sum;
			}
		}

		// while (s.hasNext()) {
		// int x = s.nextInt();
		// int y = s.nextInt();
		// int l = s.nextInt();
		// int k = s.nextInt();
		// System.out.println(sum(x, y, l, k));
		//
		// }

		s.close();

		int max = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				for (int k = i + 1; k <= w; k++) {
					int wi = k - i;
					int l = n / wi;

					max = Math.max(max, sum(i, j, k, Math.min(h,l + j)));
				}
			}
		}

		System.out.println(max);

	}

	static int sum(int x, int y, int x2, int y2) {
		int whole = pre[y2][x2];
		int lcol = pre[y][x2];
		int minsqr = pre[y][x];
		int ucol = pre[y2][x];
		return whole - ((lcol + ucol) - minsqr);
	}

}
