package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Disjoint {

	static int[] p;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		while (s.hasNext()) {
			String op = s.next();
			if (op.equals("M")) {
				int x = s.nextInt();
				int y = s.nextInt();
				merge(x, y);
			} else if (op.equals("Q")) {
				int x = s.nextInt();
				int y = s.nextInt();
				if (find(x) == find(y))
					System.out.println("In same set");
				else
					System.out.println("In different set");
			} else if (op.equals("L")) {
				System.out.println(Arrays.toString(p));
			}
		}
		s.close();
	}

	static int find(int x) {
		if (p[x] != x)
			p[x] = find(p[x]);
		return p[x];
	}

	static void merge(int x, int y) {
		p[find(y)] = p[find(x)];
	}
}
