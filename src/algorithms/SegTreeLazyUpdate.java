package algorithms;

import java.util.Scanner;

public class SegTreeLazyUpdate {
	static int[] t;
	static int n;
	static int h;
	static int[] d;

	static void calc(int p, int k) {
		if (d[p] == 0)
			t[p] = t[p << 1] + t[p << 1 | 1];
		else
			t[p] = d[p] * k;
	}

	static void apply(int p, int value, int k) {
		t[p] = value * k;
		if (p < n)
			d[p] = value;
	}

	static void build(int l, int r) {
		int k = 2;
		for (l += n, r += n - 1; l > 1; k <<= 1) {
			l >>= 1;
			r >>= 1;
			for (int i = r; i >= l; --i)
				calc(i, k);
		}
	}

	static void push(int l, int r) {
		int s = h, k = 1 << (h - 1);
		for (l += n, r += n - 1; s > 0; --s, k >>= 1)
			for (int i = l >> s; i <= r >> s; ++i)
				if (d[i] != 0) {
					apply(i << 1, d[i], k);
					apply(i << 1 | 1, d[i], k);
					d[i] = 0;
				}
	}

	static void init() {
		t = new int[n * 2];
		d = new int[n];
		h = mostSignificantBit(n);
	}

	static void construct(int[] dat) {
		for (int i = 0; i < n; i++)
			t[i + n] = dat[i];
		for (int i = n - 1; i > 0; --i)
			t[i] = t[i << 1] + t[i << 1 | 1];
	}

	static void update(int p, int val) {
		for (t[p += n] = val; p > 1; p >>= 1)
			t[p >> 1] = t[p] + t[p ^ 1];
	}

	static int query(int l, int r) {
		push(l, l + 1);
		push(r - 1, r);
		int res = 0;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if ((l & 1) == 1)
				res += t[l++];
			if ((r & 1) == 1)
				res += t[--r];
		}
		return res;
	}

	static void updateRange(int l, int r, int value) {
		if (value == 0)
			return;
		push(l, l + 1);
		push(r - 1, r);
		boolean cl = false, cr = false;
		int k = 1;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1, k <<= 1) {
			if (cl)
				calc(l - 1, k);
			if (cr)
				calc(r, k);
			if ((l & 1) == 1) {
				apply(l++, value, k);
				cl = true;
			}
			if ((r & 1) == 1) {
				apply(--r, value, k);
				cr = true;
			}
		}
		for (--l; r > 0; l >>= 1, r >>= 1, k <<= 1) {
			if (cl)
				calc(l, k);
			if (cr && (!cl || l != r))
				calc(r, k);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// int m = s.nextInt();// useless thing
		n = s.nextInt();
		int q = s.nextInt();
		int[] dat = new int[n];
		for (int i = 0; i < n; i++)
			dat[i] = s.nextInt();
		init();
		construct(dat);
		for (int i = 0; i < q; i++) {
			int op = s.nextInt();
			int l = s.nextInt()-1;
			int r = s.nextInt();
			if (op == 1) {
				int x = s.nextInt();
				updateRange(l, r, x);
			} else {
				System.out.println(query(l, r));
			}
		}
		s.close();
	}

	static int mostSignificantBit(int myInt) {
		for (int bitIndex = 31; bitIndex >= 0; bitIndex--)
			if (((myInt >> bitIndex) & 1) == 1)
				return bitIndex;

		return -1;
	}

}
