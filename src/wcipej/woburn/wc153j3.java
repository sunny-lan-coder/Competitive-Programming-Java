package wcipej.woburn;

import java.util.Scanner;

public class wc153j3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		long Q = s.nextLong();
		long weak2 = 0;
		long min = 0;
		for (long i = 0; i < N; i++) {
			long F = s.nextLong();
			long M = s.nextLong();
			boolean weak = false;
			boolean strong = false;
			for (long j = 0; j < M; j++) {
				long A = s.nextLong();
				long B = s.nextLong();

//				long lowmult = (long) Math.ceil(A / F);
				for (long k = A; k <= B; k++) {
					if (A % F == 0 && A >= F) {
						weak = true;
					} else {
						strong = true;
					}
				}
			}
			if (weak)
				weak2++;
			if (!strong)
				min++;
		}
		for (int i = 0; i < Q; i++) {
			long t = s.nextLong();
			if (t <= weak2 && t >= min) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
		s.close();
	}

}
