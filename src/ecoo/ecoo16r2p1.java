package ecoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ecoo16r2p1 {

	static long mod = 422337197323l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			String s = br.readLine();
			int n = s.length();
			long fwdHash = 0;
			long bkHash = 0;
			long pow = 1;
			int lastIdx = 0;
			int max = 0;
			outer: for (int i = 1; i <= n; i++) {
				int ch = (s.charAt(i - 1) - 'a');
				fwdHash = (fwdHash + pow * ch) % mod;
				bkHash = (bkHash * 26 + ch) % mod;
				pow = pow * 26 % mod;
				if (fwdHash == bkHash) {
					for (int j = lastIdx; j < i; j++) {
						if (s.charAt(j) != s.charAt(i - j - 1))
							continue outer;
					}
					lastIdx = i;
				}
			}
			s = new StringBuffer(s).reverse().toString();
			fwdHash = 0;
			bkHash = 0;
			pow = 1;
			max = Math.max(max, lastIdx);
			lastIdx = 0;
			outer: for (int i = 1; i <= n; i++) {
				int ch = (s.charAt(i - 1) - 'a');
				fwdHash = (fwdHash + pow * ch) % mod;
				bkHash = (bkHash * 26 + ch) % mod;
				pow = pow * 26 % mod;
				if (fwdHash == bkHash) {
					for (int j = lastIdx; j < i; j++) {
						if (s.charAt(j) != s.charAt(i - j - 1))
							continue outer;
					}
					lastIdx = i;
				}
			}
			max = Math.max(max, lastIdx);

			System.out.println(n - max);
		}
		br.close();
	}

}
