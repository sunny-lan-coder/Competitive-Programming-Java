package wcipeg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ccoqr16p1 {
	static class Point {
		long x;
		long y;

		public Point(long xi, long yi) {
			x = xi;
			y = yi;
		}

		@Override
		public int hashCode() {
			return (int) (65536 * x + y);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				assert o instanceof Point;
				if ((((Point) o).x == x) && (((Point) o).y == y))
					return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Map<Long, List<Point>> xaxis = new HashMap<Long, List<Point>>();
		Map<Long, List<Point>> yaxis = new HashMap<Long, List<Point>>();
		Map<Point, Integer> points = new HashMap<Point, Integer>();
		for (int i = 0; i < N; i++) {
			Point p = new Point(s.nextLong(), s.nextLong());
			points.put(p, i);
			if (!xaxis.containsKey(p.x)) {
				xaxis.put(p.x, new ArrayList<Point>());
			}
			if (!yaxis.containsKey(p.y)) {
				yaxis.put(p.y, new ArrayList<Point>());
			}
			xaxis.get(p.x).add(p);
			yaxis.get(p.y).add(p);
		}
		s.close();

		Long[] xvals = new Long[0];
		xvals = xaxis.keySet().toArray(xvals);
		Long[] yvals = new Long[0];
		yvals = yaxis.keySet().toArray(yvals);

		long[] u = new long[N];
		long[] d = new long[N];
		long[] l = new long[N];
		long[] r = new long[N];

		for (int i = 0; i < xvals.length; i++) {
			long x = xvals[i];
			List<Point> line = xaxis.get(x);
			Collections.sort(line, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.y > o2.y)
						return 1;
					if (o1.y < o2.y)
						return -1;
					return 0;
				}
			});
			int m = line.size();
			for (int j = 0; j < m; j++) {
				int idx = points.get(line.get(j));
				u[idx] = j;
				d[idx] = m - j - 1;
			}
		}

		for (int i = 0; i < yvals.length; i++) {
			long y = yvals[i];
			List<Point> line = yaxis.get(y);
			Collections.sort(line, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.x > o2.x)
						return 1;
					if (o1.x < o2.x)
						return -1;
					return 0;
				}
			});
			int m = line.size();
			for (int j = 0; j < m; j++) {
				int idx = points.get(line.get(j));
				l[idx] = j;
				r[idx] = m - j - 1;
			}
		}

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += u[i] * d[i] * l[i] * r[i] * 2;
		}
		System.out.println(sum);
	}

}