package ccc.prac.y2011;

import java.util.Scanner;

public class J4 {

	static boolean[][] visited;
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		visited = new boolean[500][500];
		incyby(3, -1);
		incxby(3, 1);
		incyby(2, -1);
		incxby(2, 1);
		incyby(2, 1);
		incxby(2, 1);
		incyby(4, -1);
		incxby(8, -1);
		incyby(2, 1);
		outer: while (true) {
			String command = s.next();
			int len = s.nextInt();
			boolean val = false;
			switch (command) {
			case "d":
				val |= incyby(len, -1);
				break;
			case "u":
				val |= incyby(len, 1);
				break;
			case "l":
				val |= incxby(len, -1);
				break;
			case "r":
				val |= incxby(len, 1);
				break;
			case "q":
				break outer;
			}
			System.out.print(x + " " + y + " ");
			if (val) {
				System.out.println("DANGER");
				break;
			} else {
				System.out.println("safe");
			}
		}
		s.close();
	}

	static boolean incxby(int val, int dir) {
		boolean flag = false;
		for (int inc = 0; inc < val; inc++) {
			x += dir;
			if (get(x, y)) {
				flag = true;
			}
			set(x, y, true);
		}
		return flag;
	}

	static boolean incyby(int val, int dir) {
		boolean flag = false;
		for (int inc = 0; inc < val; inc++) {
			y += dir;
			// System.out.println(x + " " + y + " ");
			if (get(x, y)) {
				flag = true;
			}
			set(x, y, true);
		}
		return flag;
	}

	static boolean get(int x, int y) {
		return visited[x + 200][-y];
	}

	static void set(int x, int y, boolean val) {
		visited[x + 200][-y] = val;
	}

}
