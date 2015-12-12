package poj;

import java.util.ArrayList;
import java.util.Scanner;

public class P1094 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			int n = s.nextInt();
			ArrayList<String> lettermap = new ArrayList<String>();
			int m = s.nextInt();
			if (n == 0 && m == 0)
				break;
			boolean[][] adjmatrix = new boolean[n][n];
			int[] sum = new int[n];
			for (int relationI = 0; relationI < m; relationI++) {
				String relation = s.next();
				String[] nums = relation.split("<");
				if (!lettermap.contains(nums[0])) {
					lettermap.add(nums[0]);
				}
				int from = lettermap.indexOf(nums[0]);
				if (!lettermap.contains(nums[1])) {
					lettermap.add(nums[1]);
				}
				int to = lettermap.indexOf(nums[1]);
				if (!adjmatrix[from][to]) {
					adjmatrix[from][to] = true;
					sum[to]++;
				}
			}
			if (lettermap.size() != n) {
				System.out.println("Sorted sequence cannot be determined.");
				continue;
			}
			// for (int i = 0; i < n; i++) {
			// System.out.print(lettermap.get(i) + " ");
			// }
			// /System.out.println();
			// print(adjmatrix);
			// for (int i = 0; i < n; i++) {
			// System.out.println(i + ":" + lettermap.get(i) + ":" + sum[i]);
			// }
			int rcount = -1;
			ArrayList<String> stuff = new ArrayList<String>();
			for (int i = 0; i < n; i++) {

				if (sum[i] == 0) {
					// System.out.println();
					// print(adjmatrix);
					stuff.add(lettermap.get(i));
					if (stuff.size() == n) {
						break;
					}
					sum[i] = -1;
					for (int j = 0; j < n; j++) {
						if (sum[j] != -1) {

							if (adjmatrix[i][j]) {
								// System.out.println("setting " +
								// lettermap.get(i)
								// + "<" + lettermap.get(j));
								rcount++;
								adjmatrix[i][j] = false;
								sum[j]--;
							}
						}
					}

					i = -1;

				}
			}

			int count = 0;
			for (int i = 0; i < n - 1; i++) {
				if (sum[i] != -1) {
					count++;
				}
			}
			if (sum[n - 1] > 1) {
				count++;
			}

			if (count != 0) {
				System.out.println("Inconsistency found after " + count
						+ " relations.");
				continue;
			}

			// print(adjmatrix);
			// for (int k = 0; k < n; k++) {
			// System.out.println(k + ":" + lettermap.get(k) + ":"
			// + sum[k]);
			// }

			System.out.print("Sorted sequence determined after " + rcount
					+ " relations: ");

			for (String q : stuff) {
				System.out.print(q);
			}
			System.out.println(".");
		}
		s.close();
	}

	public static void print(boolean[][] m) {
		for (boolean[] row : m) {
			for (boolean val : row) {
				if (val) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}
