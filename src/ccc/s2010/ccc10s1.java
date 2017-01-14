package ccc.s2010;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ccc10s1 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] idxs = new Integer[n];
		String[] names = new String[n];
		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			idxs[i] = i;
			String name = s.next();
			int r = s.nextInt();
			int c = s.nextInt();
			int d = s.nextInt();
			names[i] = name;
			vals[i] = 2 * r + 3 * c + d;
		}
		s.close();
		Arrays.sort(idxs, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int res = Integer.compare(vals[o2], vals[o1]);
				if (res == 0)
					res = names[o1].compareTo(names[o2]);
				return res;
			}
		});
		for (int i = 0; i < Math.min(2, n); i++) {
			System.out.println(names[idxs[i]]);
		}
	}

}
