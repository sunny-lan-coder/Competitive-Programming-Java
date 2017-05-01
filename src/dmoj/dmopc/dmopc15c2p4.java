package dmoj.dmopc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class dmopc15c2p4 {

	static class T implements Comparable<T> {
		int idx;
		long start, end;

		public T(int idx, long start, long end) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}

		@Override
		public int compareTo(T o) {
			return Long.compare(end, o.end);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] start = new long[n + 1];
		long[] end = new long[n + 1];
		long[] happiness = new long[n + 1];
		long[] dp = new long[n + 1];
		String[] tmp;
		PriorityQueue<T> q = new PriorityQueue<>();
		int[] animu = new int[n];
		for (int i = 0; i < n; i++) {
			animu[i] = n;
			tmp = br.readLine().split(" ");
			start[i] = Long.parseLong(tmp[0]);
			end[i] = Long.parseLong(tmp[1]);
			happiness[i] = Long.parseLong(tmp[2]);
			end[i] += start[i];
			while (!q.isEmpty()) {
				T t = q.peek();
				if (t.end <= start[i]) {
					animu[t.idx] = i;
					q.remove();
				} else
					break;
			}
			q.add(new T(i, start[i], end[i]));
			dp[i] = -1;
		}
		br.close();

		// for (int i = 0; i < n; i++) {
		// animu[i] = n;
		// for (int j = i + 1; j < n; j++) {
		// if (end[i] <= start[j]) {
		// animu[i] = j;
		// break;
		// }
		// }
		// }

		// animu[n - 1] = n;

		dp[0] = 0;

		long max = 0;
		for (int i = 0; i < n; i++) {
			// System.out.println("Currently at anime " + i + " => " +
			// happiness[i] + ", dp[i]=" + dp[i]);

			// pick the current anim and skip everything in between
			if (animu[i] != -1) {
				// System.out.println(" If its picked, will have to skip to
				// anime " + animu[i]);
				// System.out.println(" Happiness would be " + (dp[i] +
				// happiness[i]));
				dp[animu[i]] = Math.max(dp[animu[i]], dp[i] + happiness[i]);
				// System.out.println(" dp[" + animu[i] + "] = " +
				// dp[animu[i]]);
			} // skip the current anime

			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
			// System.out.println(" If it isn't picked, next happiness is " +
			// dp[i + 1]);
			// System.out.println(" dp[" + (i + 1) + "] = " + dp[i + 1]);

			max = Math.max(max, dp[i]);
		}
		max = Math.max(max, dp[n]);

		System.out.println(max);
	}

}
