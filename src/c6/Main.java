package c6;

import java.util.Scanner;

public class Main {
	static int[] data;
	static int n;
	static int nextopen;

	static int root(int node) {
		return node / 2;
	}

	static int left(int node) {
		return node * 2;
	}

	static int right(int node) {
		return node * 2 + 1;
	}

	static int findmin() {
		return data[1];
	}

	static void swaproot(int node) {
		int root = root(node);
		int tmp = data[node];
		data[node] = data[root];
		data[root] = tmp;
	}

	static int insert(int val) {
		data[nextopen] = val;
		int node = nextopen;
		while (data[root(node)] > data[node]) {
			swaproot(node);
			node = root(node);
		}
		nextopen++;
		return node;
	}

	static void deletemin() {
		data[1] = data[--nextopen];
		int node = 1;
		while (!((left(node) > nextopen) || (right(node) > nextopen))
				&& data[node] > Math.min(data[left(node)], data[right(node)])) {
			if (data[left(node)] > data[right(node)]) {
				swaproot(right(node));
				node = right(node);
			} else {
				swaproot(left(node));
				node = left(node);
			}
		}
	}

	static void init(int size) {
		n = size;
		data = new int[size + 2];
		nextopen = 1;
	}

	static void print() {
		for (int i = 1; i < nextopen; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		init(n + 150000);
		for (int i = 0; i < n; i++) {
			try {
				insert(s.nextInt());
			} catch (Exception e) {

			}
		}

		int m = s.nextInt();
		for (int i = 0; i < m; i++) {
			String op = "";
			try {
				op = s.next();
			} catch (Exception e) {

			}
			if (op.equals("q")) {
				System.out.println(findmin());
			} else if (op.equals("i")) {
				int v = s.nextInt();
				insert(v);
			}
		}

		s.close();

		// String o = "" + findmin();
		// deletemin();
		// while (nextopen > 1) {
		// o += " ";
		// o += findmin();
		// deletemin();
		// }

		// System.out.println(o);
	}

}
