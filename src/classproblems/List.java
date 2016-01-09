package classproblems;

import java.util.Arrays;
import java.util.Scanner;

public class List {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] snowballs = new int[N];
		int[] map = new int[100001];
		for (int i = 0; i < N; i++) {
			snowballs[i] = s.nextInt();
			map[snowballs[i]]++;
		}

		Arrays.sort(snowballs);

		int max = 0;
		for (int b1i = 0; b1i < N; b1i++) {
			for (int b2i = b1i + 1; b2i < N; b2i++) {
				int b1 = snowballs[b1i];
				int b2 = snowballs[b2i];
				int b3 = b2 + (b2 - b1);

				if (b3 < 100001) {
					int old1 = map[b1];
					int old2 = map[b2];
					int old3 = map[b3];

					map[b1]--;
					map[b2]--;

					if (map[b3] != 0) {
						max = Math.max(max, b1 + b2 + b3);
					}

					// clean up
					map[b1] = old1;
					map[b2] = old2;
					map[b3] = old3;
				}

			}
		}

		System.out.println(max);

		s.close();
	}

}
