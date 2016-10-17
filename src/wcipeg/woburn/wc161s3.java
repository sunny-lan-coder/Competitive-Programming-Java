package wcipeg.woburn;
import java.util.Arrays;
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

		int totalTimeThere = 0;
		int totalTimeBack = 0;
		int lastpoint = 0;
		int treatsum = 0;
		for (int i = 0; i < n; i++) {
			totalTimeThere += houses[i].p - lastpoint;
			totalTimeThere += t;
			totalTimeBack += houses[i].p - lastpoint;
			if (totalTimeThere + totalTimeBack > m) {
				break;

			} else {
				treatsum += houses[i].c;
			}
			lastpoint = houses[i].p;
		}

		System.out.println(treatsum);
	}

}
