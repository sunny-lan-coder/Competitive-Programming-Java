package duwei;

import java.util.Scanner;

public class P1237 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextLong();
		}
		s.close();
		long[] min = new long[n];
		min[0] = 1;
		min[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				min[i] = min[i - 1] + 1;
			}
			if (a[i] < a[i - 1]) {
				min[i] = 1;
			}
			if (a[i] == a[i - 1]) {
				min[i] = min[i - 1];
			}
			
		}

		for (int i = n - 1; i > 0; i--) {
			if (a[i - 1] > a[i]) {
				min[i - 1] = Math.max(min[i] + 1, min[i - 1]);
			}
			if (a[i - 1] < a[i]) {
				min[i - 1] = Math.max(1, min[i - 1]);
			}
			if (a[i - 1] == a[i]) {
				min[i - 1] = Math.max(min[i], min[i - 1]);
				min[i] = min[i - 1];
			}
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += min[i];
		}
		System.out.println(sum);
	}

}
