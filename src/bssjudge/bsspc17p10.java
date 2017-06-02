package bssjudge;

import java.util.Scanner;

public class bsspc17p10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] d = new int[1101][1101];
		for (int i = 0; i < n; i++) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			d[x1][y1] += 1;
			d[x2 + 1][y1] += -1;
			d[x1][y2 + 1] += -1;
			d[x2 + 1][y2 + 1] += 1;
		}
		s.close();

		for (int y = 0; y <= 1001; y++) {
			int sum = 0;
			for (int x = 0; x <= 1001; x++) {
				sum += d[x][y];
				d[x][y] = sum;
			}
		}

		for (int x = 0; x <= 1001; x++) {
			int sum = 0;
			for (int y = 0; y <= 1001; y++) {
				sum += d[x][y];
				d[x][y] = sum;
			}
		}

		int cnt = 0;
		for (int x = 0; x <= 1001; x++)
			for (int y = 0; y <= 1001; y++)
				if (d[x][y] > 0)
					cnt++;

		System.out.println(cnt);
	}

}
