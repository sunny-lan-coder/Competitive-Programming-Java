package ccc.s2014;

import java.util.HashMap;
import java.util.Scanner;

public class ccc14s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<String, Integer> nmap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			nmap.put(s.next(), i);
		}

		boolean[][] adj = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			adj[i][nmap.get(s.next())] = true;
		}

		s.close();

		for (int i = 0; i < n; i++) {
			if (adj[i][i]) {
				System.out.println("bad");
				return;
			}
			for (int j = 0; j < n; j++) {
				if (adj[i][j] != adj[j][i]) {
					System.out.println("bad");
					return;
				}
			}
		}
		System.out.println("good");

	}

}
