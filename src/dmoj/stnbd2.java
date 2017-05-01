package dmoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class stnbd2 {

	static int n;
	static int mod = 1000000007;
	static int[] dI, dO;
	static long[] cnt;
	static long[] len;
	static ArrayList<ArrayList<Integer>> adjlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		int m =Integer.parseInt(tmp[1]);
		dI = new int[n];
		dO = new int[n];
		cnt = new long[n];
		len = new long[n];
		adjlist = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int v = 0; v < m; v++) {
			tmp=br.readLine().split(" ");
			int i = Integer.parseInt(tmp[0]) - 1;
			int j = Integer.parseInt(tmp[1]) - 1;

			adjlist.get(i).add(j);
			dI[j]++;
			dO[i]++;
		}
		br.close();

		Queue<Integer> next = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (dI[i] == 0) {
				next.add(i);
				cnt[i] = 1;
			}
		}

		long sum = 0;
		while (!next.isEmpty()) {
			int i = next.remove();
			if (dO[i] == 0)
				sum = (sum + (len[i])) % mod;

			for (int adj : adjlist.get(i)) {
				len[adj] = (len[adj] + len[i] + cnt[i]) % mod;
				cnt[adj] = (cnt[adj] + cnt[i] ) % mod;
				dI[adj]--;
				if (dI[adj] == 0 )
					next.add(adj);
				
			}

		}

		
		System.out.println(sum);

	}

}
