package poj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2243 {
	static class Node implements Cloneable {
		public int x;
		public int y;
		public int level;

		public Node(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}

		@Override
		public Node clone() {
			return new Node(x, y, level);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node cmp = (Node) o;
				return cmp.x == x && cmp.y == y;
			}
			return false;
		}

		@Override
		public String toString() {
			return x + ", " + y;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			String in = s.nextLine();
			String[] in2 = in.split(" ");

			String converter = "abcdefgh";
			String converter2 = "12345678";
			int x1 = converter.indexOf(in2[0].charAt(0));
			int y1 = converter2.indexOf(in2[0].charAt(1));
			int x2 = converter.indexOf(in2[1].charAt(0));
			int y2 = converter2.indexOf(in2[1].charAt(1));

			int[][] matrix = new int[8][8];

			Node end = new Node(x2, y2, 9999);

			Queue<Node> nodes = new LinkedList<Node>();

			nodes.add(new Node(x1, y1, 0));

			//Node parent = new Node(x1, y1, 0);
			while (!nodes.isEmpty()) {
				Node n = nodes.remove();
				//System.out.print("checking " + parent + " to " + n);

				// precheck
				if (n.x < 0 || n.y < 0 || n.x >= 8 || n.y >= 8) {
				//	System.out.println(" | out");
					continue;
				}

				if (n.equals(end)) {
					//System.out.println(" | done");
					System.out.println(
							"To get from " + in2[0] + " to " + in2[1] + " takes " + n.level + " knight moves.");
					break;
				}

				if (matrix[n.x][n.y] != 0) {
				//	System.out.println(" | taken");
					continue;
				}
				matrix[n.x][n.y] = 1;

				// advance search
				nodes.add(new Node(n.x + 1, n.y - 2, n.level + 1));
				nodes.add(new Node(n.x + 2, n.y - 1, n.level + 1));
				nodes.add(new Node(n.x + 2, n.y + 1, n.level + 1));
				nodes.add(new Node(n.x + 1, n.y + 2, n.level + 1));
				nodes.add(new Node(n.x - 1, n.y + 2, n.level + 1));
				nodes.add(new Node(n.x - 2, n.y + 1, n.level + 1));
				nodes.add(new Node(n.x - 2, n.y - 1, n.level + 1));
				nodes.add(new Node(n.x - 1, n.y - 2, n.level + 1));

				//parent = n;
			}

		}
		s.close();
	}
}
