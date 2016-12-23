package ccc.s2008;

import java.util.Scanner;

public class ccc08s4 {

	static int[] c;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			c = new int[4];

			c[0] = s.nextInt();
			c[1] = s.nextInt();
			c[2] = s.nextInt();
			c[3] = s.nextInt();
			visited = new boolean[4];
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < 4; j++) {
				visited[j] = true;
				max = Math.max(Math.min(24, f(c[j])), max);
				visited[j] = false;
			}
			System.out.println(max);
		}
		s.close();
	}

	static boolean[] visited;

	static int f(int sum) {
		int max = Integer.MIN_VALUE;
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (!visited[i]) {
				visited[i] = true;
				flag = false;

				int val = f(sum + c[i]);
				if (val <= 24)
					max = Math.max(val, max);

				val = f(sum - c[i]);
				if (val <= 24)
					max = Math.max(val, max);

				val = f(sum * c[i]);
				if (val <= 24)
					max = Math.max(val, max);

				if (sum % c[i] == 0) {
					val = f(sum / c[i]);
					if (val <= 24)
						max = Math.max(val, max);
				}

				visited[i] = false;
			}
		}

		if (flag)
			if (sum <= 24)
				max = sum;
		return max;
	}

}
