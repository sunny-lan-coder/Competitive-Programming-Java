package algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//Priority queue implementation of dijkstras
//this version is custy and may not be fast
public class Dijk2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int src = 0;
		int m = s.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		ArrayList<ArrayList<Integer>> w = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
			w.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int x, y, z;
			x = s.nextInt() - 1;
			y = s.nextInt() - 1;
			z = s.nextInt();
			adj.get(x).add(y);
			w.get(x).add(z);
			adj.get(y).add(x);
			w.get(y).add(z);
		}
		s.close();

		int[] du = new int[n];
		for (int i = 0; i < n; i++)
			du[i] = Integer.MAX_VALUE;
		du[src] = 0;

		PriorityQueue<Integer> nodes = new PriorityQueue<Integer>((o1, o2) -> {
			return Integer.compare(du[o1], du[o2]);
		});

		nodes.add(src);
		boolean[] visited = new boolean[n];
		while (!nodes.isEmpty()) {
			int i = nodes.remove();
			if (!visited[i]) {
				// System.out.println("curr node: " + i);

				for (int x = 0; x < adj.get(i).size(); x++) {
					int j = adj.get(i).get(x);
					// System.out.println(" Check node: " + j);
					int side = w.get(i).get(x);
					// System.out.println(" Weight: " + side);
					int alt = du[i] + side;
					// System.out.println(" alt: " + alt);
					if (alt < du[j]) {
						du[j] = alt;
						nodes.add(j);
					}
				}
			}
			visited[i] = true;

		}

		for (int i : du) {
			if (i == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(i);
		}

	}

}
