package ccc.s2015;

import java.util.Scanner;

public class ccc15s3 {

	// divide the thing into segments, so we can efficiently find the sum of a
	// whole range
	static class Segment {
		// store reference to the left and right half of this segment
		public Segment left;
		public Segment right;
		// total sum of left and right
		public int sum;
		// end index of this segment
		public int end;
		// begin index of this segment
		public int begin;
		// six of the segment
		int size;

		public Segment(int begin, int end) {
			sum = 0;
			this.begin = begin;
			this.end = end;
			size = end - begin;
		}

		// try to increment
		public boolean tryAdd(int maxidx) {
			// if already full
			if (sum == size) {
				// then you cannot add anymore
				return false;
			}
			// if not full, and already at bottom segment, update
			if (size == 1) {
				sum++;
				return true;
			}

			// initialize subtrees if not yet initalized
			if (right == null) {
				right = new Segment((begin + end) / 2, end);
			}

			if (left == null) {
				left = new Segment(begin, (begin + end) / 2);
			}

			// if idx can go into right segment, try to add it there
			if (right.begin < maxidx) {
				// update right segment
				if (right.tryAdd(maxidx)) {
					// can be added to right side
					// update sum of parent segment
					sum++;
					return true;
				}

			}
			// If could not add to right side, then try add to left side
			if (left.tryAdd(maxidx)) {
				// update total sum
				sum++;
				return true;
			}

			// could not add anywhere
			
			return false;
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int g = s.nextInt();
		int p = s.nextInt();

		int[] gi = new int[p];

		for (int i = 0; i < p; i++) {

			gi[i] = s.nextInt();
		}
		s.close();

		int round = 1;
		do {
			round *= 2;
		} while (round < g);


		Segment root = new Segment(0, round);

		int count = 0;
		for (int i = 0; i <p; i++) {
			if (!root.tryAdd(gi[i]))

				break;

			count++;
		}

		System.out.println(count);

	}

}
