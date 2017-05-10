package algorithms;

import java.util.Scanner;

//It may seem easy, but its annoying AF
public class BinarySearch {

	static int n;
	static int[] v;

	// searches for a target in a given range
	static int bs(int t) {
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (t == v[mid])
				return mid;
			else if (v[mid] < t)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return -1;
	}

	// finds the last value x that makes v[x]<=t
	static int lb(int t) {
		int lo = 0;
		int hi = n - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			if (v[mid] <= t)
				lo = mid;
			else
				hi = mid - 1;
		}
		if (v[lo] > t)
			return -1;
		return lo;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		v = new int[n];

		for (int i = 0; i < n; i++)
			v[i] = s.nextInt();

		while (s.hasNext()) {
//			System.out.println(bs(s.nextInt()));
			System.out.println(lb(s.nextInt()));
		}
		s.close();
	}

}
