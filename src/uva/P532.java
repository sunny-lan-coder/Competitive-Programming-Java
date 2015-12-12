package uva;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P532 {

	static class Node {
		public int x;
		public int y;
		public int z;
		public int level;

		public Node(int x, int y, int z, int level) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.level = level;
		}

		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node cmp = (Node) o;
				return cmp.x == x && cmp.y == y && cmp.z == z;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		outer: while (true) {
			int L = s.nextInt();
			//s.next();
			int R = s.nextInt();
			//s.next();
			int C = s.nextInt();
			//s.nextLine();
			if (L == 0 && R == 0 && C == 0)
				break;
			int[][][] matrix = new int[L][R][C];
			int sC = 0, sR = 0, sL = 0;// z=level, y= row number, x=col number
			int dC = 0, dR = 0, dL = 0;
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String line = s.next();
					for (int c = 0; c < C; c++) {
						switch (line.charAt(c)) {
						case '#':
							matrix[l][r][c] = 1;
							break;
						case 'E':
							dC = c;
							dR = r;
							dL = l;
							matrix[l][r][c] = 0;
							break;
						case 'S':
							sC = c;
							sR = r;
							sL = l;
						case '.':
							matrix[l][r][c] = 0;
							break;
						}
					}
				}
			}

			Node end = new Node(dC, dR, dL, 9999);

			Queue<Node> nodes = new LinkedList<Node>();

			nodes.add(new Node(sC, sR, sL, 0));

			// Node parent = new Node(x1, y1, 0);
			while (!nodes.isEmpty()) {
				Node n = nodes.remove();
				// System.out.print("checking " + parent + " to " + n);

				// precheck
				if (n.x < 0 || n.y < 0 || n.z < 0 || n.x >= C || n.y >= R || n.z >= L) {
					// System.out.println(" | out");
					continue;
				}

				if (n.equals(end)) {
					// System.out.println(" | done");
					System.out.println("Escaped in " + n.level + " minute(s).");
					continue outer;
				}

				if (matrix[n.z][n.y][n.x] != 0) {
					// System.out.println(" | taken");
					continue;
				}
				matrix[n.z][n.y][n.x] = 1;

				// advance search
				nodes.add(new Node(n.x + 1, n.y + 0, n.z + 0, n.level + 1));
				nodes.add(new Node(n.x - 1, n.y + 0, n.z + 0, n.level + 1));
				nodes.add(new Node(n.x + 0, n.y + 1, n.z + 0, n.level + 1));
				nodes.add(new Node(n.x + 0, n.y - 1, n.z + 0, n.level + 1));
				nodes.add(new Node(n.x + 0, n.y + 0, n.z + 1, n.level + 1));
				nodes.add(new Node(n.x + 0, n.y + 0, n.z - 1, n.level + 1));

				// parent = n;
			}
			System.out.println("Trapped!");
		}
		s.close();
	}

}
