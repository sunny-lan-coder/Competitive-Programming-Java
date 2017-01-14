package uva;

import java.util.Scanner;

public class P109 {

	static class Point {
		public final int x;
		public final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;

		while ((n = s.nextInt()) != -1) {
			int[] top = new int[501];
			int[] bottom = new int[501];
			for (int i = 0; i <= 500; i++) {
				top[i] = 666;
				bottom[i] = -666;
			}
			for (int i = 0; i < n; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				top[x] = Math.min(top[x], y);
				bottom[y] = Math.max(bottom[y], y);
			}

			for (int i = 0; i <= 500; i++) {
				
			}
		}

		while (s.hasNext()) {
			int x = s.nextInt();
			int y = s.nextInt();
		}

		s.close();
	}

}
