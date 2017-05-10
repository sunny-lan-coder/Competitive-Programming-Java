package dmoj.dmopc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class dmopc14c4p6 {

	static ArrayList<ArrayList<Integer>> adj;

	static ArrayList<HashMap<Integer, Integer>> dp;

	static int f(int i, int j) {
		if (dp.get(i).containsKey(j))
			return dp.get(i).get(j);

		int res = 0;
		for (int neigh : adj.get(i))
			if (neigh != j)
				res = Math.max(res, f(neigh, i));

		dp.get(i).put(j, ++res);

		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		adj = new ArrayList<>(n);
		dp = new ArrayList<>(n);
		adj.add(new ArrayList<>());
		dp.add(new HashMap<>());
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<>());
			dp.add(new HashMap<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		s.close();
		for (int i = 0; i < n; i++) {
			System.out.println(f(i, -1));
		}
	}

}
