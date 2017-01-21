package duwei.p1308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[] tree;

	static int n;

	static boolean outRect(int nx1, int ny1, int nx2, int ny2, int x1, int y1, int x2, int y2) {
		return x1 >= nx2 || x2 <= nx1 || y1 >= ny2 || y2 <= ny1;
	}

	static void update(int n, int nx1, int ny1, int nx2, int ny2, int x1, int y1, int x2, int y2) {

		if (x1 <= nx1 && nx2 <= x2 && y1 <= ny1 && ny2 <= y2) {
			tree[n] = !tree[n];
		} else if (outRect(nx1, ny1, nx2, ny2, x1, y1, x2, y2)) {
			return;
		} else {
			int xm = (nx1 + nx2) / 2;
			int ym = (ny1 + ny2) / 2;
			update(n * 4 + 1, nx1, ny1, xm, ym, x1, y1, x2, y2);// tl
			update(n * 4 + 2, xm, ny1, nx2, ym, x1, y1, x2, y2);// tr
			update(n * 4 + 3, nx1, ym, xm, ny2, x1, y1, x2, y2);// bl
			update(n * 4 + 4, xm, ym, nx2, ny2, x1, y1, x2, y2);// br
		}
	}

	static boolean query(int n, int nx1, int ny1, int nx2, int ny2, int x, int y) {
		if (nx2 - nx1 == 1 && ny2 - ny1 == 1)
			return tree[n];

		int xm = (nx1 + nx2) / 2;
		int ym = (ny1 + ny2) / 2;
		if (x >= xm) {
			if (y >= ym) {
				return tree[n] ^ query(n * 4 + 4, xm, ym, nx2, ny2, x, y);
			} else {
				return tree[n] ^ query(n * 4 + 2, xm, ny1, nx2, ym, x, y);
			}
		} else {
			if (y >= ym) {
				return tree[n] ^ query(n * 4 + 3, nx1, ym, xm, ny2, x, y);
			} else {
				return tree[n] ^ query(n * 4 + 1, nx1, ny1, xm, ym, x, y);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		tree = new boolean[4194305];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String[] tmp;
		for (int test = 0; test < x; test++) {
			tmp = br.readLine().split(" ");
			n = Integer.parseInt(tmp[0]);
			int t = Integer.parseInt(tmp[1]);

			for (int i = 0; i <= 4194304; i++) {
				tree[i] = false;
			}

			for (int i = 0; i < t; i++) {
				tmp = br.readLine().split(" ");
				if (tmp[0].equals("Q")) {
					int x1 = Integer.parseInt(tmp[1]) - 1;
					int y = Integer.parseInt(tmp[2]) - 1;
					if (query(0, 0, 0, 1024, 1024, x1, y))
						System.out.println(1);
					else
						System.out.println(0);
				} else {

					int x1 = Integer.parseInt(tmp[1]) - 1;
					int y1 = Integer.parseInt(tmp[2]) - 1;
					int x2 = Integer.parseInt(tmp[3]);
					int y2 = Integer.parseInt(tmp[4]);
					update(0, 0, 0, 1024, 1024, x1, y1, x2, y2);
				}
			}
		}
		br.close();
	}

	static int log(int n, int b) {
		return (int) (Math.log(n) / Math.log(b));
	}

}