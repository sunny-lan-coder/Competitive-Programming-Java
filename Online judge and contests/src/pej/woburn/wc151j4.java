package pej.woburn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class wc151j4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long emin = s.nextLong();
		long tbase = s.nextLong();
		long hbase = s.nextLong();
		long fbase = s.nextLong();
		int N = s.nextInt();
		long[] e = new long[N];
		long[] t = new long[N];
		long[] h = new long[N];
		long[] f = new long[N];

		for (int i = 0; i < N; i++) {
			e[i] = s.nextLong();
			t[i] = s.nextLong();
			h[i] = s.nextLong();
			f[i] = s.nextLong();
		}

		int lim = 1 << N;

		long min = Long.MAX_VALUE;

		for (int choose = 0; choose < lim; choose++) {
			int tmp = choose;
			long tsum = tbase;
			long esum = 0;
			long fsum = fbase;

			// System.out.print(Integer.toBinaryString(choose));

			ArrayList<Long> costs = new ArrayList<>();
			costs.add(hbase);

			for (int i = 0; i < N; i++) {
				if ((tmp & 1) == 1) {
					// System.out.print("+" + e[i]);
					tsum += t[i];
					fsum = Math.max(0, fsum - f[i]);
					esum += e[i];
					costs.add(h[i]);
				}

				tmp = tmp >> 1;
			}

			Collections.sort(costs);

			// System.out.println("=" + esum);

			if (esum >= emin) {
				if (tsum + fsum + costs.get(costs.size() - 1) < min) {
					min = tsum + fsum + costs.get((int) (costs.size() - costs.get(costs.size() - 1)));
				}
			}
		}

		System.out.println(min);

		s.close();
	}

}
