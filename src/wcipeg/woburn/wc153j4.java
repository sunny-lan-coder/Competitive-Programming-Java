package wcipeg.woburn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class wc153j4 {
	static class Pair implements Comparable<Pair> {

		public int rank;
		public int id;

		public Pair(int rank, int id) {
			this.rank = rank;
			this.id = id;
		}

		@Override
		public int compareTo(Pair o) {
			return rank - o.rank;
		}

		@Override
		public boolean equals(Object o) {
			return ((Pair) o).id == id;
		}

		@Override
		public int hashCode() {
			return id;
		}

	}

	static int[][] map;
	static int R;
	static int C;
	static int currentroom = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		R = s.nextInt();
		C = s.nextInt();
		int N = s.nextInt();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = s.next();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					map[i][j] = -1;
				} else {
					map[i][j] = -2;
				}
			}
		}

		ArrayList<Pair> control = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					Pair e = new Pair(dfs(i, j), currentroom);
					control.add(e);
					currentroom++;
				}
			}
		}
		// System.out.println();
		// for (int i = 0; i < R; i++) {
		// for (int j = 0; j < C; j++) {
		// if (map[i][j] >= 0)
		// System.out.print(map[i][j]);
		// else
		// System.out.print(" ");
		// }
		// System.out.println();
		// }

		Collections.sort(control);

		for (int i = 0; i < N; i++) {
			int T = s.nextInt();
			int A = s.nextInt();
			int B = s.nextInt();

			// for (Pair p : control) {
			// System.out.println(" " + p.id + " : " + p.rank);
			// }

			int id = map[A - 1][B - 1];
			int idx = control.indexOf(new Pair(0, id));
			if (idx == -1)
				System.out.println(idx);
			else {
				int rank = control.get(idx).rank;

				int mink = idx;
				int maxk = control.size()-2;
				int guess ;
				int nr ;
				int nr2 ;
				while (true) {
					guess =(int) Math.floor((mink + maxk)/ 2);
					nr = control.get(guess).rank;
					if (guess + 1 < control.size())
						nr2 = control.get(guess + 1).rank;
					else {
						nr2=187346;
					}
					if (nr2 > rank && nr <= rank) {
						break;
					}
					if (nr2 <= rank)
						mink = guess;
					if (nr > rank)
						maxk = guess;
				}
				System.out.println(control.size() - nr2);

				if (T == 2) {
					control.remove(idx);
					// System.out.println("rm");
				}
			}

		}

		s.close();

	}

	static int dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= R || j >= C) {
			return 0;
		}

		if (map[i][j] >= 0) {
			return 0;
		}

		if (map[i][j] == -2) {
			return 0;
		}

		map[i][j] = currentroom;

		return 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
	}

}
