package algorithms;

import java.util.Scanner;

public class Shoelace {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = s.nextInt();
			y[i] = s.nextInt();
		}
		s.close();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += x[i] * (y[(i + 1) % n] - y[(i - 1 + n) % n]);
		}
		System.out.println(Math.abs(sum) / 2);
	}

}
