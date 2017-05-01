package dmoj.tle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tle16c8p5 {

	static ArrayList<ArrayList<Integer>> adjlist;
	static boolean[] taken;
	static int n, m;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		adjlist = new ArrayList<>(n);
		m = s.nextInt();
		taken = new boolean[m];
		for (int i = 0; i < n; i++)
			adjlist.add(new ArrayList<>());
		int t = s.nextInt();
		for (int j = 0; j < t; j++) {
			adjlist.get(n - 1).add(s.nextInt() - 1);
		}
		for (int i = 0; i < n - 1; i++) {

			t = s.nextInt();
			for (int j = 0; j < t; j++) {
				adjlist.get(i).add(s.nextInt() - 1);
			}
		}

		s.close();
		maxMatch(0, 0);

		System.out.println(min);
	}

	// static int bs = -1;
	static int min = Integer.MAX_VALUE;

	static void maxMatch(int i, int matched) {
		// System.out.println(i);
		if (i == n - 1) {
			int cnt = 0;
			for (int adj:adjlist.get(i)) {
				if (!taken[adj]) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);

			return;
		}
		for (int adj : adjlist.get(i)) {
			if (taken[adj])
				continue;

			taken[adj] = true;
			maxMatch(i + 1, matched + 1);
			taken[adj] = false;
		}
	}

}
