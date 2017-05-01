package dmoj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Heavy light decomposition - way to split tree into queriable parts
//this example finds the min in the path between two nodes
public class utso15p5 {
	static class Edge {
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "[a=" +(a+1) + ", b="+(b+1)+", c=" + cost+"]";
		}
	}

	static int[] disjoint2;

	// represents a node and its connecting edge (need better name)
	static class NEdge {
		int a, c;

		public NEdge(int a, int cost) {
			this.a = a;
			this.c = cost;
		}

		@Override
		public String toString() {
			return "[a=" + (a+1) + ", c=" +c + "]";
		}
	}

	static int find(int x) {
		if (disjoint2[x] == x)
			return x;
		return disjoint2[x] = find(disjoint2[x]);
	}

	static boolean cmp(int x, int y) {
		return find(x) == find(y);
	}

	static void merge(int x, int y) {
		disjoint2[find(x)] = disjoint2[find(y)];
	}

	// methods for the tree
	static void construct() {
		for (int i = n - 1; i >= 0; --i)
			tree[i] = Math.max(tree[i << 1], tree[i << 1 | 1]);
	}

	static int querylst(int l, int r) {
		int res = 0;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if ((l & 1) == 1)
				res = Math.max(tree[l++], res);
			if ((r & 1) == 1)
				res = Math.max(tree[--r], res);
		}
		return res;
	}

	static int n;

	static ArrayList<ArrayList<NEdge>> adjlist;
	static int[] treesize; // stores subtree sizes
	static int[] special;// stores special child of each node
	static int[] weight;// stores weight connecting each node to its parent
	static int[] parent;// stores parent node, for use in dfs
	static int[] tree;// lst
	static int[] ptr;// pointer to position in lst
	static int[] height;// stores distance of node from parent
	static int[] disjoint;// weird thing to make lca faster
	static boolean[] visited;
//	static String[] done={
//			"3,0,75",
//			"4,0,90",
//			"5,3,29",
//			"4,2,98",
//			"3,2,62",
//			"0,5,100"
//	};

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> all=new ArrayList<>();
		n = s.nextInt();
		int m = s.nextInt();
		PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});

		for (int i = 0; i < m; i++) {
			int a = s.nextInt() - 1;
			int b = s.nextInt() - 1;
			int c = s.nextInt();
			Edge e = new Edge(a, b, c);
			q.add(e);
			all.add(e.toString());
		}
		s.close();
		if (m < n) {
			System.out.println(-1);
			return;
		}
		disjoint2 = new int[n];
		adjlist = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjlist.add(new ArrayList<>());
			disjoint2[i] = i;
		}

		int mst = 0;
		ArrayList<Edge> other = new ArrayList<>();
		while (!q.isEmpty()) {
			Edge next = q.remove();
			if (!cmp(next.a, next.b)) {
				merge(next.a, next.b);
				mst += next.cost;
				adjlist.get(next.a).add(new NEdge(next.b, next.cost));
				adjlist.get(next.b).add(new NEdge(next.a, next.cost));
			} else {
				other.add(next);
			}
		}
//		for(int i=0;i<n;i++){
//			System.out.print((i+1)+":");
//			for(NEdge e:adjlist.get(i)){
//				System.out.print(e);
//			}
//			System.out.println();
//		}
		int root = 0;
		visited = new boolean[n];
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
		weight[root] = 0;
		
//		System.out.println("mst="+mst);

		dfs(root);

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				System.out.println(-1);
				return;
			}
		}

		hld(root);
		construct();

		int min = Integer.MAX_VALUE;

		for (Edge e : other) {
//			System.out.println("Testing to replace "+e);
			int remove = query(e.a, e.b);
//			System.out.println("  Max in cycle: "+remove);
			int add = e.cost;
			int newmst = mst - remove + add;
//			System.out.println("  alt:"+newmst);
			if (newmst <= mst)
				continue;
			if (newmst < min) {
				min = newmst;
//				System.out.println("   setting.");
			}
		}

//		if (min == 228) {
//			// throw new lol_exception();
////			oureout:for(int i=0;i<m;i++){
////				for(int j=0;j<done.length;j++){
////					if(done[j].equals(all.get(i)))
////						continue oureout;
////				}
////				System.out.println(all.get(i));
////			}
//		} else {

			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
//			while (true) {
//				System.out.print("Enter query A: ");
//				int a = s.nextInt()-1;
//				System.out.print("Enter query B: ");
//				int b = s.nextInt()-1;
//
//				System.out.println("Max is: " + query(a, b));
//			}
//		}
	}

	// goes through the tree and fills in information about nodes
	static void dfs(int i) {
		visited[i] = true;
		treesize[i] = 1;
		int best = -1;
		// set to -1 if there is no special child
		int tmpSpecial = -1;
		for (NEdge adj : adjlist.get(i)) {
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
		for (NEdge adj : adjlist.get(i)) {
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
			return querylst(ptr[a]+1, ptr[b] + 1);
		}

		// recursive alg:
		// - basically a 2 pointers
		// - traverse whichever segment is the furthest from the root

		if (height[disjoint[a]] > height[disjoint[b]])
			return Math.max(query(parent[disjoint[a]], b), querylst(ptr[disjoint[a]], ptr[a] + 1));

		if (height[disjoint[b]] > height[disjoint[a]])
			return Math.max(query(a, parent[disjoint[b]]), querylst(ptr[disjoint[b]], ptr[b] + 1));

		if (height[a] > height[b])
			return Math.max(query(parent[disjoint[a]], b), querylst(ptr[disjoint[a]], ptr[a] + 1));

		if (height[b] > height[a])
			return Math.max(query(a, parent[disjoint[b]]), querylst(ptr[disjoint[b]], ptr[b] + 1));

		return Math.max(query(parent[disjoint[a]], b), querylst(ptr[disjoint[a]], ptr[a] + 1));

		// throw new RuntimeException("EORROR");
	}

}