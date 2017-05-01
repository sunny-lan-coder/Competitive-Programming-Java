package dmoj.dmopc;

import java.util.ArrayList;
import java.util.Scanner;

public class dmopc14c2p5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		int m = s.nextInt();
		int[] degrees = new int[n];
		for (int x = 0; x < m; x++) {
			int i = s.nextInt() - 1;
			int j = s.nextInt() - 1;
			adj.get(i).add(j);
			degrees[i]++;
		}
		s.close();

		double[] dp = new double[n];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			double prob = dp[i] / adj.get(i).size();
			for (int neigh : adj.get(i)) {
				dp[neigh] += prob;
			}
		}

		for (int i = 0; i < n; i++)
			if (degrees[i] == 0)
				System.out.println(fmt(dp[i]));

	}
	
	static String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}

}
