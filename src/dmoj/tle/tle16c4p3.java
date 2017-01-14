package dmoj.tle;

import java.util.Scanner;

public class tle16c4p3 {

	static final boolean[][] target = { { false, true, true, false, true, false, false, false },
			{ true, false, false, true, false, true, false, false },
			{ true, false, false, true, false, false, false, true },
			{ false, true, true, false, false, false, true, false },
			{ true, false, false, false, false, true, false, true },
			{ false, true, false, false, true, false, true, false },
			{ false, false, false, true, false, true, false, true },
			{ false, false, true, false, true, false, true, false } };
	static boolean[][] adj;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		adj = new boolean[8][8];
		for (int i = 0; i < n; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			adj[u][v] = true;
			adj[v][u] = true;
		}
		s.close();

		if(recurse(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, 0))
			System.out.println("Ja");
		else
			System.out.println("Nej");
	}

	static boolean recurse(int[] arr, int k) {
		boolean total = false;
		if (k == 7) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (target[i][j]) {
						if (!adj[arr[i]][arr[j]]) {
							return false;
						}
					}
				}
			}
			return true;
		}
		int tmp = arr[k];
		for (int i = k; i < 8; i++) {
			arr[k] = arr[i];
			arr[i] = tmp;
			total |= recurse(arr, k + 1);
			arr[i] = arr[k];
			arr[k] = tmp;
		}

		return total;
	}

}
