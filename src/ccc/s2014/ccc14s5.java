package ccc.s2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ccc14s5 {
	static class T2 {
		public final int a;
		public final int b;

		public T2(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static ArrayList<ArrayList<T2>> adj;
	static int[] x;
	static int[] y;

	static HashMap<Integer, HashMap<Integer, Integer>> dp;

	static void add(int n, int dist, int val) {
		if (!dp.containsKey(n))
			dp.put(n, new HashMap<>());
		dp.get(n).put(dist, val);
	}

	static int get(int n, int dist) {
		if (!dp.containsKey(n))
			return -1;
		if (!dp.get(n).containsKey(dist))
			return -1;
		return dp.get(n).get(dist);
	}

//	static String indent = "";

	static int max(int n, int dist) {
//		indent += " ";
//		System.out.print(indent + "node ");
//		pp(n);
//		System.out.println("dist " + dist);
		int ret = get(n, dist);
		if (ret == -1) {
			ret = 0;
			for (T2 neigh:adj.get(n)) {

				if (neigh.b >= dist)
					break;
				ret = Math.max(ret, max(neigh.a, neigh.b) + 1);
			}
			add(n, dist, ret);
		}

//		System.out.println(indent + "res " + ret);
//		indent = indent.substring(1);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s;
		x = new int[n];
		y = new int[n];
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			x[i] = Integer.parseInt(s[0]);
			y[i] = Integer.parseInt(s[1]);
		}
		br.close();
		adj = new ArrayList<>(n);
		dp = new HashMap<>();
		int[] dists = new int[n];
		for (int i = 0; i < n; i++) {
			ArrayList<T2> arr = new ArrayList<>();

			int ax = x[i];
			int ay = y[i];
			{
				int dx = Math.abs(ax);
				int dy = Math.abs(ay);
				dists[i] = dx * dx + dy * dy;
			}

			for (int j = 0; j < n; j++) {
				if (j != i) {
					int dx = Math.abs(ax - x[j]);
					int dy = Math.abs(ay - y[j]);
					arr.add(new T2(j, dx * dx + dy * dy));
				}
			}

			arr.sort(new Comparator<T2>() {

				@Override
				public int compare(T2 o1, T2 o2) {
					return Integer.compare(o1.b, o2.b);
				}
			});

			adj.add(arr);
		}

//		for (int i = 0; i < n; i++) {
//			ArrayList<T2> arr = adj.get(i);
//			pp(i);
//			System.out.print(" -> ");
//			for(T2 two:arr){
//				pp(two.a);
//				System.out.print("="+two.b+", ");
//			}
//			System.out.println();
//		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, max(i, dists[i]) + 1);
		}
		System.out.println(max);
	}

//	static void pp(int n) {
//		System.out.print("(" + x[n] + ", " + y[n] + ")");
//	}

}
