package duwei.tmp15;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		public final int idx;
		public final int dist;
		public final Node source;

		public Node(int idx, int dist, Node source) {
			this.idx = idx;
			this.dist = dist;
			this.source = source;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(dist, o.dist);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = 0;
		outer: while (s.hasNext()) {
			count++;
			int n = s.nextInt();
			int r = s.nextInt();
			int[][] mat = new int[n][n];
			for (int i = 0; i < r; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				int z = s.nextInt();
				mat[x][y] = z;
				mat[y][x] = z;
			}
			System.out.println("Set #" + count);
			int q = s.nextInt();
			for (int i = 0; i < q; i++) {
				int source = s.nextInt();
				int dest = s.nextInt();
				Node[] fdist = dist(mat, source, n);
				Node[] bdist = dist(mat, dest, n);
				if (fdist[dest] == null) {
					System.out.println("?");
					continue outer;
				}
				Node currnode = fdist[dest];
				int ans = Integer.MAX_VALUE;
				while (currnode != null) {
					int x = currnode.idx;
					for (int y = 0; y < n; y++) {
						if (mat[x][y] != 0) {
							int ux = fdist[x].dist;
							int xy = mat[x][y];
							int yv = bdist[y].dist;
							int pathCost = ux + xy + yv;
							if (pathCost > fdist[dest].dist && pathCost < ans) {
								ans = pathCost;
							}
						}
					}
					currnode = currnode.source;
				}

				System.out.println(ans);
			}
			s.next();
		}

		s.close();
	}

	static Node[] dist(int[][] mat, int source, int n) {
		Node[] result = new Node[n];
		PriorityQueue<Node> du = new PriorityQueue<>();
		du.add(new Node(source, 0, null));
		boolean[] visited = new boolean[n];
		while (!du.isEmpty()) {
			Node close = du.remove();
			if (visited[close.idx])
				continue;
			result[close.idx] = close;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && mat[close.idx][i] != 0) {
					du.add(new Node(i, close.dist + mat[close.idx][i], close));
				}
			}
			visited[close.idx] = true;
		}
		return result;
	}

}
