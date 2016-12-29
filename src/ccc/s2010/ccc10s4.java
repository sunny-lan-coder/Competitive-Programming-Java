package ccc.s2010;

import java.util.HashMap;
import java.util.Scanner;

public class ccc10s4 {

	static class T {
		public final int a;
		public final int b;

		public T(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = m + 1;
		int[][] adj = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = -1;
			}
		}
		HashMap<Integer, T> edges = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int ep = s.nextInt();
			int[] c = new int[ep];
			int[] e = new int[ep];
			for (int j = 0; j < ep; j++) {
				c[j] = s.nextInt() - 1;
			}
			for (int j = 0; j < ep; j++) {
				e[j] = s.nextInt();
			}

			for (int j = 0; j < ep; j++) {
				int c1 = c[j];
				int c2 = c[(j + 1) % ep];
				int hash2 = c1 * 1000 + c2;
				int hash1 = c2 * 1000 + c1;
				T connection = null;
				if (edges.containsKey(hash1)) {
					connection = edges.get(hash1);
				}
				if (edges.containsKey(hash2)) {
					connection = edges.get(hash2);
				}
				if (connection != null) {
					if (adj[connection.a][i] == -1 || connection.b < adj[connection.a][i]) {
						adj[connection.a][i] = connection.b;
						adj[i][connection.a] = connection.b;
					}
					edges.remove(hash1);
					edges.remove(hash2);
				} else {
					edges.put(hash1, new T(i, e[j]));
				}
			}
		}
		s.close();
		for (int key : edges.keySet()) {
			T connection = edges.get(key);
			if (adj[connection.a][m] == -1 || connection.b < adj[connection.a][m]) {
				adj[connection.a][m] = connection.b;
				adj[m][connection.a] = connection.b;
			}
		}

		boolean[] visited = new boolean[n];
		int[] du = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = Integer.MAX_VALUE;
		}
		du[0] = 0;
		int[] src=new int[n];
		while (true) {
			int minval = -1;
			int minidx = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && (minval == -1 || du[i] < minval)) {
					minval = du[i];
					minidx = i;
				}
			}

			if (minidx == -1)
				break;

			visited[minidx] = true;

			for (int i = 0; i < n; i++) {
				int val = adj[minidx][i];
				if (!visited[i] && val != -1 && val < du[i]) {
					du[i] = val;
					src[i]=minidx;
				}
			}
		}

		int sum = 0;
		boolean flag=false;
		for (int i=0;i<m;i++) {
//			System.out.print (i+" ");
//			System.out.print(src[i]+" ");
//			System.out.println(du[i]);
			sum += du[i];
			if(src[i]==m)
				flag=true;
		}
		if(flag)
			sum+=du[m];
		System.out.println(sum);
	}

}
