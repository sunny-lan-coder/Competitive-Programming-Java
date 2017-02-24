package ccc.y2016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// Best path is if she goes across graph, from opposite end to other side. 
// Then she will only travel the diameter edges once, 
// and visit all the other edges twice (excluding useless ones)
// Useless edges are ones that don't go down to a pho
// Those can just get trimmed
public class ccc16s3 {
	static class T2 {
		public final int a, b;

		public T2(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static ArrayList<HashSet<Integer>> adj;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int currpho=-1;
		boolean[] pho = new boolean[n];
		for (int i = 0; i < m; i++)
			pho[currpho=s.nextInt()] = true;
		adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			adj.add(new HashSet<>());
		int[] degs = new int[n];
		for (int i = 0; i < n - 1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
			degs[a]++;
			degs[b]++;
		}
		s.close();
		boolean[] removed = new boolean[n];
		int newn=n;
		while (true) {
			int i = 0;
			for (; i < n; i++) {
				if (degs[i] == 1 && !removed[i] && !pho[i])
					break;
			}
			if (i == n)
				break;
			for (int j : adj.get(i)) {
				degs[i]--;
				degs[j]--;
				adj.get(i).remove(j);
				adj.get(j).remove(i);
				
			}
			newn--;
			removed[i] = true;
		}
		visited = new boolean[n];
		int pivot = dfs(currpho).a;
		visited = new boolean[n];
		T2 thing= dfs(pivot);
		int dist =thing.b;
		int edges=(newn-1);
		int other=2*(edges-dist);

		
		System.out.println(dist+other);
	}

	static boolean[] visited;

	
	static T2 dfs(int node) {
		int idx = node;
		int max = 0;
		visited[node] = true;
		for (int neigh : adj.get(node)) {

			if(visited[neigh])
				continue;
			T2 u = dfs(neigh);
			if (u.b + 1 > max) {
				max = u.b+1;
				idx = u.a;
			}
			

		}

		return new T2(idx, max);
	}

}
