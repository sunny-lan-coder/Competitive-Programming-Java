package usaco.bronze2014.december;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crosswords {

	private static final boolean debug = true;

	static boolean[][] _blocked;
	static int N;
	static int M;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		PrintStream out;
		if (debug) {
			s = new Scanner(System.in);
			out = System.out;
		} else {
			s = new Scanner(new FileInputStream("marathon.in"));
			out = new PrintStream("marathon.out");
		}

		int N = s.nextInt();
		int M = s.nextInt();

		_blocked = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = s.next();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == '.') {
					_blocked[i][j] = false;
				} else {
					_blocked[i][j] = true;
				}
			}
		}

		List<Integer> cX = new ArrayList<>();
		List<Integer> cY = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!blocked(i, j)) {
					if (blocked(i - 1, j) && (!blocked(i + 1, j))
							&& (!blocked(i + 2, j))) {
						cX.add(i);
						cY.add(j);
					}
					if (blocked(i, j - 1) && (!blocked(i, j - 1))
							&& (!blocked(i, j + 2))) {
						cX.add(i);
						cY.add(j);
					}
				}
			}
		}

		out.println(cX.size());
		for (int i = 0; i < cX.size(); i++) {
			out.println((cX.get(i) + 1) + " " + (cY.get(i) + 1));
		}

		s.close();
		out.close();
	}

	static boolean blocked(int x, int y) {
		if (x < 0 || x >= N)
			return true;
		if (y < 0 || y >= M)
			return true;

		if (_blocked[x][y])
			return true;

		return false;
	}

}
