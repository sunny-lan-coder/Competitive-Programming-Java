package wcipeg.woburn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class wc154j4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		long[] radii = new long[N];
		int[] points = new int[N];
		for (int i = 0; i < N; i++) {
			radii[i] = Integer.parseInt(br.readLine());
			radii[i] = radii[i] * radii[i];
		}
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(br.readLine());
		}

		long[] distances = new long[M];
		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int X = Integer.parseInt(line[0]);
			int Y = Integer.parseInt(line[1]);
			distances[i] = X * X + Y * Y;
		}

		Arrays.sort(radii);
		Arrays.sort(distances);

		int[] count = new int[N];

		int currentRing = 0;
		int currentShot = 0;
		while (currentShot < M && currentRing < N) {
			if (radii[currentRing] >= distances[currentShot]) {
				// the current shot is inside the ring
				count[currentRing]++;
				currentShot++;
			} else {
				// go to next ring
				currentRing++;
			}
		}

		Arrays.sort(count);
		Arrays.sort(points);

		int min = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			min += count[i] * points[N - i - 1];
			max += count[i] * points[i];
		}

		System.out.println(min);
		System.out.println(max);
	}
}
