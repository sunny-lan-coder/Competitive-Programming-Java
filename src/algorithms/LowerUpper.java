package algorithms;

import java.util.Scanner;

public class LowerUpper {

	static int[] arr;

	static int s;

	static int bs(int low, int high) {
		 System.out.println("low="+low+", high="+high);
		

		int mid = (high + low) / 2;
		
		if (mid==low || mid==high)
			return -1;
		
		int e1 = arr[mid - 1];
		int e2 = arr[mid];

		 System.out.println(" a="+e1+", b="+e2);

		if (e2 == s) {
			return mid;
		}

		if (e1 < s) {
			return bs(mid-1, high);
		}

		if (e2 > s) {
			return bs(low, mid);
		}

		return -999;
	}

	static int bsu(int low, int high) {
		if (low > high - 1)
			return -1;
		// System.out.println("low="+low+", high="+high);
		int mid = (high + low) / 2;
		int e1 = arr[mid];
		int e2 = arr[mid - 1];

		// System.out.println(" a="+e1+", b="+e2);

		if (e2 == s) {
			return mid;
		}

		if (e1 < s) {
			return bsu(mid - 1, high);
		}

		if (e2 > s) {
			return bsu(low, mid);
		}

		return -999;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		LowerUpper.s = s.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(bs(0, n) + 1);
		System.out.println(bsu(0, n));
		s.close();
	}

}
