package ccc.s2011;

import java.util.Scanner;

public class S4 {
	static int o = 0;
	static int a = 1;
	static int b = 2;
	static int ab = 3;

	static int n = 0;
	static int p = 1;

	static int[][] avail = new int[4][2];
	static int[][] need = new int[4][2];

	static int d(int st, int srh, int dt, int drh) {
		int amount = Math.min(need[dt][drh], avail[st][srh]);
		// System.out.println("donating "+amount+" from ("+st+", "+srh+") to
		// ("+dt+", "+drh+")");
		need[dt][drh] -= amount;
		avail[st][srh] -= amount;
		return amount;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		avail[o][n] = s.nextInt();
		avail[o][p] = s.nextInt();
		avail[a][n] = s.nextInt();
		avail[a][p] = s.nextInt();
		avail[b][n] = s.nextInt();
		avail[b][p] = s.nextInt();
		avail[ab][n] = s.nextInt();
		avail[ab][p] = s.nextInt();
		need[o][n] = s.nextInt();
		need[o][p] = s.nextInt();
		need[a][n] = s.nextInt();
		need[a][p] = s.nextInt();
		need[b][n] = s.nextInt();
		need[b][p] = s.nextInt();
		need[ab][n] = s.nextInt();
		need[ab][p] = s.nextInt();
		s.close();
		int[][] tmp1 = new int[4][2];
		int[][] tmp2 = new int[4][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				tmp1[i][j] = avail[i][j];
				tmp2[i][j] = need[i][j];
			}
		}

		int total = 0;
		total += d(o, n, o, n);

		total += d(o, p, o, p) + d(o, n, o, p);
		total += d(a, n, a, n) + d(o, n, a, n);
		total += d(b, n, b, n) + d(o, n, b, n);

		total += d(a, p, a, p) + d(o, p, a, p);
		total += d(b, p, b, p) + d(o, p, b, p);
		total += d(a, p, a, p) + d(o, n, a, p);
		total += d(b, p, b, p) + d(o, n, b, p);

		total += d(ab, n, ab, n) + d(b, n, ab, n) + d(a, n, ab, n) + d(o, n, ab, n);
		total += d(ab, p, ab, p) + d(ab, n, ab, p) + d(b, p, ab, p) + d(b, n, ab, p) + d(a, p, ab, p) + d(a, n, ab, p)
				+ d(o, p, ab, p) + d(o, n, ab, p);
		
		int total2=total;
		total=0;
		
		avail=tmp1;
		need=tmp2;
		
		total += d(o, n, o, n);

		total += d(o, p, o, p) + d(o, n, o, p);
		total += d(a, n, a, n) + d(o, n, a, n);
		total += d(b, n, b, n) + d(o, n, b, n);

		total += d(a, p, a, p) + d(a, n, a, p);
		total += d(b, p, b, p) + d(b, n, b, p);
		total += d(o, p, a, p) + d(o, n, a, p);
		total += d(o, p, b, p) + d(o, n, b, p);

		total += d(ab, n, ab, n) + d(b, n, ab, n) + d(a, n, ab, n) + d(o, n, ab, n);
		total += d(ab, p, ab, p) + d(ab, n, ab, p) + d(b, p, ab, p) + d(b, n, ab, p) + d(a, p, ab, p) + d(a, n, ab, p)
				+ d(o, p, ab, p) + d(o, n, ab, p);

		System.out.println(Math.max(total,total2));
	}

}
