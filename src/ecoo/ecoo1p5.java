package ecoo;

import java.util.Scanner;

public class ecoo1p5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int t = 0; t < 5; t++) {
			int busyuntil;
			int N = s.nextInt();
			for (int job = 0; job < N; job++) {
				String jobTimecode = s.next();
				int jobDuration = s.nextInt();
				String name = s.next();
				
			}
		}
		s.close();
	}

	static int tosecs(int h, int m, int s) {
		return h * 3600 + m * 60 + s;
	}

	static int[] totimecode(int secs) {
		int h = secs / 3600;
		secs = secs % 3600;
		int m = secs / 60;
		secs = secs % 60;
		return new int[] { secs, m, h };
	}
}
