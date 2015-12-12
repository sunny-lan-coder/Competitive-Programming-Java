package classq;

import java.util.Scanner;

public class Stairs {

	public static long nmod(long n, long d) {
		while (n >= d)
			n -= d;
		return n;
	}

	public static void main(String[] args) {
		int possibleIncrementsCount = 3;
		int[] possibleIncrements = { 1, 2, 3 };
		int x;
		{
			Scanner s = new Scanner(System.in);
			x = s.nextInt();
			s.close();
		}
		int n = x + 1;
		long[] counts = new long[n];
		counts[0] = 1;

		outer: for (int currentStair = 0; currentStair <= x; currentStair++) {
			for (int incrementIndex = 0; incrementIndex < possibleIncrementsCount; incrementIndex++) {
				int increment = possibleIncrements[incrementIndex];
				int newStair = increment + currentStair;
				if (newStair > x)
					continue outer;

				counts[newStair] += counts[currentStair];
				// counts[newStair] = nmod(counts[newStair], 100000000000l);

			}
			System.out.printf("counts[%d] = %d;\n", currentStair, counts[currentStair]);

		}

		System.out.println(counts[x]);
	}

}
