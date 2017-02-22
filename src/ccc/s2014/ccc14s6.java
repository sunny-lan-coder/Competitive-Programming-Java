package ccc.s2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc14s6 {
	static class T2 {
		public final int a, b;

		public T2(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s;
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			x[i] = Integer.parseInt(s[0]);
			y[i] = Integer.parseInt(s[1]);
		}
		br.close();
		
	}

}
