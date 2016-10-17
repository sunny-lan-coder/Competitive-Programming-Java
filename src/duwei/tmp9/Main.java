package duwei.tmp9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static class State {
		public State parent;
		public String value;
		public int idx;
		public int lev;

		public State(State parent, String value, int idx, int lev) {
			this.parent = parent;
			this.value = value;
			this.idx = idx;
			this.lev = lev;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		String orig = "";
		for (int i = 0; i < n; i++) {
			orig += "o";
		}
		for (int i = 0; i < n; i++) {
			orig += "*";
		}
		orig += "__";
		String end = "";
		end += "__";
		for (int i = 0; i < n; i++) {
			end += "o*";
		}
		int l = n * 2 + 2;
		HashSet<String> visited = new HashSet<String>();
		Queue<State> exp = new LinkedList<State>();
		exp.add(new State(null, orig, n * 2, 0));
		while (!exp.isEmpty()) {
			State curr = exp.remove();

			// System.out.println(curr.value);

			if (visited.contains(curr.value)) {
				// System.out.println("visited");
				continue;
			}

			if (curr.value.equals(end)) {
				State currpoint = curr;
				System.out.println(currpoint.lev);
				Stack<String> list = new Stack<String>();
				while (currpoint != null) {
					list.push(currpoint.value);
					currpoint = currpoint.parent;
				}
				while (!list.isEmpty())
					System.out.println(list.pop());
				break;
			}

			for (int i = 0; i < l - 1; i++) {
				char a1 = curr.value.charAt(i);
				char a2 = curr.value.charAt(i + 1);
				if (a1 != '_' && a2 != '_' && Math.abs(i - curr.idx) > 2) {
					StringBuilder bs = new StringBuilder(curr.value);
					bs.setCharAt(curr.idx, a1);
					bs.setCharAt(curr.idx + 1, a2);
					bs.setCharAt(i, '_');
					bs.setCharAt(i + 1, '_');

					// System.out.println(" "+bs.toString());
					exp.add(new State(curr, bs.toString(), i, curr.lev + 1));
				}
			}

			visited.add(curr.value);
		}
	}
}
