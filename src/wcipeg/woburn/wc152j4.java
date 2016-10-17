package wcipeg.woburn;

import java.util.Scanner;

public class wc152j4 {

	static boolean[][][] visited;
	static boolean[][] derp;
	static char[][] map;
	static int N;
	static int M;

	static boolean[][] dangerous;

	static boolean willReachCell(int x, int y, int d, int i, int j) {
		// System.out.println(" i=" + i + ", j=" + j + ", d=" + d + ", x=" + x +
		// ", y=" + y);

		if (i < 0 || i >= N || j < 0 || j >= M) {
			return false;
		}

		// System.out.println(" px=" + map[i][j]);

		if (x == i && y == j)
			return true;

		if(derp[i][j])
			dangerous[i][j] = true;
		
		if (visited[i][j][d]) {
			return false;
		}

		visited[i][j][d] = true;
		derp[i][j] = true;

		if (map[i][j] == '.') {
			int ti = i;
			int tj = j;
			int ai = 0;
			int aj = 0;
			switch (d) {
			case 0:// down
				ai = 1;
				break;
			case 1:// up
				ai = -1;
				break;
			case 2:// right >
				aj++;
				break;
			case 3:// left <
				aj--;
				break;
			}
			while (map[ti][tj] == '.') {
				ti += ai;
				tj += aj;
				if (ti < 0 || ti >= N || tj < 0 || tj >= M)
					return false;
				if (x == ti && y == tj)
					return true;
				if (visited[ti][tj][d])
					return false;
			}
			return willReachCell(x, y, d, ti, tj);
		}

		else if (map[i][j] == '/') {
			switch (d) {
			case 0:
				return willReachCell(x, y, 3, i, j - 1);
			case 1:
				return willReachCell(x, y, 2, i, j + 1);
			case 2:
				return willReachCell(x, y, 1, i - 1, j);
			case 3:
				return willReachCell(x, y, 0, i + 1, j);
			}
		}

		else if (map[i][j] == '\\') {
			switch (d) {
			case -0:
				return willReachCell(x, y, 2, i, j + 1);
			case 1:
				return willReachCell(x, y, 3, i, j - 1);
			case 2:
				return willReachCell(x, y, 0, i + 1, j);
			case 3:
				return willReachCell(x, y, 1, i - 1, j);
			}
		}

		else if (map[i][j] == 'X') {
			// switch (d) {
			// case 0:
			// return willReachCell(x, y, 1, i - 1, j);
			// case 1:
			// return willReachCell(x, y, 0, i + 1, j);
			// case 2:
			// return willReachCell(x, y, 3, i, j - 1);
			// case 3:
			// return willReachCell(x, y, 2, i, j + 1);
			// }
			return true;
		}

		else if (map[i][j] == '#') {
			return false;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		dangerous 
		= new boolean[N][M];
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			String l = s.next();
			for (int j = 0; j < M; j++) {
				map[i] = l.toCharArray();
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == '.') {
					if (dangerous[i][j]) {
						count++;
						continue;
					}
					// for (int d = 0; d < 4; d++) {

					/// System.out.println("test");

					visited = new boolean[N][M][4];
					// switch (d) {
					// case 0:// down
					derp = new boolean[N][M];
					/// System.out.println(" test");
					if (willReachCell(i, j, 0, i + 1, j)) {
						count++;
						dangerous[i][j] = true;
						continue;
					}
					// break;
					// case 1:// up

					visited = new boolean[N][M][4];
					derp = new boolean[N][M];
					// System.out.println(" test");
					if (willReachCell(i, j, 1, i - 1, j)) {
						count++;
						dangerous[i][j] = true;
						continue;
					}
					// break;
					// case 2:// right >

					visited = new boolean[N][M][4];
					derp = new boolean[N][M];
					// System.out.println(" test");
					if (willReachCell(i, j, 2, i, j + 1)) {
						count++;
						dangerous[i][j] = true;
						continue;
					}
					// break;
					// case 3:// left <

					visited = new boolean[N][M][4];
					derp = new boolean[N][M];
					// System.out.println(" test");
					if (willReachCell(i, j, 3, i, j - 1)) {
						count++;
						dangerous[i][j] = true;
						continue;
					}
					// break;
					// }eeeeee
					// System.out.println(derp);

					// }

				}
			}
		}

		System.out.println(count);
		s.close();
	}

}

