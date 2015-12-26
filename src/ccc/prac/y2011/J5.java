package ccc.prac.y2011;

import java.util.Scanner;

public class J5 {

	static boolean[][] mat;

	static int N;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		mat = new boolean[N][N];
		for (int i = 0; i < N - 1; i++) {
			int j = s.nextInt() - 1;
			mat[j][i] = true;
		}

		// for (boolean[] row : mat) {
		// for (boolean val : row) {
		// if (val)
		// System.out.print("1 ");
		// else
		// System.out.print("0 ");
		// }
		// System.out.println();
		// }

		int lim = 1 << N;
		boolean[] sets = new boolean[lim];
		int count = 0;
		for (int ch = 0; ch < lim; ch++) {
			int remove = ch;

			if (get(remove, N - 1))
				continue;
			// System.out.println("test " + Integer.toBinaryString(remove));

			for (int i = 0; i < N; i++) {
				if (get(remove, i)) {
					remove |= traverse(i);
				}
			}

			// System.out.println("result " + Integer.toBinaryString(remove));

			if (!sets[remove]) {
				count++;
				sets[remove] = true;
				// System.out.println("yes");
			}
		}
		System.out.println(count);
		s.close();
	}

	static boolean get(int en, int idx) {
		return ((en >> idx) & 1) == 1;
	}

	static int set(int en, int idx, boolean val) {
		if (val) {
			en |= (1 << idx);
		} else {
			en &= ~(1 << idx);
		}
		return en;
	}

	static int traverse(int j) {
		int res = 0;
		res = set(res, j, true);

		// System.out.println("traverse " + Integer.toBinaryString(res));
		for (int i = 0; i < N; i++) {
			if (mat[j][i]) {
				res |= traverse(i);
			}
		}
		return res;
	}

}
