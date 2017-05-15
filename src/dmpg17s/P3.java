package dmpg17s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3 {
	static long mod = 1000000007l;

	static long powfast(long a, long b) {
		long res = 1;
		long curr = a;
		while (b > 0) {
			if ((b & 1) == 1) {
				res *= curr;
				res %= mod;
			}
			curr *= curr;
			curr %= mod;
			b>>=1;
		}
		return res;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		long k = Long.parseLong(temp[0]);
		long m = Long.parseLong(temp[1]);
		long s = (long) Math.pow(2, k);
		long b = 0;
		String in;
		for (int i = 0; i < s; i++) {
			in = br.readLine();
			for (int j = 0; j < 2 * s; j += 2) {
				if (in.charAt(j) == '#') {
					b++;
				}
			}
		}

		long powpos = 2 * m;
		long res = 2;
		for (int i = 0; i < powpos; i++) {
			res = res * res % mod;
		}
		res -= 1;
		System.out.println(powfast(res, b));
		br.close();
	}

}
