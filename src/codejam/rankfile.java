package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class rankfile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream("B-small-practice.in"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			int p = 2 * N - 1;
			int[][] slips = new int[p][N];
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < N; j++) {
					slips[i][j] = s.nextInt();
				}
			}
			Arrays.sort(slips, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return rankfile.compare(N, o1, o2);
				}
			});
			boolean[] rowsVisited = new boolean[N];
			boolean[] colsVisited = new boolean[N];
			int[][] A = new int[N][N];
			loop: for (int i = 0; i < p; i++) {

				// go through each row
				outer: for (int j = 0; j < N; j++) {

					if (!rowsVisited[j]) {
						for (int l = 0; l < N; l++) {
							if (slips[i][l] != A[j][l] && A[j][l] != 0) {
								continue outer;
							}
						}
						rowsVisited[j] = true;
						for (int l = 0; l < N; l++) {
							A[j][l] = slips[i][l];
						}

						continue loop;
					}
					for (int k = 0; k < N; k++) {
						if (slips[i][k] <= A[j][k]) {
							break outer;
						}
					}
				}
				// go through each col
				outer: for (int j = 0; j < N; j++) {

					if (!colsVisited[j]) {
						for (int l = 0; l < N; l++) {
							if (slips[i][l] != A[l][j] && A[l][j] != 0) {
								continue outer;
							}
						}
						colsVisited[j] = true;
						for (int l = 0; l < N; l++) {
							A[l][j] = slips[i][l];
						}

						continue loop;
					}
					for (int k = 0; k < N; k++) {
						if (slips[i][k] <= A[k][j]) {
							break outer;
						}
					}
				}
			}
System.out.print("Case #"+t+": ");
			for (int i = 0; i < N; i++) {
				if (!rowsVisited[i]) {
					System.out.print(A[i][0]);
					for (int j = 1; j < N; j++) {
						System.out.print(" "+A[i][j]);
					}
				}
				if (!colsVisited[i]) {
					System.out.print(A[0][i]);
					for (int j = 1; j < N; j++) {
						System.out.print(" "+A[j][i]);
					}
				}
			}
			System.out.println();

		}
		s.close();
	}

	static int compare(int N, int[] o1, int[] o2) {
		for (int i = 0; i < N; i++) {
			if (o1[i] > o2[i])
				return 1;
			if (o1[i] < o2[i])
				return -1;
		}
		return 0;
	}

}
