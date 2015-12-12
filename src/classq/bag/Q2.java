package classq.bag;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("x:");
		int x = s.nextInt();
		System.out.print("n:");
		int n = s.nextInt();
		int[] set = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("s[" + i + "]:");
			set[i] = s.nextInt();
		}
		s.close();

		System.out.println(DynamicSubset.solve2(set, x));

		int lim = 2 << n - 1;
		for (int i = 0; i < lim; i++) {
			int tmp = i;
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((tmp & 1) == 1) {
					sum += set[j];
				}
				tmp = tmp >> 1;
			}
			if (sum == x) {
				System.out.println(true);
				return;
			}
		}
	}

}
