package wcipeg.woburn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class wc161s3 {
	static class House implements Comparable<House> {
		public final int p;
		public final int c;

		public House(int p, int c) {
			this.p = p;
			this.c = c;
		}

		@Override
		public int compareTo(House o) {
			return Integer.compare(p, o.p);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int t = s.nextInt();
		House[] houses = new House[n];
		for (int i = 0; i < n; i++) {
			int p = s.nextInt();
			int c = s.nextInt();
			houses[i] = new House(p, c);
		}
		s.close();
		Arrays.sort(houses);

		int sum = 0;
		int max = 0;
		PriorityQueue<Integer> best = new PriorityQueue<>();

		for (int i = 0; i < houses.length; i++) {
			House h = houses[i];
			int p = h.p;
			int c = h.c;

			int timeleft = m - 2 * p;
			if (timeleft < t)
				break;

			best.add(c);
			sum += c;

			while (!best.isEmpty() && t * best.size() > timeleft) {
				sum -= best.remove();
			}

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

}
