package ccc.y2015;

import java.util.Arrays;
import java.util.Scanner;

public class S3 {

	static class Segment {
		public Segment left;
		public Segment right;
		public int sum;
		public int end;
		public int begin;
		int size;

		public Segment(int begin, int end) {
			sum = 0;
			this.begin = begin;
			this.end = end;
			size = end - begin;
		}

		public boolean tryAdd(int maxidx) {
			if (sum == size)
				return false;
			if (size == 1) {
				sum++;
				return true;
			}

			if (right == null || right.begin < maxidx) {
				if (right == null) {
					right = new Segment((begin + end) / 2, end);
				}
				if (right.tryAdd(maxidx)) {
					sum++;
					return true;
				}

			}

			if (left == null) {
				left = new Segment(begin, (begin + end) / 2);
				if (left.tryAdd(maxidx)) {
					sum++;
					return true;
				}
			}

			return false;
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int g = s.nextInt();
		int p = s.nextInt();

		int[] gi = new int[p];

		for (int i = 0; i < p; i++) {

			gi[i] = s.nextInt()-1;
		}
		s.close();

		int round = 1;
		do {
			round *= 2;
		} while (round < g);

		Arrays.sort(gi);

		Segment root = new Segment(0, round );

		int count = 0;
		for (int i = p - 1; i >= 0; i--) {
			if (!root.tryAdd(gi[i]))

				break;

			count++;
		}

		System.out.println(count);

	}

}
