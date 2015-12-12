package poj;

import java.util.Scanner;

public class P1502 {

	static final int infinity = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] adjmatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			adjmatrix[i][i] = 0;
			for (int j = 0; j < i; j++) {
				String in = s.next();
				if (in.equals("x"))
					adjmatrix[i][j] = infinity;
				else
					adjmatrix[i][j] = Integer.parseInt(in);
				adjmatrix[j][i] = adjmatrix[i][j];
			}
			s.nextLine();
		}
		s.close();

		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print(adjmatrix[i][j]);
		// for (int k = Integer.toString(adjmatrix[i][j]).length(); k < 4; k++)
		// {
		// System.out.print(" ");
		// }
		// }
		// System.out.println();
		// }

		boolean[] visited = new boolean[n];
		int[] pointers = new int[n];
		int[] du = new int[n];
		du[0] = 0;
		for (int i = 1; i < n; i++) {
			du[i] = infinity;
		}

		while (true) {
			int minNode = infinity;
			int minValue = infinity;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					if (sl(du[i], minValue)) {
						minNode = i;
						minValue = du[i];
					}
				}
			}
			if (minNode == infinity)
				break;
			//System.out.println("select node " + minNode + ", du=" + minValue);

			visited[minNode] = true;

			for (int j = 0; j < n; j++) {
				if (!visited[j] && adjmatrix[minNode][j] != infinity) {
					//System.out.print("	select subnode " + j + ", du=" + du[j]);
					if (sl(minValue + adjmatrix[minNode][j], du[j])) {
						pointers[j] = minNode;
						du[j] = minValue + adjmatrix[minNode][j];
						//System.out.print(", update value to " + du[j]);
					}
					//System.out.println();
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
