package uva;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P469 {
	static int n;
	static int m;

	static class Node {
		public int i;
		public int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		s.nextLine();
		for (int testCase = 0; testCase < cases; testCase++) {
			n = 0;
			m = 0;
			char[][] matrix = new char[100][100];
			String line = s.nextLine();
			char first = line.charAt(0);
			while (first == 'L' || first == 'W') {
				m = line.length();
				for (int j = 0; j < 0; j++) {
					matrix[n][j] = line.charAt(j);
				}
				line = s.nextLine();
				first = line.charAt(0);
				n++;
			}

			while (line != "") {
				String[] split = line.split(" ");
				int i = Integer.parseInt(split[0]);
				int j = Integer.parseInt(split[1]);
				// System.out.println("bfs");
				Queue<Node> toExpand = new LinkedList<Node>();
				toExpand.add(new Node(i, j));
				int count = 0;
				while (!toExpand.isEmpty()) {
					Node currentNode = toExpand.remove();
					count++;
					// for(State s:toExpand){
					// System.out.print("("+s.i+","+s.j+"), ");
					// }
					// System.out.println();

					// check node:
					// bounds
					if (currentNode.i < 0 || currentNode.j < 0 || currentNode.i >= n || currentNode.j >= m)
						continue;

					// diff languagge
					if (matrix[currentNode.i][currentNode.j] != 'W')
						continue;

					// System.out.println("expanding
					// "+currentNode.i+","+currentNode.j+"="+map[][]);

					matrix[currentNode.i][currentNode.j] = '-';

					// expand:
					toExpand.add(new Node(currentNode.i + 1, currentNode.j));
					toExpand.add(new Node(currentNode.i - 1, currentNode.j));
					toExpand.add(new Node(currentNode.i, currentNode.j + 1));
					toExpand.add(new Node(currentNode.i, currentNode.j - 1));
				}

				System.out.println(count);
			}
		}
		s.close();
	}

}
