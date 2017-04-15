package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

//Heavy light decomposition - way to split tree into queriable parts
public class HLD {
	static class Edge {
		int a, c;

		public Edge(int a, int cost) {
			this.a = a;
			this.c = cost;
		}

		@Override
		public String toString() {
			return "[a=" + a + ", c=" + c + "]";
		}
	}

	static void construct() {
		for (int i = n - 1; i >= 0; i--)
			tree[i] = Math.max(tree[i << 1], tree[i << 1 | 1]);
	}

	static int querylst(int l, int r) {
		int res = -1;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if ((l & 1) == 1)
				res = Math.max(tree[l++], res);
			if ((r & 1) == 1)
				res = Math.max(tree[--r], res);
		}
		return res;
	}

	static int n;

	static ArrayList<ArrayList<Edge>> adjlist;
	static int[] treesize; // stores subtree sizes
	static int[] special;// stores special child of each node
	static int[] weight;// stores weight connecting each node to its parent
	static int[] parent;// stores parent node, for use in dfs
	static int[] tree;// lst
	static int[] ptr;// pointer to position in lst
	static int[] height;// stores distance of node from parent
	static int[] disjoint;// weird thing to make lca faster

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		adjlist = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int a = s.nextInt() - 1;
			int b = s.nextInt() - 1;
			int c = s.nextInt();

			adjlist.get(a).add(new Edge(b, c));
			adjlist.get(b).add(new Edge(a, c));

		}
		int root = s.nextInt() - 1;
		treesize = new int[n];
		special = new int[n];
		weight = new int[n];
		parent = new int[n];
		ptr = new int[n];
		height = new int[n];
		disjoint = new int[n];
		// init disjoint
		for (int i = 0; i < n; i++)
			disjoint[i] = i;

		// line segment tree will contain n-1 edges from tree, plus one dummy
		// edge
		tree = new int[n * 2];

		// create dummy edge to use in lst
		weight[root] = -1;

		dfs(root);
		hld(root);
		construct();

		while (true) {
			System.out.print("Enter query A: ");
			int a = s.nextInt()-1;
			System.out.print("Enter query B: ");
			int b = s.nextInt()-1;

			System.out.println("Max is: " + query(a, b));
		}
	}

	// goes through the tree and fills in information about nodes
	static void dfs(int i) {
		treesize[i] = 1;
		int best = -1;
		// set to -1 if there is no special child
		int tmpSpecial = -1;
		for (Edge adj : adjlist.get(i)) {
			// avoid going back up a tree
			if (adj.a == parent[i])
				continue;
			parent[adj.a] = i;
			// remember weight connecting to edge
			weight[adj.a] = adj.c;
			height[adj.a] = height[i] + 1;
			dfs(adj.a);
			treesize[i] += treesize[adj.a];
			// subtree with biggest size is the special child
			if (treesize[adj.a] > best) {
				best = treesize[adj.a];
				tmpSpecial = adj.a;
			}
		}
		special[i] = tmpSpecial;
	}

	// store current pos in line segment tree
	static int curridx = 0;

	// applies heavy light decomposition to tree
	static void hld(int i) {
		// store in lsc
		tree[n + curridx] = weight[i];
		ptr[i] = curridx; // store position in lsc
		curridx++;

		// if special exists, must do it first
		if (special[i] != -1) {
			// path compression
			disjoint[special[i]] = disjoint[i];
			hld(special[i]);
		}

		// recursively hld for each child, make sure to skip special child, and
		// don't go back to parent
		for (Edge adj : adjlist.get(i)) {
			if (adj.a != special[i] && adj.a != parent[i]) {
				hld(adj.a);
			}
		}
	}

	// finds the max edge in the path between two thingies
	static int query(int a, int b) {
		// if they are in the same chain
		if (disjoint[a] == disjoint[b]) {
			// make sure smaller index is first
			if (height[a] > height[b])
				return query(b, a);
			// get max from segment tree
			return querylst(ptr[a], ptr[b]);
		}

		// recursive alg:
		// - basically a 2 pointers
		// - traverse whichever segment is the furthest from the root

		if (height[disjoint[a]] > height[disjoint[b]])
			return Math.max(query(parent[disjoint[a]], b), querylst(ptr[disjoint[a]], ptr[a] + 1));

		if (height[disjoint[b]] > height[disjoint[a]])
			return Math.max(query(a, parent[disjoint[b]]), querylst(ptr[disjoint[b]], ptr[b] + 1));

		throw new RuntimeException("EORROR");
	}

}
