package dmoj.tle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tle16c3p2 {

	static long[] a;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int p = Integer.parseInt(tmp[0]);
		n = Integer.parseInt(tmp[1]);
		int v = Integer.parseInt(tmp[2]);
		int r = Integer.parseInt(tmp[3]);
		int[] x = new int[p];
		int[] y = new int[p];
		for (int i = 0; i < p; i++) {
			tmp = br.readLine().split(" ");
			int xi = Integer.parseInt(tmp[0]);
			int yi = Integer.parseInt(tmp[1]);
			x[i] = xi;
			y[i] = yi;
		}
		a = new long[n];
		for (int j = 0; j < n; j++) {
			int aj = Integer.parseInt(br.readLine());
			a[j] = aj;
		}
		br.close();

		int danger = 0;

		long fv = f(v);
		double r2 = r;

		for (int i = 0; i < p; i++) {

			if (x[i] < v) {
				int fx = f(x[i]);
				if (fx == y[i]) {
					// System.out.println(x[i] + ", " + y[i] + " hit");
					danger++;
					continue;
				}
			}

			long dx = Math.abs(x[i] - v);
			long dy = Math.abs(y[i] - fv);

			if (Math.sqrt(dx * dx + dy * dy) <= r2) {
				// System.out.println(x[i] + ", " + y[i] + " exploded");
				danger++;
			}
		}
		System.out.println(danger);
	}

	static int f(long x) {
		long res = 0;
		for (int i = 0; i < n; i++) {
			int exponent = n - i;
			res += a[i] * Math.pow(x, exponent);
		}
		return (int)res;
	}
}
