package ccc.prac.y2010;

import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			int n = s.nextInt();
			if (n == 0)
				break;
			int[] dat = new int[n];
			for (int i = 0; i < n; i++) {
				dat[i] = s.nextInt();
			}
			int k = n - 1;
			int[] delta = new int[k];
			for (int i = 0; i < k; i++) {
				delta[i] = dat[i + 1] - dat[i];
			}
			outer: for (int cycle = 1; cycle <= k; cycle++) {
				for (int i = 0; i < k; i++) {
					if (delta[i] != delta[i % cycle])
						continue outer;
				}
				System.out.println(cycle);
				break;
			}
		}
		s.close();
	}

}
