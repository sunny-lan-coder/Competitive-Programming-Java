 package cco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;

public class cco17p6 {
	static int n, m;
	static int[][] map;

	static ArrayList<String> ops;

	static void rs(int r, int k) {
		r++;
		if (k < 0)
			ops.add("1 " + r + " " + (m + k));
		else
			ops.add("1 " + r + " " + k);
	}

	static void ds(int c, int k) {
		c++;
		if (k < 0)
			ops.add("2 " + c + " " + (n + k));
		else
			ops.add("2 " + c + " " + k);
	}

	// r1,c1 - center of 3 points
	// r2 - row that intersects with c1
	// c1 - col that intersects with r1
	// rotates: row into center, center into col, col into row
	static void lf(int r1, int c1, int c2, int r2) {
		r1 = (r1 + n) % n;
		c1 = (c1 + m) % m;
		c2 = (c2 + m) % m;
		r2 = (r2 + n) % n;

		rs(r1, c1 - c2);
		ds(c1, r1 - r2);
		rs(r1, c2 - c1);
		ds(c1, r2 - r1);

		int tmp = map[r1][c1];
		map[r1][c1] = map[r1][c2];
		map[r1][c2] = map[r2][c1];
		map[r2][c1] = tmp;
	}

	// rotates in reverse: col into center, center into row, row into col
	static void lb(int r1, int c1, int c2, int r2) {
		r1 = (r1 + n) % n;
		c1 = (c1 + m) % m;
		c2 = (c2 + m) % m;
		r2 = (r2 + n) % n;

		ds(c1, r1 - r2);
		rs(r1, c1 - c2);
		ds(c1, r2 - r1);
		rs(r1, c2 - c1);

		int tmp = map[r1][c1];
		map[r1][c1] = map[r2][c1];
		map[r2][c1] = map[r1][c2];
		map[r1][c2] = tmp;
	}

	static void llf(int c) {
		lb(n - 1, c, c - 1, n - 2);
		lf(n - 1, c, c + 1, n - 2);
	}

	static void llb(int c) {
		lb(n - 1, c, c + 1, n - 2);
		lf(n - 1, c, c - 1, n - 2);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = s.nextInt();
		m = s.nextInt();
		ops = new ArrayList<>();
		map = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = s.nextInt();

		for (int dr = 0; dr < n - 1; dr++)
			outer: for (int dc = 0; dc < m; dc++) {
				int val = dr * m + dc;

				if (map[dr][dc] == val)
					continue;

				for (int sc = dc + 1; sc < m; sc++)
					if (map[dr][sc] == val) {
						lb(dr, sc, dc, dr + 1);
						continue outer;
					}

				for (int sr = dr + 1; sr < n; sr++)
					for (int sc = 0; sc < m; sc++)
						if (map[sr][sc] == val) {
							if (sc == dc)
								lf(sr, dc, (sc + 1) % m, dr);
							else
								lb(sr, dc, sc, dr);
							continue outer;
						}
			}

		outer: for (int dc = 0; dc < m - 2; dc++) {
			int val = (n - 1) * m + dc;
			if (map[n - 1][dc] == val)
				continue;

			for (int sc = dc + 1; sc < m; sc++)
				if (map[n - 1][sc] == val) {
					if (sc == m - 1) {
						llf(m - 2);
						sc--;
					}
					for (int i = sc; i > dc; i--)
						llf(i);
					continue outer;
				}
		}
		if (map[n - 1][m - 2] == (n - 1) * m + (m - 1)) {
			for (int i = m - 2; i != 0; i = (i - 2 + m) % m) {
				llb((i - 1 + m) % m);
			}
			rs(n - 1, -1);
		}

		System.out.println(ops.size());
		for (String l : ops)
			System.out.println(l);
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
}