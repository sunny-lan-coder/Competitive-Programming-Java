package poj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1521 {
	static class Node implements Comparable<Node> {
		public int freq;
		public char val;
		public boolean internal;

		public Node left;
		public Node right;

		public Node(int freq) {
			internal = true;
		}

		public Node(int freq, char val) {
			this.freq = freq;
			this.val = val;
			internal = false;
		}

		@Override
		public int compareTo(Node o) {
			return freq - o.freq;
		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		out: while (true) {
			String line = s.nextLine();
			switch (line) {
			case "END":
				break out;
			}

			int[] count = new int[1 >> 8];
			for (char c : line.toCharArray()) {
				int idx = (int) c;
				if (idx != -1) {
					count[idx]++;
				}
			}

			PriorityQueue<Node> derp = new PriorityQueue<Node>();
			for (int i = 0; i < count.length; i++) {
				if (!(count[i] == 0)) {
					derp.add(new Node(count[i], (char) i));
				}
			}

			while (derp.size() > 1) {
				Node node1 = derp.remove();
				Node node2 = derp.remove();
				Node node3 = new Node(node1.freq + node2.freq);
				node3.left = node1;
				node3.right = node2;
				derp.add(node3);
			}
			
			
		}
		s.close();
	}

}
