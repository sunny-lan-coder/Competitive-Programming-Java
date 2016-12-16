package ccc.s2008;

import java.util.Scanner;

public class ccc08s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		while ((n = s.nextInt()) != 0) {
			int sum = 0;
			for (int x = -n; x <= n; x++) {
				int y = (int) Math.sqrt(n * n - x * x);
				sum += y * 2 + 1;
			}
			System.out.println(sum);
		}
		s.close();
	}

}
