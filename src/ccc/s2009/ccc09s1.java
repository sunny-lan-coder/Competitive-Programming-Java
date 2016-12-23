package ccc.s2009;

import java.util.HashSet;
import java.util.Scanner;

public class ccc09s1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		s.close();

		HashSet<Integer> squares = new HashSet<>();
		int start = Math.max(0, (int) (Math.sqrt(a) - 1));

		for (int i = start;; i++) {
			int sq = i * i;
			if (sq > b)
				break;
			if (sq >= a)
				squares.add(sq);
		}

		start = Math.max(0, (int) (Math.cbrt(a) - 1));

		int count = 0;
		for (int i = start;; i++) {
			int cb = i * i * i;
			if (cb > b)
				break;
			if (cb >= a && squares.contains(cb))
				count++;
		}

		System.out.println(count);

	}

}
