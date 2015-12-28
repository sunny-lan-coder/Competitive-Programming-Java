package ccc.prac.y2012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J5 {

	static int n;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		outer: while (true) {
			n = s.nextInt();
			if (n == 0)
				break;
			int init = 0;
			for (int i = 0; i < n; i++) {
				init = set(init, i, s.nextInt() - 1, true);
			}

			int lim = 2 << (n * n);

			// System.out.println(lim);

			boolean[] visited = new boolean[lim];

			// game states
			Queue<Integer> levels = new LinkedList<>();
			Queue<Integer> possible = new LinkedList<>();
			possible.add(init);
			levels.add(0);

			while (!possible.isEmpty()) {
				int level = levels.remove();
				int currentExpand = possible.remove();
				// String indent = "";
				// for (int i = 0; i < level; i++)
				// indent += " ";
				// System.out.println(indent +
				// Integer.toBinaryString(currentExpand));

				// check if visited
				if (visited[currentExpand])
					continue;

				// check if win
				{
					boolean flag = true;
					for (int i = 0; i < n; i++) {
						if (!get(currentExpand, i, i)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println(level);
						continue outer;
					}
				}

				// expand node
				for (int src = 0; src < n; src++) {
					// System.out.println(indent + " src=" + src);
					int select = -1;
					for (select = 0; select < n; select++) {
						if (get(currentExpand, src, select))
							break;
					}
					if (select == -1)
						break;
					// System.out.println(indent + " top=" + select);

					int dst;
					dst = src - 1;
					while (dst >= 0) {
						if (dst == src)
							break;
						int max = -1;
						for (max = 0; max < n; max++) {
							if (get(currentExpand, dst, max))
								break;
						}
						boolean ok = false;
						if (max == -1) {
							ok = true;
						} else if (!(select > max)) {
							ok = true;
						}
						if (ok) {
							int tmp = currentExpand;
							tmp = set(tmp, src, select, false);
							tmp = set(tmp, dst, select, true);
							possible.add(tmp);
							levels.add(level + 1);
						}
						break;
					}

					dst = src + 1;
					while (dst < n) {
						if (dst == src)
							break;
						int max = -1;
						for (max = 0; max < n; max++) {
							if (get(currentExpand, dst, max))
								break;
						}
						boolean ok = false;
						if (max == -1) {
							ok = true;
						} else if (!(select > max)) {
							ok = true;
						}
						if (ok) {
							int tmp = currentExpand;
							tmp = set(tmp, src, select, false);
							tmp = set(tmp, dst, select, true);
							possible.add(tmp);
							levels.add(level + 1);
						}
						break;
					}
				}
				visited[currentExpand] = true;
			}
			System.out.println("IMPOSSIBLE");
		}
		s.close();

	}

	static boolean get(int encode, int pos, int cval) {
		int idx = pos * n + cval;
		return ((encode >> idx) & 1) == 1;
	}

	static int set(int encode, int pos, int cval, boolean val) {
		int idx = pos * n + cval;
		if (val)
			encode |= (1 << idx);
		else
			encode &= (~(1 << idx));
		return encode;
	}

}
