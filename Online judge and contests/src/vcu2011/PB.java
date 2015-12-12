package vcu2011;

import java.util.Scanner;

public class PB {

	static final int infinity = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] adjmatrix = new int[119][119];
		for (int i = 0; i < 119; i++) {
			for (int j = 0; j < 119; j++) {
				adjmatrix[i][j] = infinity;
			}
		}

		for (int i = 0; i < n; i++) {
			int j = s.nextInt();
			int k = s.nextInt();
			int l = s.nextInt();
			adjmatrix[j][k] = l;
		}
		s.close();

		boolean[] visited = new boolean[119];
		int[] pointers = new int[119];
		int[] du = new int[119];
		for (int i = 1; i < 119; i++) {
			du[i] = infinity;
		}
		du[47] = 0;

		while (true) {
			int minNode = infinity;
			int minValue = infinity;
			for (int i = 0; i < 119; i++) {
				if (!visited[i]) {
					if (sl(du[i], minValue)) {
						minNode = i;
						minValue = du[i];
					}
				}
			}
			if (minNode == infinity)
				break;
			// System.out.println("select node " + minNode + ", du=" +
			// minValue);

			visited[minNode] = true;

			for (int j = 0; j < 119; j++) {
				if (!visited[j] && adjmatrix[minNode][j] != infinity) {
					// System.out.print(" select subnode " + j + ", du=" +
					// du[j]);
					if (sl(minValue + adjmatrix[minNode][j], du[j])) {
						pointers[j] = minNode;
						du[j] = minValue + adjmatrix[minNode][j];
						// System.out.print(", update value to " + du[j]);
					}
					// System.out.println();
				}
			}
		}
		int max = 0;
		for (int i : du) {
			if (i > max)
				max = i;
		}
		System.out.println(max);
	}

	static boolean sl(int a, int b) {
		if (a == infinity && b != infinity)
			return false;
		if (a != infinity && b == infinity)
			return true;
		if (a == infinity && b == infinity)
			return false;
		return a < b;
	}

}
