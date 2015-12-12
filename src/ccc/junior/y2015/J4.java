package ccc.junior.y2015;

import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] friendlastrecieve = new int[101];
		int[] friendlastsend = new int[101];
		for (int i = 0; i < 101; i++) {
			friendlastrecieve[i] = -1;
			friendlastsend[i] = -1;
		}
		int[] totaltime = new int[101];
		int t = 0;
		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			String entryType = s.next();
			int X = s.nextInt();
			// System.out.println(entryType + " " + X + ", t=" + t + ":");
			switch (entryType) {
			case "R":
				friendlastrecieve[X] = t;

				// System.out.println("r[" + X + "]=" + t);

				friendlastsend[X] = -1;

				// System.out.println("s[" + X + "]=-1");
				break;
			case "S":
				// System.out.println("s[" + X + "]=" + t);
				friendlastsend[X] = t;
				totaltime[X] += t - friendlastrecieve[X];
				break;
			case "W":
				t += X - 1;
				continue;
			}
			t++;
		}

		// for (int i = 0; i < 101; i++) {
		// System.out.println(i + ":" + friendlastrecieve[i] + "," +
		// friendlastsend[i]);
		// }
		for (int i = 0; i < 101; i++) {
			if (friendlastrecieve[i] != -1) {
				if (friendlastsend[i] == -1) {
					System.out.println(i + " -1");
					continue;
				}
				System.out.println(i + " " + totaltime[i]);
			}
		}
		s.close();
	}

}
