package usaco.gold2015december;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class P3 {
	static final int up = 1;
	static final int down = 2;
	static final int left = 3;
	static final int right = 4;
	static final int none = 0;

	public static void main(String[] args) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream("dream.out"));
		InputStream in = new FileInputStream("dream.in");

		// Scanner s = new Scanner(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// read input
		String[] tmparr = br.readLine().split(" ");
		int n = Integer.parseInt(tmparr[0]);
		int m = Integer.parseInt(tmparr[1]);
		String tmpstr;
		int[][] map = new int[n][m];
		for (int row = 0; row < n; row++) {
			tmpstr = br.readLine();
			for (int col = 0; col < m; col++) {
				switch (tmpstr.charAt(2 * col)) {
				case '0':
					map[row][col] = 0;
					break;
				case '1':
					map[row][col] = 1;
					break;
				case '2':
					map[row][col] = 2;
					break;
				case '3':
					map[row][col] = 3;
					break;
				case '4':
					map[row][col] = 4;
					break;
				}
			}
		}
		// s.close();
		br.close();
		// process
		boolean[] visited = new boolean[enc(n, m, 4, 1) + 1];
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> l = new LinkedList<>();
		l.add(0);
		q.add(enc(0, 0, none, 0));
		while (!l.isEmpty()) {
			int val = q.remove();
			int level = l.remove();

			if (visited[val]) {
				continue;
			}
			visited[val] = true;

			int row = row(val);
			int col = col(val);
			// out.println("pos=("+col+", "+row+"), level="+level);
			if (row < 0 || col < 0 || col >= m || row >= n)
				continue;

			int or = or(val);
			int dir = dir(val);

			// out.println(" orange="+or);
			//
			// out.print(" dir=");
			// switch(dir){
			// case 0:
			// out.println("none");
			// break;
			// case 1:
			// out.println("up");
			// break;
			// case 2:
			// out.println("down");
			// break;
			// case 3:
			// out.println("left");
			// break;
			// case 4:
			// out.println("right");
			// break;
			// }
			// out.println(" currblock="+map[row][col]);
			if (row == n - 1 && col == m - 1) {
				out.println(level);
				out.close();
				return;
			}

			switch (map[row][col]) {
			case 0:
				break;
			case 1:
				q.add(enc(row - 1, col, up, or));
				l.add(level + 1);
				q.add(enc(row + 1, col, down, or));
				l.add(level + 1);
				q.add(enc(row, col + 1, right, or));
				l.add(level + 1);
				q.add(enc(row, col - 1, left, or));
				l.add(level + 1);
				break;
			case 2:
				q.add(enc(row - 1, col, up, 1));
				l.add(level + 1);
				q.add(enc(row + 1, col, down, 1));
				l.add(level + 1);
				q.add(enc(row, col + 1, right, 1));
				l.add(level + 1);
				q.add(enc(row, col - 1, left, 1));
				l.add(level + 1);
				break;
			case 3:
				if (or == 1) {
					q.add(enc(row - 1, col, up, or));
					l.add(level + 1);
					q.add(enc(row + 1, col, down, or));
					l.add(level + 1);
					q.add(enc(row, col + 1, right, or));
					l.add(level + 1);
					q.add(enc(row, col - 1, left, or));
					l.add(level + 1);
				}
				break;
			case 4:
				switch (dir) {
				// case none:
				// q.add(enc(row - 1, col, up, 0));
				// l.add(level + 1);
				// q.add(enc(row + 1, col, down, 0));
				// l.add(level + 1);
				// q.add(enc(row, col + 1, right, 0));
				// l.add(level + 1);
				// q.add(enc(row, col - 1, left, 0));
				// l.add(level + 1);
				// break;
				case up:

					if (row > 0 && !((map[row - 1][col] == 3 && or == 0) || (map[row - 1][col] == 0))) {
						q.add(enc(row - 1, col, up, 0));
						l.add(level + 1);
					} else {
						q.add(enc(row - 1, col, up, 0));
						l.add(level + 1);
						q.add(enc(row + 1, col, down, 0));
						l.add(level + 1);
						q.add(enc(row, col + 1, right, 0));
						l.add(level + 1);
						q.add(enc(row, col - 1, left, 0));
						l.add(level + 1);
					}
					break;
				case down:
					if (row < n - 1 && !((map[row + 1][col] == 3 && or == 0) || (map[row + 1][col] == 0))) {
						q.add(enc(row + 1, col, down, 0));
						l.add(level + 1);
					} else {
						q.add(enc(row - 1, col, up, 0));
						l.add(level + 1);
						q.add(enc(row + 1, col, down, 0));
						l.add(level + 1);
						q.add(enc(row, col + 1, right, 0));
						l.add(level + 1);
						q.add(enc(row, col - 1, left, 0));
						l.add(level + 1);
					}
					break;
				case left:
					if (col > 0 && !((map[row][col - 1] == 3 && or == 0) || (map[row][col - 1] == 0))) {
						q.add(enc(row, col - 1, left, 0));
						l.add(level + 1);
					} else {
						q.add(enc(row - 1, col, up, 0));
						l.add(level + 1);
						q.add(enc(row + 1, col, down, 0));
						l.add(level + 1);
						q.add(enc(row, col + 1, right, 0));
						l.add(level + 1);
						q.add(enc(row, col - 1, left, 0));
						l.add(level + 1);
					}
					break;
				case right:
					if (col < m - 1 && !((map[row][col + 1] == 3 && or == 0) || (map[row][col + 1] == 0))) {
						q.add(enc(row, col + 1, right, 0));
						l.add(level + 1);
					} else {
						q.add(enc(row - 1, col, up, 0));
						l.add(level + 1);
						q.add(enc(row + 1, col, down, 0));
						l.add(level + 1);
						q.add(enc(row, col + 1, right, 0));
						l.add(level + 1);
						q.add(enc(row, col - 1, left, 0));
						l.add(level + 1);
					}
					break;
				}
				break;
			}

		}
		out.println(-1);
		out.close();
		// throw new ArrayIndexOutOfBoundsException("ononononen");
	}

	static int row(int val) {
		return (val / (1003 * 5 * 2)) - 1;
	}

	static int col(int val) {
		return ((val % (1003 * 5 * 2)) / (5 * 2)) - 1;
	}

	static int dir(int val) {
		return (val % (5 * 2)) / 2;
	}

	static int or(int val) {
		return val % 2;
	}

	static int enc(int row, int col, int dir, int or) {
		row++;
		col++;
		return or + dir * 2 + col * 5 * 2 + row * 1003 * 5 * 2;
	}
}
