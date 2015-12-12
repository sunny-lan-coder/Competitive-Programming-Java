package poj;

import java.util.Arrays;
import java.util.Scanner;

public class P3122 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int testCase = 0; testCase < testCases; testCase++) {
			int N = s.nextInt();
			int F = s.nextInt();
			int[] ri = new int[N];
			for (int pie = 0; pie < N; pie++) {
				ri[pie] = s.nextInt();
			}
			int P = F + 1;
			Arrays.sort(ri);
			double[] pieSizes = new double[N];
			for (int i = 0; i < N; i++) {
				pieSizes[i] = Math.PI * ri[i] * ri[i];
			}
			double upper = pieSizes[N - 1];
			double lower = 0;
			double guess = 0;
			for (int iteration = 0; iteration < 150; iteration++) {
				guess = ((upper - lower) / 2) + lower;
			//	System.out.println("u=" + upper + ",l=" + lower + "m=" + guess);
				int possiblePies = 0;
				for (double pieSize : pieSizes) {
					possiblePies += Math.floor(pieSize / guess);
				}
				
				if (possiblePies > P) {
					lower = guess;
				} else if (possiblePies < P) {
					upper = guess;
				} else if (possiblePies == P) {
					lower = guess;
				}
			}
			System.out.println(guess);
		}
		s.close();
	}

}
