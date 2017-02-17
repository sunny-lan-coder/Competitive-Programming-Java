package ccc.s2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc13s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int w1 = 0;
		int w2 = 0;
		int w3 = 0;
		int w4 = 0;

		for (int i = 0; i < n; i++) {
			int total = 0;
			w4 = w3;
			w3 = w2;
			w2 = w1;
			w1 = Integer.parseInt(br.readLine());
			total += w1;
			total += w2;
			total += w3;
			total += w4;
			if (total > w) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(n);
	}

}
