package codejam.y2017.r2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dragon {

	static class State {
		int hd;
		int ad;
		int hk;
		int ak;
		int level;

		public State(int hd, int ad, int hk, int ak, int level) {
			this.hd = Math.max(0,hd);
			this.hk = Math.max(0,hk);
			this.ad = Math.max(0,ad);
			this.ak = Math.max(0,ak);
			this.level = level;
		}

		public int hash() {
			return hd + ad * 101 + hk * 101*101 + ak * 101*101*101;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		 s= new Scanner(new File("C-small-attempt0.in"));
//		s = new Scanner(System.in);
		PrintStream out;
		 out = new PrintStream("C_small_output.txt");
//		out = System.out;
		int t = s.nextInt();
		outer: for (int test = 1; test <= t; test++) {
			int hd = s.nextInt();
			int ad = s.nextInt();
			int hk = s.nextInt();
			int ak = s.nextInt();
			int b = s.nextInt();
			int d = s.nextInt();

			State init = new State(hd, ad, hk, ak, 0);

			boolean[] visited = new boolean[1000000000];
			Queue<State> next = new LinkedList<>();
			next.add(init);
			while (!next.isEmpty()) {
				State curr = next.remove();
				if (visited[curr.hash()])
					continue;
				if (curr.hk == 0) {
					out.println("Case #" + test + ": " + curr.level);
					continue outer;
				}
				if (curr.hd == 0)
					continue;
				// attack
				next.add(new State(curr.hd - curr.ak, curr.ad, curr.hk - curr.ad, curr.ak, curr.level + 1));
				// buff
				int newatk = curr.ad + b;
				next.add(new State(curr.hd - curr.ak, newatk, curr.hk, curr.ak, curr.level + 1));
				// cure
				next.add(new State(hd - curr.ak, curr.ad, curr.hk , curr.ak, curr.level + 1));
				// debuff
				newatk = Math.max(0, curr.ak - d);
				next.add(new State(curr.hd - newatk, curr.ad, curr.hk , newatk, curr.level + 1));
				
				visited[curr.hash()] = true;
			}
			out.println("Case #" + test + ": IMPOSSIBLE");
		}
		s.close();
		out.close();
	}

}
