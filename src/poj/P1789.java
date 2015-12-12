package poj;

import java.util.Scanner;

public class P1789 {

	static Scanner in;
	static int n;
	static char[][] trucks;
	static int total;
	static int min;
	static int minI;
	static int j;
	static int i;
	static int INFINITY = Integer.MAX_VALUE;
	static boolean[] tree;
	static int[] dists;
	static int newDist;

	public static int distance(char[] a, char[] b) {
		int d = 0;
		for (int i = 0; i < 7; i++) {
			if (a[i] != b[i]) {
				d++;
			}
		}
		return d;
	}

	public static boolean parse() {
		n = in.nextInt();
		if (n == 0)
			return false;

		trucks = new char[n][7];
		for (int i = 0; i < n; i++) {
			trucks[i] = in.next().toCharArray();
		}
		return true;
	}

	public static void solve() {
		dists = new int[n];
		for (int i = 0; i < n; i++) {
			dists[i] = distance(trucks[0], trucks[i]);
		}

		tree = new boolean[n];
		tree[0] = true;

		total = 0;

		for (i = 0; i < n - 1; i++) {
			min = INFINITY;
			minI = -1;
			for (j = 0; j < n; j++) {
				if (!tree[j]) {
					if (dists[j] < min) {
						min = dists[j];
						minI = j;
					}
				}
			}

			tree[minI] = true;
			total += min;

			for (j = 0; j < n; j++) {
				if (!tree[j]) {
					newDist = distance(trucks[minI], trucks[j]);
					if (newDist < dists[j])
						dists[j] = newDist;
				}
			}
		}
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while (parse()) {
			System.out.println("The highest possible quality is 1/" + total
					+ ".");
		}

		in.close();
	}
}
