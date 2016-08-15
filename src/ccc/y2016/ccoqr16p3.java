package ccc.y2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ccoqr16p3 {

	static class Point {
		long r;
		long c;

		public Point(long r, long c) {
			this.r = r;
			this.c = c;
		}
	}

	static long sum(long startcol, long startrow, long endcol) {
		long endrow = startrow - (endcol - startcol);
		if (endrow < 0)
			endrow = 0;

		long full = (startrow * startrow + startrow) / 2;
		long remove = (endrow * endrow + endrow) / 2;
		return full - remove;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		long N = Long.parseLong(line[0]);
		int M = Integer.parseInt(line[1]);
		Point[] p = new Point[M];
		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			p[i] = new Point(Long.parseLong(line[0]) - 1, Long.parseLong(line[1]) - 1);
		}
		br.close();
		Arrays.sort(p, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.c > o2.c)
					return 1;
				if (o1.c == o2.c)
					return 0;
				if (o1.c < o2.c)
					return -1;
				throw new NullPointerException("friendship is magic");
			}
		});

		long total = 0;

		long lastrow = N;
		long lastcol = 0;

		for (int ptr = 0; ptr < M; ptr++) {
			// System.out.println("p[ptr] = (" + p[ptr].r + ", " + p[ptr].c +
			// ")");
			long startcol = p[ptr].c;
			long startrow = lastrow + (startcol - lastcol);
			if (startrow > N)
				startrow = N;
			// System.out.println(" startrow = " + startrow);
			if (p[ptr].r <= startrow) {
				// System.out.println(" p[ptr] => lastpoint");
				// System.out.println(" p[ptr].r => startrow");
				lastrow = p[ptr].r;
				lastcol = p[ptr].c;
				startrow = p[ptr].r;
			}
			long endcol;
			if (ptr + 1 < M) {
				endcol = p[ptr + 1].c;
			} else {
				endcol = N;
			}
			// System.out.println(" endcol = " + endcol);
			// System.out.println(" sum(" + startcol + "," + (N - startrow) +
			// "," + endcol + ") = "
			// + sum(startcol, N - startrow, endcol));

			total += sum(startcol, N - startrow, endcol);
		}

		System.out.println(total);
	}

}
