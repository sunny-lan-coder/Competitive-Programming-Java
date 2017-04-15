package codejam.y2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BathRoomStalls {

	static String indent = "";

	static class Node {
		final int startpos;
		final int endpos;
		final int mid;
		int max;
		int min;
		boolean taken;

		Node l;
		Node r;

		Node best;
		Node bestDirect;

		public Node(int startPos, int endPos) {
			startpos = startPos;
			endpos = endPos;
			mid = (startpos + endpos) >> 1;
			max = endpos - mid - 1;
			min = mid - startpos - 1;
			best = this;
			taken = false;
		}

		public Node take() {
			// indent+=" ";
			// System.out.println(indent+"Curr stall " + this);
			Node res;
			if (!taken) {
				// System.out.println(indent+" Taking");
				taken = true;
				l = new Node(startpos, mid);
				r = new Node(mid, endpos);
				res = this;
			} else {
				// System.out.println(indent+" Traversing");
				res = bestDirect.take();
			}

			best = max(l.best, r.best);
			// System.out.println(indent+" Cmp:" + l.best + " || " + r.best);
			if (best == l.best) {
				bestDirect = l;
				// System.out.println(indent+" new best -> left");
			} else {
				bestDirect = r;
				// System.out.println(indent+" new best -> right");
			}
			// indent=indent.substring(1);
			return res;
		}

		@Override
		public String toString() {
			return mid + ", start=" + startpos + ", end=" + endpos + ", max=" + max + ", min=" + min;
		}
	}

	static Node max(Node l, Node r) {
		if (l.best.min > r.best.min)
			return l;
		else if (r.best.min > l.best.min)
			return r;
		else {
			if (l.best.max > r.best.max)
				return l;
			else if (r.best.max > l.best.max)
				return r;
			else
				return l;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		 s= new Scanner(new File("C-small-2-attempt0.in"));
//		s = new Scanner(System.in);
		PrintStream out;
		 out = new PrintStream("C_small_2_output.txt");
//		out = System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int k = s.nextInt();
			Node root = new Node(0, n + 1);
			for (int i = 0; i < k - 1; i++) {
//				System.out.println("Person " + i);
				root.take();
			}
			Node res = root.take();
			out.println("Case #" + test + ": " + res.max + " " + res.min);
		}
		s.close();
		out.close();
	}

}
