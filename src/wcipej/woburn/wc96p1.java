package wcipej.woburn;

import java.util.Scanner;

public class wc96p1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int dataset = 0; dataset < 5; dataset++) {
			int n = in.nextInt();
			boolean[][][] fishtank = new boolean[n][n][n];
			while (true) {
				int x = in.nextInt();
				int y = in.nextInt();
				int t = in.nextInt();
				int b = in.nextInt();
				if (x == 0 && y == 0 && t == 0 && b == 0)
					break;
				for (int level = b - 1; level < t; level++) {
					fishtank[x - 1][y - 1][level] = true;
				}
			}
			int max = -1;
			int maxlevel = -1;
			for (int level = 0; level < n; level++) {
				int count = 0;
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (fishtank[x][y][level]) {
							count++;
						}
					}
				}
				if (count > max) {
					max = count;
					maxlevel = level;
				}
			}
			System.out.println(maxlevel + 1);
		}
		in.close();
	}

}
