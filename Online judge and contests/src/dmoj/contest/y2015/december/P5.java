package dmoj.contest.y2015.december;

import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[] A = new int[N];
		int[] B = new int[M];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		for (int j = 0; j < M; j++) {
			B[j] = s.nextInt();
		}
		s.close();

		int total = 0;
		int limA = 1 << N;
		int limB = 1 << M;
		for (int i = 1; i < limA; i++) {
			// System.out.println(Integer.toBinaryString(i));

			int totalA = 0;
			int tmp = i;
			for (int k = 0; k < N; k++) {
				if ((tmp & 1) == 1) {
					totalA += A[k];
				}
				tmp = tmp >> 1;
			}

			for (int j = 1; j < limB; j++) {
				// System.out.println(" " + Integer.toBinaryString(j));
				int totalB = 0;
				tmp = j;
				for (int k = 0; k < M; k++) {
					if ((tmp & 1) == 1) {
						totalB += B[k];
					}
					tmp = tmp >> 1;
				}

				if (totalA == totalB) {
					// System.out.println(" yes");
					total++;
				}
			}
		}
		System.out.println(total);
	}

}
