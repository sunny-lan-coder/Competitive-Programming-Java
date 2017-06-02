package dmoj.dmopc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;

public class dmopc15c1p6 {
	static long[] t;
	static long[] d;
	static int n;
	static int h;

	static void init() {
		t = new long[n * 2];
		d=new long[n];
		h=mostSignificantBit(n);
	}

	static void construct(long[] dat) {
		for (int i = 0; i < n; i++)
			t[i + n] = dat[i];
		for (int i = n - 1; i > 0; --i)
			t[i] = t[i << 1] + t[i << 1 | 1];
	}

	static void apply(int p, long value) {
		  t[p] += value;
		  if (p < n) d[p] += value;
		}

	static	void build(int p) {
		  while (p > 1) {p >>= 1; t[p] = t[p<<1]+ t[p<<1|1] + d[p];}
		}

	static void push(int p) {
		  for (int s = h; s > 0; --s) {
		    int i = p >> s;
		    if (d[i] != 0) {
		      apply(i<<1, d[i]);
		      apply(i<<1|1, d[i]);
		      d[i] = 0;
		    }
		  }
		}

	static	void inc(int l, int r, int value) {
		  l += n; r += n;
		  int l0 = l, r0 = r;
		  for (; l < r; l >>= 1, r >>= 1) {
		    if ((l&1)==1) apply(l++, value);
		    if ((r&1)==1) apply(--r, value);
		  }
		  build(l0);
		  build(r0 - 1);
		}

		static long query(int l, int r) {
		  l += n; r += n;
		  push(l);
		  push(r - 1);
		  long res = 0;
		  for (; l < r; l >>= 1, r >>= 1) {
		    if ((l&1)==1) res = res+ t[l++];
		    if ((r&1)==1) res = t[--r]+ res;
		  }
		  return res;
		}

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int m = s.nextInt();// useless thing
		n = s.nextInt();
		int q = s.nextInt();
		long[] dat = new long[n];
		for (int i = 0; i < n; i++)
			dat[i] = s.nextInt();
		init();
		construct(dat);
		for (int i = 0; i < q; i++) {
			int op = s.nextInt();
			int l = s.nextInt() - 1;
			int r = s.nextInt();
			if (op == 1) {
				int x = s.nextInt();
				inc(l, r, x);
				System.out.print("after update: ");
				for(int j=0;j<n;j++)
					System.out.print(query(j, j+1)+" ");
				System.out.println();
			} else {
				System.out.println(query(l, r) % m);
			}
		}
	}
	
	
	static class Scanner {
		private char[] buffer = new char[1 << 4];
		private int pos = 1;

		private BufferedReader reader;

		public Scanner(BufferedReader reader) {
			this.reader = reader;
		}

		public boolean hasNext() {
			return pos > 0;
		}

		private void loadBuffer() {
			pos = 0;
			try {
				for (int i; (i = reader.read()) != -1;) {
					char c = (char) i;
					if (c != ' ' && c != '\n' && c != '\t' && c != '\r' && c != '\f') {
						if (pos == buffer.length)
							buffer = Arrays.copyOf(buffer, 2 * pos);
						buffer[pos++] = c;
					} else if (pos != 0)
						break;
				}
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}

		public String current() {
			return String.copyValueOf(buffer, 0, pos);
		}

		public String next() {
			loadBuffer();
			return current();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}

		public int nextInt() {
			loadBuffer();
			final int radix = 10;
			int result = 0;
			int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
			for (checkValidNumber(pos > i); i < pos; i++) {
				int digit = buffer[i] - '0';
				checkValidNumber(0 <= digit && digit <= 9);
				result = result * radix + digit;
			}
			return buffer[0] == '-' ? -result : result;
		}

		private void checkValidNumber(boolean condition) {
			if (!condition)
				throw new NumberFormatException(current());
		}
	}

	static int mostSignificantBit(int myInt) {
		for (int bitIndex = 31; bitIndex >= 0; bitIndex--)
			if (((myInt >> bitIndex) & 1) == 1)
				return bitIndex;

		return -1;
	}
}
