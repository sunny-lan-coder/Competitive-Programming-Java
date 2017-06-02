package bssjudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bsspc17p9 {

	static int n;
	static ArrayList<ArrayList<Integer>> adj;
	static int[] r;

	static int f(int i) {
		int res = r[i];
		if (res != -1)
			return res;
		res = 0;

		for (int neigh : adj.get(i)) {
			res = Math.max(res, f(neigh) + 1);
		}

		r[i] = res;
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		adj = new ArrayList<ArrayList<Integer>>(n);
		r = new int[n];
		Integer[] c = new Integer[n];
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
			r[i] = -1;
			c[i] = i;
			for (int j = 0; j < n; j++)
				if (s.nextInt() == 1) {
					adj.get(i).add(j);
				}
		}
		s.close();
		for (int i = 0; i < n; i++)
			f(i);

		Arrays.sort(c, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(r[o2], r[o1]);
			}
		});

		for (int i : c)
			System.out.println(i + 1);
	}

}
