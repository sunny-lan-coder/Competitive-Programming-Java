package duwei.p1321;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = s.nextInt();
			}
		}
		visited = new boolean[666666];
		int sum=0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sum+=count(i,j,"");
			}
		}
		s.close();
		System.out.println(sum);
	}

	 static int count(int x, int y, String state) {
		if (x < 0 || x >= 5 || y < 0 || y <= 5)
			return 0;
		state += map[x][y];
		int currval = Integer.parseInt(state);
		if (state.length() == 6) {
			if (visited[currval])
				return 0;
		} else {
			visited[currval]=true;
			return 1;

		}

		int sum = 0;
		sum += count(x - 1, y, state);
		sum += count(x, y - 1, state);
		sum += count(x + 1, y, state);
		sum += count(x, y + 1, state);

		return sum;

	}

}
