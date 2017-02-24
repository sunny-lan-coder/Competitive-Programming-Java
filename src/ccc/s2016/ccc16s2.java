package ccc.s2016;

import java.util.Arrays;
import java.util.Scanner;

public class ccc16s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(a);
		Arrays.sort(b);
		int sum = 0;
		if (q == 1) {
			for (int i = 0; i < n; i++) {
				sum += Math.max(a[i], b[i]);
			}
		} else {
			for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
				sum += Math.max(a[i], b[j]);
			}
		}

		System.out.println(sum);
	}
}
