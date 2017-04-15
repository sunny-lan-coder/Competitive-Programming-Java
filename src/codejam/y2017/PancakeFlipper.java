package codejam.y2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class PancakeFlipper {

	static int bitmask;

	static int flip(int idx, int val) {
		return val ^ (bitmask << idx);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("A-small-attempt0.in"));
		 PrintWriter out = new PrintWriter("small_output.txt");
		int t = sc.nextInt();
		outer: for (int test = 0; test < t; test++) {

			String s = sc.next().replace('-', '1').replace('+', '0');
			int n = s.length();
			int k = sc.nextInt();
			bitmask = 0;
			for (int i = 0; i < k; i++)
				bitmask |= 1 << i;
			int initState = Integer.parseInt(s, 2);

			int lim = 1 << n;
			boolean[] visited = new boolean[lim];
			Queue<Integer> states = new LinkedList<>();
			Queue<Integer> levels = new LinkedList<>();
			states.add(initState);
			levels.add(0);
			while (!states.isEmpty()) {
				int currState = states.remove();
				int level = levels.remove();

				if (visited[currState])
					continue;
				
				if (currState == 0) {
					out.println("Case #" + (test+1) + ": " + level);
					continue outer;
				}

				visited[currState] = true;
				for (int shf = 0; shf + k <= n; shf++) {
					states.add(flip(shf, currState));
					levels.add(level + 1);
				}
			}
			out.println("Case #" + (test+1) + ": IMPOSSIBLE");
		}
		sc.close();
		out.close();
	}

}
