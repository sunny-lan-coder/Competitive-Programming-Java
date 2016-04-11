package wcipeg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ccoqr16p2 {
	static List<List<Integer>> adj;
	static int[] K;
	static int[] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		adj = new ArrayList<List<Integer>>(N);
		dp = new int[N];
		K = new int[N];
		for (int i = 0; i < N; i++) {
			int k = s.nextInt();
			K[i] = k;
			List<Integer> connect = new ArrayList<>(k);
			for (int j = 0; j < k; j++) {
				connect.add(s.nextInt() - 1);
			}
			adj.add(connect);
		}
		int Q = s.nextInt();
		for (int i = 0; i < Q; i++) {
			int r = s.nextInt();

		}
		s.close();
	}

	static int cyclesize(int node, int from, int dest) {
		if (dp[dest] != -1)
			return dp[dest];
		int sum = 0;
		while (node != dest) {
			
		}
		return sum;
	}
}
