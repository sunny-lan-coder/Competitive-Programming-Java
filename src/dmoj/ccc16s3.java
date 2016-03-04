package dmoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ccc16s3 {
	static class Node {
		public boolean pho;
		private final List<Node> adj;
		public int degree;
		public int idx;

		public Node(int idx) {
			this.degree = 0;
			adj = new ArrayList<>();
			this.pho = false;
			this.idx = idx;
		}

		public List<Node> adj() {
			return Collections.unmodifiableList(adj);
		}

		public void addAdj(Node n) {
			degree++;
			adj.add(n);
		}

		public void removeAdj(Node n) {
			if (adj.contains(n)) {
				degree--;
				adj.remove(n);
			}
		}
	}

	static Node[] nodes;
	static int N;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		int M = s.nextInt();
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < M; i++) {
			nodes[s.nextInt()].pho = true;
		}

		for (int i = 0; i < N - 1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			nodes[a].addAdj(nodes[b]);
			nodes[b].addAdj(nodes[a]);
		}
		s.close();

		visited = new boolean[N];
		
		Queue<Node> toRemove = new LinkedList<>();
		for (Node next : nodes) {
			if (next.degree == 1 && !next.pho && !visited[next.idx]) {
				Node n = next.adj().get(0);
				n.removeAdj(next);
				next.removeAdj(n);
				toRemove.add(n);
				visited[next.idx]=true;
			}
		}
		while (!toRemove.isEmpty()) {
			Node next = toRemove.remove();
			if (next.degree == 1 && !next.pho && !visited[next.idx]) {
				Node n = next.adj().get(0);
				n.removeAdj(next);
				next.removeAdj(n);
				toRemove.add(n);
				visited[next.idx]=true;
			}
		}

		int tmp = 0;
		for (int i = 0; i < N; i++) {
			if (nodes[i].degree > 0) {
				tmp++;
			}
		}
		//
		// for (int i = 0; i < N; i++) {
		// Node n = nodes[i];
		// if (n.degree > 0) {
		// System.out.println("node " + n.idx + ", degree=" + n.degree + ",
		// pho=" + n.pho);
		// }
		// }

		int D = -1;
		for (int i = 0; i < N; i++) {
			Node n = nodes[i];
			if (n.degree > 0) {
				D = n.idx;
				break;
			}
		}
		// System.out.println("d=" + D);
		visited = new boolean[N];

		int[] T = furthest(D);
		// System.out.println("furthest node " + T[1] + ", dist " + T[0]);

		visited = new boolean[N];
		int[] t = furthest(T[1]);
		int dist = 2 * (tmp - 1) - t[0];
		// System.out.println("furthest node " + t[1] + ", dist " + t[0]);
		System.out.println(dist);
	}

	static boolean[] visited;
	static int[] tmp = new int[2];

	static int[] furthest(int i) {
		visited[i] = true;
		int max = 0;
		int maxidx = -1;
		for (Node n : nodes[i].adj()) {
			if (n.degree > 0 && !visited[n.idx]) {
				int[] v = furthest(n.idx);
				if (v[0] + 1 > max) {
					max = v[0] + 1;
					maxidx = v[1];
				}
			}
		}
		if (maxidx == -1) {
			tmp[0] = 0;
			tmp[1] = i;
			return tmp;
		}
		tmp[0] = max;
		tmp[1] = maxidx;
		return tmp;
	}
}
