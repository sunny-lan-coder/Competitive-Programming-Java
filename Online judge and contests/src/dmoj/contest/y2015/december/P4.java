package dmoj.contest.y2015.december;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4 {

	static long[] xA;
	static long[] yA;
	static long[][] time;
	static long[] squares;

	static long time(int a, int b) {
		long r;
		if (time[a][b] == 0) {
			long x = abs(xA[a] - xA[b]);
			long y = abs(yA[a] - yA[b]);
			r = (long) (pow(x, 2) + pow(y, 2));
			time[a][b] = r;
			time[b][a] = r;
		} else {
			r = time[a][b];
		}
		return r;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int N = Integer.parseInt(bi.readLine());
		xA = new long[N];
		yA = new long[N];
		time = new long[N][N];
		for (int i = 0; i < N; i++) {
			line = bi.readLine().split("\\s");
			xA[i] = Long.parseLong(line[0]);
			yA[i] = Long.parseLong(line[1]);
		}

		int X = Integer.parseInt(bi.readLine()) - 1;

		// dijkstra
		long[] du = new long[N];
		for (int i = 0; i < N; i++)
			du[i] = -1;
		du[X] = 0;
		boolean[] visited = new boolean[N];

		while (true) {
			int minNode = 0;
			long minVal = -1;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					if (sl(du[i], minVal)) {
						minVal = du[i];
						minNode = i;
					}
				}
			}

			if (minVal == -1)
				break;

			for (int j = 0; j < N; j++) {
				if (du[j] == -1) {
					du[j] = minVal + time(minNode, j);
					continue;
				}

				if (!visited[j])
					if (sl(minVal + time(minNode, j), du[j])) {
						du[j] = minVal + time(minNode, j);
					}
			}

			visited[minNode] = true;
		}

		int Q = Integer.parseInt(bi.readLine());

		Arrays.sort(du);
		du = Arrays.copyOf(du, N + 1);
		du[N] = Long.MAX_VALUE;

		for (int i = 0; i < Q; i++) {
			long FiM = Long.parseLong(bi.readLine());

			int high = N + 1;
			int low = 0;
			int guess;

			while (true) {
				guess = (int) Math.floor((high + low) / 2d);
				long a = du[guess];
				long b = du[guess + 1];
				if (a <= FiM && b > FiM) {
					break;
				} else if (b <= FiM) {
					low = guess;
				} else if (a > FiM) {
					high = guess;
				}
			}
			System.out.println(guess + 1);
		}
	}

	static long infinity = -1;

	static boolean sl(long a, long b) {
		if (a == infinity && b != infinity)
			return false;
		if (a != infinity && b == infinity)
			return true;
		if (a == infinity && b == infinity)
			return false;
		return a < b;
	}
}
