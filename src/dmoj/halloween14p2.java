package dmoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;

public class halloween14p2 {
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

		public long nextLong() {
			loadBuffer();
			final long radix = 10;
			long result = 0;
			int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
			for (checkValidNumber(pos > i); i < pos; i++) {
				long digit = buffer[i] - '0';
				checkValidNumber(0 <= digit && digit <= 9);
				result = result * radix + digit;
			}
			return buffer[0] == '-' ? -result : result;
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

	static int lower_bound(long[] arr, long key, int hi, int lo) {
		int mid = (lo + hi) / 2;
		while (true) {
			if (arr[mid] >= key) {
				hi = mid - 1;
				if (hi < lo)
					return mid;
			} else {
				lo = mid + 1;
				if (hi < lo)
					return mid + 1;
			}
			mid = (lo + hi) / 2;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = s.nextInt();
		long w = s.nextLong();
		int curr = 0;
		long[] dp = new long[n + 1];
		long[] cprefix = new long[n + 1];
		long[] wprefix = new long[n + 1];
		for (int i = 0; i < n; i++) {
			if (s.next().charAt(0) == 'A') {
				wprefix[curr + 1] = wprefix[curr] + s.nextLong();
				cprefix[curr + 1] = cprefix[curr] + s.nextLong();
				dp[curr] = Math.max(curr > 0 ? dp[curr - 1] : 0,
						cprefix[curr + 1] - cprefix[lower_bound(wprefix, wprefix[curr + 1] - w, curr, 0)]);
				System.out.println(dp[curr]);
				curr++;
			} else {
				wprefix[curr] = 0;
				cprefix[curr] = 0;
				curr--;
				dp[curr] = 0;
			}
		}
	}

}
