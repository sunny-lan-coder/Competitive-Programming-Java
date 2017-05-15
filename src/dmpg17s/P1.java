package dmpg17s;
import java.util.Scanner;

public class P1 {

	static int[] p;

	static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	static boolean cmpSet(int x, int y) {
		return find(x) == find(y);
	}

	static void merge(int x, int y) {
		p[find(x)] = find(y);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int q = s.nextInt();
		p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = i;
		for (int i = 0; i < q; i++) {
			String op = s.next();
			int x = s.nextInt();
			int y = s.nextInt();
			x--;
			y--;
			if (op.equals("A")) {
				merge(x, y);
			} else {
				if (cmpSet(x, y)) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
			}

		}
		s.close();
	}

}
