package ccc.s2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ccc08s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		outer: for (int i = 0; i < t; i++) {

			int r = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());

			char[][] map = new char[r][c];
			for (int j = 0; j < r; j++) {
				String line = br.readLine();
				for (int k = 0; k < c; k++) {
					map[j][k] = line.charAt(k);
				}
			}

			if (map[r - 1][c - 1] == '*')

			{
				System.out.println(-1);
				continue outer;
			}
			Queue<Integer> xlocs = new LinkedList<>();
			Queue<Integer> ylocs = new LinkedList<>();
			Queue<Integer> levels = new LinkedList<>();
			xlocs.add(0);
			ylocs.add(0);
			levels.add(1);
			while (!levels.isEmpty()) {
				int x = xlocs.remove();
				int y = ylocs.remove();
				int level = levels.remove();

				if (x < 0 || x >= c || y < 0 || y >= r)
					continue;

				if (x == c - 1 && y == r - 1) {
					System.out.println(level);
					continue outer;
				}

				switch (map[y][x]) {
				case '0':
					continue;
				case '+':
					xlocs.add(x - 1);
					ylocs.add(y);
					levels.add(level + 1);
					xlocs.add(x + 1);
					ylocs.add(y);
					levels.add(level + 1);
					xlocs.add(x);
					ylocs.add(y - 1);
					levels.add(level + 1);
					xlocs.add(x);
					ylocs.add(y + 1);
					levels.add(level + 1);
					break;
				case '*':
					break;
				case '-':
					xlocs.add(x - 1);
					ylocs.add(y);
					levels.add(level + 1);
					xlocs.add(x + 1);
					ylocs.add(y);
					levels.add(level + 1);
					break;
				case '|':
					xlocs.add(x);
					ylocs.add(y - 1);
					levels.add(level + 1);
					xlocs.add(x);
					ylocs.add(y + 1);
					levels.add(level + 1);
					break;
				}

				map[y][x] = '0';
			}
			System.out.println("-1");
		}
		br.close();
	}

}
