package algorithms;

import java.util.Scanner;

public class LineSegmentTree {

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

	static int middle(int startIdx, int endIdx) {
		return (startIdx + endIdx) >> 1;
	}

	static int findRight(int[] arr, int startIdx, int endIdx, int currNode, int val) {
//		System.out.println("Traversing range ["+startIdx+", "+endIdx+"] for "+val);
		// found
		if (startIdx == endIdx) {
			return startIdx;
		}

		int mid = middle(startIdx, endIdx);
		int rightIdx = currNode * 2 + 2;
//		System.out.print(" Right val is "+arr[rightIdx]);
		
		// check left
		if (arr[rightIdx] >= val) {
//			System.out.println("  - big enough. Checking right");
			return findRight(arr, mid+1, endIdx, rightIdx, val);
		}

//		System.out.println(" - too small. checking left");
		// check right (remove number )
		val -= arr[rightIdx];
		return findRight(arr, startIdx, mid, currNode * 2+1, val);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Data size:");
		int d = s.nextInt();
		int[] data = new int[d + 1];
		int[] tree = init(d);
		for (int i = 0; i <= d; i++) {
			data[i] = i % 2;
		}
		construct(tree, data, 0, d, 0);
		System.out.println("Query");
		while (s.hasNext()) {
			String q = s.next();
			if (q.equals("Q")) {
				int startIdx = s.nextInt();
				int endIdx = s.nextInt();
				System.out.println(query(tree, startIdx, endIdx, 0, d, 0));
			} else if (q.equals("M")) {
				int find = s.nextInt();
				System.out.println(findRight(tree, 0, d, 0, find));
			}else if(q.equals("L")){
				for(int i=0;i<=d;i++){
					System.out.print(query(tree, i, i, 0, d, 0)+" ");
				}
				System.out.println();
			}
		}
		s.close();
	}

}
