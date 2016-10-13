package duwei.tmp3;

import java.util.Random;

public class Gendat {

	public static void main(String[] args) {
		System.out.println(100);
		Random rng = new Random();
		System.out.println(rng.nextInt(100) + 1);
		System.out.println(rng.nextInt(50));
		int m = rng.nextInt(100 * 100);
		System.out.println(m);
		boolean[][] visited = new boolean[101][101];
		for (int i = 0; i < m;) {
			int a = rng.nextInt(100) + 1;
			int b = rng.nextInt(100) + 1;

			if (!visited[a][b]) {
				System.out.println(a + " " + b + " " + rng.nextInt(100));
				i++;
			}
		}
	}

}
