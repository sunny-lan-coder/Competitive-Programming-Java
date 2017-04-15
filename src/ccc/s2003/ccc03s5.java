package ccc.s2003;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ccc03s5 {

	static class Edge {
		int dst;
		int w;

		public Edge(int dst, int weight) {
			this.dst = dst;
			this.w = weight;
		}

		@Override
		public String toString() {
			return "[dst=" + dst + ", w=" + w+"]";
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int c = s.nextInt();
		int r = s.nextInt();
		int d = s.nextInt();
		ArrayList<ArrayList<Edge>> adj = new ArrayList<>(c);
		for (int i = 0; i < c; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < r; i++) {
			int x = s.nextInt() - 1;
			int y = s.nextInt() - 1;
			int w = s.nextInt();
			adj.get(x).add(new Edge(y, w));
			adj.get(y).add(new Edge(x, w));
		}
		ArrayList<Integer> dsts = new ArrayList<>(d);
		for (int i = 0; i < d; i++) {
			dsts.add(s.nextInt() - 1);
		}
		s.close();

		boolean[] visited = new boolean[c];
		int[] du = new int[c];

		PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o2.w, o1.w);
			}
		});

		q.add(new Edge(0, Integer.MAX_VALUE));
		while (!q.isEmpty()) {
			Edge t = q.remove();
			if (visited[t.dst] || t.w < du[t.dst])
				continue;
			du[t.dst] = t.w;
			for (Edge a : adj.get(t.dst)) {
				int alt = Math.min(a.w, t.w);
				if (alt > du[a.dst]) {
					du[a.dst] = alt;
					q.add(new Edge(a.dst, alt));
				}
			}
			visited[t.dst] = true;
		}

		int min = Integer.MAX_VALUE;
		for (int idx : dsts) {
			min = Math.min(min, du[idx]);
		}
		System.out.println(min);
	}

}
