package ccc.s2009;

import java.util.Scanner;

public class ccc09s5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int k = s.nextInt();

		int[][] start = new int[n][m];
		int[][] end = new int[n][m + 1];
		for (int i = 0; i < k; i++) {
			int x = s.nextInt() - 1;
			int y = s.nextInt() - 1;
			int r = s.nextInt();
			int b = s.nextInt();
			int rsqr = r * r;
//			System.out.print("circle: ");
			for (int xact = Math.max(x - r, 0); xact <= Math.min(x + r, n-1); xact++) {
				int x1 = xact - x;
				int circle = (int) Math.sqrt(rsqr - x1 * x1);
				int yact1 = Math.max(y - circle, 0);
				int yact2 = Math.min(y + circle + 1, m);
				start[xact][yact1] += b;
				end[xact][yact2] += b;
//				System.out.print("c=" + circle + ", x2=" + x1 * x1 + ", r2=" + rsqr + ", x=" + xact + ", y1="
//						+ yact1 + ", y2=" + yact2 + " ");
			}
//			System.out.println();
		}
		s.close();
		int max = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += start[i][j];
				sum -= end[i][j];

				if (sum == max)
					count++;
				else if (sum > max) {
					count = 1;
					max = sum;
				}
//				System.out.print((start[i][j] - end[i][j]) + " ");
			}
//			System.out.println();
		}

		System.out.println(max);
		System.out.println(count);

	}

}
