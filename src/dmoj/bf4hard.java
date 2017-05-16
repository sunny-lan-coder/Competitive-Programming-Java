package dmoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf4hard {

	static long mod = 422337197323l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		long h1 = 0;
		long rolling = 0;
		int n = s.length();
		int m = t.length();
		long pow = 1;
		for (int i = m - 1; i >= 0; i--) {
			h1 = (h1 + pow * (t.charAt(i) - 'a')) % mod;
			rolling = (rolling + pow * (s.charAt(i) - 'a')) % mod;
			pow = pow * 26 % mod;
		}
		for (int i = 0; i < n - m; i++) {
			if (rolling == h1)
				if (s.substring(i, i + m).equals(t)) {
					System.out.println(i);
					return;
				}
			
			rolling = (rolling * 26 + (s.charAt(i + m) - 'a')) % mod;
			rolling -= ((s.charAt(i) - 'a') * pow) % mod;
			if (rolling < 0)
				rolling = (rolling + mod) % mod;
		}
		System.out.println(-1);
	}

}
