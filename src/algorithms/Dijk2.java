package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijk2 {

	public static void main(String[] args) {
		int n = 100;
		int src = 0;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		ArrayList<ArrayList<Integer>> w = new ArrayList<>();
		int[] du = new int[n];
		for (int i = 0; i < n; i++)
			du[i] = Integer.MAX_VALUE;
		du[src] = 0;
		
		PriorityQueue<Integer> nodes = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(du[o1], du[o2]);
			}
		});
		
		nodes.add(src);
		boolean[] visited = new boolean[n];
		while (!nodes.isEmpty()) {
			int i = nodes.remove();
			if (!visited[i])
				for (int x = 0; x < adj.get(i).size(); x++) {
					int j = adj.get(i).get(x);
					int side = w.get(i).get(x);
					du[j] = Math.min(du[j], du[i] + side);
					nodes.add(j);
				}
			visited[i] = true;

		}

	}

}
