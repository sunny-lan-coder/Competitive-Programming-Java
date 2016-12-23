package ccc.s2009;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ccc09s3 {

	static boolean[][] adj = new boolean[50][50];

	static void i(int x, int y) {
		adj[x][y] = true;
		adj[y][x] = true;
	}

	static void d(int x, int y) {
		adj[x][y] = false;
		adj[y][x] = false;
	}

	static int n(int x) {
		int count = 0;
		for (int i = 0; i < 50; i++) {
			if (adj[x][i])
				count++;
		}
		return count;
	}

	static int f(int x) {
//		boolean[] visited = new boolean[50];
//		visited[x] = true;
		int count = 0;
		for (int i = 0; i < 50; i++) {
//			if (adj[x][i]){
//				visited[i] = true;
//				for (int j = 0; j < 50; j++) {
//					if (adj[i][j] && !visited[j]) {
//						visited[j] = true;
//						count++;
//					}
//				}
//			}
			if(s(x,i)==2)
				count++;
		}
		return count;
	}

	static int s(int x, int y) {
		boolean[] visited = new boolean[50];
		Queue<Integer> next = new LinkedList<>();
		Queue<Integer> level = new LinkedList<>();
		next.add(x);
		level.add(0);
		while (!next.isEmpty()) {
			int curr = next.remove();
			int lev = level.remove();
			if (visited[curr])
				continue;

			if (curr == y)
				return lev;
			for (int j = 0; j < 50; j++) {
				if (adj[curr][j]) {
					next.add(j);
					level.add(lev + 1);
				}
			}
			visited[curr] = true;
		}
		return -1;
	}

	public static void main(String[] args) {
		i(1, 6);
		i(2, 6);
		i(3, 4);
		i(3, 5);
		i(3, 6);
		i(3, 15);
		i(4, 5);
		i(4, 6);
		i(5, 6);
		i(6, 7);
		i(7, 8);
		i(8, 9);
		i(9, 10);
		i(9, 12);
		i(10, 11);
		i(11, 12);
		i(12, 13);
		i(13, 14);
		i(13, 15);
		i(16, 17);
		i(16, 18);
		i(17, 18);

		Scanner s = new Scanner(System.in);
		out: while (s.hasNext()) {
			switch (s.next()) {
			case "i":
				i(s.nextInt(), s.nextInt());
				break;
			case "d":
				d(s.nextInt(), s.nextInt());
				break;
			case "n":
				System.out.println(n(s.nextInt()));
				break;
			case "f":
				System.out.println(f(s.nextInt()));
				break;
			case "s":
				int r = s(s.nextInt(), s.nextInt());
				if (r == -1)
					System.out.println("Not connected");
				else
					System.out.println(r);
				break;
			case "q":
				break out;
			}
		}
		s.close();
	}

}
