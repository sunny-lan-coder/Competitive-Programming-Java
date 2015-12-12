package dmoj.contest.y2015.december;

import java.util.Scanner;

public class P2_c {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long[] derp = new long[N];
		long total = 0;
		for (int i = 0; i < N; i++) {
			derp[i] = s.nextLong();
			total += derp[i];
		}
		if (total % N != 0) {
			System.out.println("Impossible");
		} else {
			long average = total / N;
			long totalDeviation = 0;
			for (int i = 0; i < N; i++) {
				if (derp[i] > average) {
					totalDeviation += derp[i] - average;
				}
			}
			System.out.println(totalDeviation);
		}
		s.close();
	}

}
