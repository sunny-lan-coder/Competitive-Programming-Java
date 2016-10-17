package wcipeg.woburn;

import java.util.Scanner;

public class wc152j3 {

	static double d(int x1, int y1, int x2, int y2) {
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int S = s.nextInt();
		int E = s.nextInt();
		int R = s.nextInt();
		int[] SW = new int[S];
		int[] SX = new int[S];
		int[] SY = new int[S];
		for (int i = 0; i < S; i++) {
			SW[i] = s.nextInt();
			SX[i] = s.nextInt();
			SY[i] = s.nextInt();
		}

		int dangerCount = 0;

		for (int i = 0; i < E; i++) {
			int ex = s.nextInt();
			int ey = s.nextInt();
			// System.out.println("ex=" + ex + ", ey=" + ey);
			int lW = -1;
			for (int j = 0; j < S; j++) {
				int sx = SX[j];
				int sy = SY[j];
				// System.out.println(" sx=" + sx + ", sy=" + sy);
				if (R >= d(ex, ey, sx, sy)) {

					int sw = SW[j];
					if (lW == -1) {
						lW = sw;
					} else {
						if (lW != sw) {
							dangerCount++;
							break;
						}
					}
				}
			}
		}

		System.out.println(dangerCount);
		s.close();
	}

}
