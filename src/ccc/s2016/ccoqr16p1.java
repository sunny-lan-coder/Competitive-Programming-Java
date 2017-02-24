package ccc.s2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ccoqr16p1 {

	static class Point {
		final long x;
		final long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	static HashMap<Long, ArrayList<Long>> xmap;
	static HashMap<Long, ArrayList<Long>> ymap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] p = new Point[n];
		xmap = new HashMap<>();
		ymap = new HashMap<>();
		String[] line;
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			p[i] = new Point(Long.parseLong(line[0]), Long.parseLong(line[1]));

		}
		br.close();

		Arrays.sort(p, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y > o2.y)
					return 1;
				if (o1.y < o2.y)
					return -1;
				return 0;
			}
		});
		for (int i = 0; i < n; i++) {
			putPointX(p[i]);
		}

		Arrays.sort(p, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x > o2.x)
					return 1;
				if (o1.x < o2.x)
					return -1;
				return 0;
			}
		});
		for (int i = 0; i < n; i++) {
			putPointY(p[i]);
		}

		long total = 0;
		for (int i = 0; i < n; i++) {
			ArrayList<Long> xaxis = xmap.get(p[i].x);
			ArrayList<Long> yaxis = ymap.get(p[i].y);
			long xidx = Collections.binarySearch(xaxis, p[i].y);
			long yidx = Collections.binarySearch(yaxis, p[i].x);
			long a = xidx;
			long b = xaxis.size() - xidx -1;
			long c = yidx;
			long d = yaxis.size() - yidx-1;
			total += a * b * c * d * 2;
		}

		System.out.println(total);
	}

	static void putPointX(Point p) {
		if (!xmap.containsKey(p.x)) {
			xmap.put(p.x, new ArrayList<>());
		}
		xmap.get(p.x).add(p.y);
	}

	static void putPointY(Point p) {
		if (!ymap.containsKey(p.y)) {
			ymap.put(p.y, new ArrayList<>());
		}
		ymap.get(p.y).add(p.x);
	}

}
