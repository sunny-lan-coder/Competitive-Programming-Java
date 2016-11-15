package duwei.p1271;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a1 = s.nextInt();
		int a2 = s.nextInt();
		int a3 = s.nextInt();
		int a4 = s.nextInt();
		int a5 = s.nextInt();

		s.close();
		HashSet<Integer> possible = new HashSet<Integer>();
		boolean[][] visited = new boolean[101][101];
		for (int x4 = -50; x4 <= 50; x4++) {
			if (x4 == 0)
				continue;
			if (visited[x4 + 50][a4 + 50])
				continue;
			for (int x5 = -50; x5 <= 50; x5++) {
				if (x5 == 0)
					continue;
				if (visited[x5 + 50][a5 + 50])
					continue;
				possible.add(a4 * x4 * x4 * x4 + a5 * x5 * x5 * x5);

				visited[x5 + 50][a5 + 50] = true;
				visited[x4 + 50][a4 + 50] = true;
			}
		}

		long cnt = 0;
		for (int x1 = -50; x1 <= 50; x1++) {
			if (x1 == 0)
				continue;
			if (visited[x1 + 50][a1 + 50])
				continue;
			for (int x2 = -50; x2 <= 50; x2++) {
				if (x2 == 0)
					continue;
				if (visited[x2 + 50][a2 + 50])
					continue;
				for (int x3 = -50; x3 <= 50; x3++) {
					if (x3 == 0)
						continue;
					if (visited[x3 + 50][a3 + 50])
						continue;
					
					if (possible.contains(-(a1 * x1 * x1 * x1 + a2 * x2 * x2 * x2 + a3 * x3 * x3 * x3)))
						cnt++;
					
					visited[x3 + 50][a3 + 50] = true;
					visited[x2 + 50][a2 + 50] = true;
					visited[x1 + 50][a1 + 50] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}
