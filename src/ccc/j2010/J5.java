package ccc.j2010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sx = s.nextInt();
		int sy = s.nextInt();
		int ex = s.nextInt();
		int ey = s.nextInt();
		s.close();

		boolean[][] visited = new boolean[9][9];

		Queue<Integer> xpos = new LinkedList<>();
		Queue<Integer> ypos = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();

		xpos.add(sx);
		ypos.add(sy);
		levels.add(0);

		while (!levels.isEmpty()) {
			int x = xpos.remove();
			int y = ypos.remove();
			int level = levels.remove();
			
			if (x < 1 || x > 8)
				continue;

			if (y < 1 || y > 8)
				continue;

			if (visited[x][y])
				continue;
			
			if (x == ex && y == ey) {
				System.out.println(level);
				return;
			}

			// expand

			xpos.add(x - 1);
			ypos.add(y - 2);
			levels.add(level + 1);
			xpos.add(x + 1);
			ypos.add(y - 2);
			levels.add(level + 1);
			xpos.add(x + 2);
			ypos.add(y - 1);
			levels.add(level + 1);
			xpos.add(x + 2);
			ypos.add(y + 1);
			levels.add(level + 1);
			xpos.add(x + 1);
			ypos.add(y + 2);
			levels.add(level + 1);
			xpos.add(x - 1);
			ypos.add(y + 2);
			levels.add(level + 1);
			xpos.add(x - 2);
			ypos.add(y + 1);
			levels.add(level + 1);
			xpos.add(x - 2);
			ypos.add(y - 1);
			levels.add(level + 1);

			visited[x][y] = true;
		}
	}

}
