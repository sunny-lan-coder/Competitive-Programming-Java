package ccc.j2014;

import java.util.Scanner;

public class J5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String[] names = new String[N];
		for (int n = 0; n < N; n++) {
			names[n] = s.next();
		}
		boolean[][] adj = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int part = 0;
			String in = s.next();
			for (int j = 0; j < N; j++) {
				if (names[j].equals(in)) {
					part = j;
					break;
				}
			}
			adj[i][part] = true;
		}
		test: while (true) {
			for (int i = 0; i < N; i++) {
				if (adj[i][i]) {
					System.out.println("bad");
					break test;
				}
				for (int j = 0; j < N; j++) {
					if (adj[i][j]) {
						if (adj[j][i]) {
							break;
						} else {
							System.out.println("bad");
							break test;
						}
					}
				}
			}
			System.out.println("good");
			break;
		}
		s.close();
	}

}
