package algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AStar {

	static long enc(long ori, int x, int y, int v) {
		return (ori & ~(15 << 4 * (x * 4 + y))) | (v << 4 * (x * 4 + y));
	}

	static int dec(long ori, int x, int y) {
		return (int) ((ori >> 4 * (x * 4 + y)) & 15);
	}

	static int[][] dst;

	static int cost(long a) {
		int cost = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (dec(a, x, y) != dst[x][y])
					cost++;
			}
		}
		return cost;
	}

	static long swap(long v, int x1, int y1, int x2, int y2) {
		int tmp = dec(v, x1, y1);
		v = enc(v, x1, y1, dec(v, x2, y2));
		return enc(v, x2, y2, tmp);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long st = 0;
		long dst1 = 0;
		dst = new int[4][4];
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++) {
				dst[x][y] = s.nextInt();
				dst1 = enc(st, x, y, dst[x][y]);
			}

		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				st = enc(st, x, y, s.nextInt());

		s.close();

		HashSet<Long> visited = new HashSet<>();

		PriorityQueue<Long> Q = new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return Long.compare(cost(o1), cost(o2));
			}
		});
		Q.add(st);

		while (!Q.isEmpty()) {
			long v = Q.remove();

			if (visited.contains(v))
				continue;
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++)
					System.out.print(dec(v, x, y) + " ");
				System.out.println();
			}
			if (v == dst1) {
				System.out.println("ye");
				return;
			}
			visited.add(v);
			for (int x = 0; x < 4; x++)
				for (int y = 0; y < 4; y++)
					if (dec(v, x, y) == 0) {
						if (x < 3)
							Q.add(swap(v, x, y, x + 1, y));
						if (x > 0)
							Q.add(swap(v, x, y, x - 1, y));
						if (y < 3)
							Q.add(swap(v, x, y, x, y + 1));
						if (y > 0)
							Q.add(swap(v, x, y, x, y - 1));
						break;
					}

		}
		System.out.println("no");
	}
}
