package ccc.prac.y2009;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J5 {

	static void set(boolean[][] mat, int x, int y, boolean val) {
		mat[x][y] = val;
		mat[y][x] = val;
	}

	public static void main(String[] args) {
		boolean[][] adjmat = new boolean[66][66];

		set(adjmat, 1, 6, true);
		set(adjmat, 2, 6, true);
		set(adjmat, 3, 6, true);
		set(adjmat, 3, 4, true);
		set(adjmat, 3, 5, true);
		set(adjmat, 3, 16, true);
		set(adjmat, 4, 6, true);
		set(adjmat, 4, 5, true);
		set(adjmat, 5, 6, true);
		set(adjmat, 6, 7, true);
		set(adjmat, 7, 8, true);
		set(adjmat, 8, 9, true);
		set(adjmat, 9, 10, true);
		set(adjmat, 9, 12, true);
		set(adjmat, 10, 11, true);
		set(adjmat, 11, 12, true);
		set(adjmat, 12, 13, true);
		set(adjmat, 13, 15, true);
		set(adjmat, 13, 14, true);
		set(adjmat, 16, 17, true);
		set(adjmat, 16, 18, true);
		set(adjmat, 17, 18, true);

		Scanner s = new Scanner(System.in);
		outer: while (true) {
			int x = 0;
			int y = 0;

			String command = s.next();
			if (command.equals("q"))
				break;

			x = s.nextInt();

			if (command.equals("s") || command.equals("d") || command.equals("i"))
				y = s.nextInt();

			switch (command) {
			case "i":
				adjmat[x][y] = true;
				adjmat[y][x] = true;
				break;
			case "d":
				adjmat[x][y] = false;
				adjmat[y][x] = false;
				break;
			case "n":
				int count = 0;
				for (int i = 0; i < 66; i++) {
					if (adjmat[x][i])
						count++;
				}
				System.out.println(count);
				break;
			case "f":
				boolean[] visited = new boolean[66];
				visited[x] = true;
				count = 0;
				for (int i = 0; i < 66; i++) {
					if (adjmat[x][i])
						visited[i] = true;
				}
				for (int i = 0; i < 66; i++) {
					if (adjmat[x][i])
						for (int j = 0; j < 66; j++) {
							if (adjmat[i][j] && !visited[j]) {
								count++;
								visited[j] = true;
							}
						}
				}
				System.out.println(count);
				break;
			case "s":
				Queue<Integer> pos = new LinkedList<>();
				Queue<Integer> level = new LinkedList<>();
				level.add(0);
				pos.add(x);
				visited = new boolean[66];
				while (!pos.isEmpty()) {
					int p = pos.remove();
					int l = level.remove();
					if (p == y) {
						System.out.println(l);
						continue outer;
					}

					if (visited[p])
						continue;

					for (int i = 0; i < 66; i++) {
						if (adjmat[i][p]) {
							pos.add(i);
							level.add(l + 1);
						}
					}

					visited[p] = true;
				}
				System.out.println("Not connected");
				break;
			}

		}
		s.close();
	}

}
