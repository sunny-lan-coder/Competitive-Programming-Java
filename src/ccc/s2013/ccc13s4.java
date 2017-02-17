package ccc.s2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ccc13s4 {
	static int n;
	static int m;
	static HashMap<Integer, ArrayList<Integer>> adj;
	static boolean[] visited;
	static int dst;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		adj = new HashMap<>();
		m = Integer.parseInt(tmp[1]);
		for (int i = 0; i < m; i++) {
			tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]) - 1;
			int y = Integer.parseInt(tmp[1]) - 1;
			if (!adj.containsKey(x))
				adj.put(x, new ArrayList<>());
			adj.get(x).add(y);
		}
		tmp = br.readLine().split(" ");
		int p = Integer.parseInt(tmp[0]) - 1;
		int q = Integer.parseInt(tmp[1]) - 1;
		// search p to q
		visited = new boolean[n];
		dst = q;
		if (dfs(p)) {
			System.out.println("yes");
			return;
		}
		visited = new boolean[n];
		dst = p;
		if (dfs(q)) {
			System.out.println("no");
			return;
		}
		System.out.println("unknown");
	}

	static boolean dfs(int node) {
		if (node == dst)
			return true;

		if (visited[node])
			return false;

		if (!adj.containsKey(node))
			return false;

		boolean flag = false;
		for (int neigh : adj.get(node)) {
			flag |= dfs(neigh);
		}
		visited[node] = true;
		return flag;
	}

}
