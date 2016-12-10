package algorithms;

import java.util.Scanner;

public class LineSegmentTree1 {

	static int[] init(int size) {
		return new int[4 * size];
	}

	static int construct(int[] arr, int[] data, int startIdx, int endIdx, int currNode) {
		if (startIdx == endIdx) {
			arr[currNode] = data[startIdx];
			return data[startIdx];
		}

		int mid = middle(startIdx, endIdx);

		int sum = construct(arr, data, startIdx, mid, currNode * 2 + 1)
				+ construct(arr, data, mid + 1, endIdx, currNode * 2 + 2);

		arr[currNode] = sum;

		return sum;
	}

	static int query(int[] arr, int queryStart, int queryEnd, int startIdx, int endIdx, int currNode) {
		if (startIdx > queryEnd || endIdx < queryStart) {
			return 0;
		}
		
		if (queryStart <= startIdx && queryEnd >= endIdx) {
			return arr[currNode];
		}

		int mid = middle(startIdx, endIdx);

		return query(arr, queryStart, queryEnd, startIdx, mid, currNode * 2 + 1)
				+ query(arr, queryStart, queryEnd, mid + 1, endIdx, currNode * 2 + 2);
	}

	static int update(int[] arr, int idx, int startIdx, int endIdx, int val, int currNode) {
		if (startIdx == endIdx) {
			arr[currNode] = val;
			return val;
		}

		int mid = middle(startIdx, endIdx);

		int sum;

		if (idx <= mid) {
			sum = update(arr, idx, startIdx, mid, val, currNode * 2 + 1) + arr[currNode * 2 + 2];
		} else {
			sum = update(arr, idx, mid + 1, endIdx, val, currNode * 2 + 2) + arr[currNode * 2 + 1];
		}

		arr[currNode] = sum;
		return sum;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Data size:");
		int d = s.nextInt();
		int[] data = new int[d + 10];
		int[] tree = init(d);
		for (int i = 0; i < d; i++) {
			data[i] = s.nextInt();
		}
		construct(tree, data, 0, d, 0);
		System.out.println("Query");
		while (s.hasNext()) {
			int startIdx = s.nextInt();
			int endIdx = s.nextInt();
			System.out.println(query(tree, startIdx, endIdx, 0, d, 0));
		}
		s.close();
	}

	static int middle(int startIdx, int endIdx) {
		return (startIdx + endIdx) >> 1;
	}

}
