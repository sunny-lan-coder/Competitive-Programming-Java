package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {

	static class Edge {
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "[a=" + a + ", c=" + cost + "]";
		}
	}

	static int[] disjoint;

	public static void main(String[] args) {
		PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		for (int i = 0; i < m; i++) {
			int a = s.nextInt() - 1;
			int b = s.nextInt() - 1;
			int c = s.nextInt();
			q.add(new Edge(a, b, c));
			q.add(new Edge(b, a, c));
		}

		s.close();

		ArrayList<ArrayList<Edge>> adj = new ArrayList<>(n);

		disjoint = new int[n];
		for (int i = 0; i < n; i++) {
			disjoint[i] = i;
			adj.add(new ArrayList<>());
		}

		while (!q.isEmpty()) {
			Edge next = q.remove();
			if (!cmpSet(next.a, next.b)) {
				merge(next.a, next.b);
				adj.get(next.a).add(new Edge(next.b,next.a,next.cost));
				adj.get(next.b).add(new Edge(next.a,next.b,next.cost));
			}
		}

		for (int i = 0; i < n; i++) {
			ArrayList<Edge> row = adj.get(i);
			if (!row.isEmpty()) {
				System.out.print(i + ": ");
				System.out.println(row);
			}
		}

	}

	static int find(int x) {
		if (disjoint[x] == x)
			return x;
		return disjoint[x] = find(disjoint[x]);
	}

	static boolean cmpSet(int x, int y) {
		return find(x) == find(y);
	}

	static void merge(int x, int y) {
		disjoint[find(y)] = disjoint[find(x)];
	}

}
