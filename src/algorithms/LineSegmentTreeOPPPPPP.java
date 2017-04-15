package algorithms;

import java.util.Scanner;

//op version of line segment tree
public class LineSegmentTreeOPPPPPP {
	static int[] tree;
	static int n;

	static void init() {
		tree = new int[n * 2];
	}

	static void construct(int[] dat) {
		for (int i = 0; i < n; i++)
			tree[i + n] = dat[i];
		for (int i = n - 1; i > 0; --i)
			tree[i] = tree[i << 1] + tree[i << 1 | 1];
	}

	static void update(int p, int val) {
		for (tree[p += n] = val; p > 1; p >>= 1)
			tree[p >> 1] = tree[p] + tree[p ^ 1];
	}

	static int query(int l, int r) {
		int res = 0;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if ((l & 1) == 1)
				res += tree[l++];
			if ((r & 1) == 1)
				res += tree[--r];
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int[] dat = new int[n];
		for (int i = 0; i < n; i++) {
			dat[i] = i;
		}
		init();
		construct(dat);
		while (true) {
			String op = s.next();
			if (op.equals("Q")) {
				int l = s.nextInt();
				int r = s.nextInt();
				System.out.println(query(l, r));
			} else if (op.equals("M")) {
				int p = s.nextInt();
				int val = s.nextInt();
				update(p, val);
			} else if (op.equals("L")) {
				for (int i = 0; i < n; i++) {
					System.out.print(query(i, i + 1) + " ");
				}
				System.out.println();
			}
		}
	}

}
