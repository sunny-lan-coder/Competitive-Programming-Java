package uva;

import java.io.IOException;
import java.util.Scanner;

public class P10400 {
	// /** Class for buffered reading int and double values */
	// static class Reader {
	// static BufferedReader reader;
	// static StringTokenizer tokenizer;
	//
	// /**
	// * call this method to initialize reader for InputStream
	// *
	// * @throws IOException
	// */
	// static void init(InputStream input) throws IOException {
	// reader = new BufferedReader(new InputStreamReader(input));
	// StringBuilder s = new StringBuilder();
	// String t;
	// while ((t = reader.readLine()) != null) {
	// s.append(t + "\n");
	// }
	// tokenizer = new StringTokenizer(s.toString());
	// }
	//
	// /** get next word */
	// static String next() throws IOException {
	// return tokenizer.nextToken();
	// }
	//
	// static int nextInt() throws IOException {
	// return Integer.parseInt(next());
	// }
	//
	// static double nextDouble() throws IOException {
	// return Double.parseDouble(next());
	// }
	// }

	static int target;
	static int[] seq;
	static int p;
	static long count = 0;

	public static void main(String[] args) throws IOException {
		Scanner Reader = new Scanner(System.in);
		int n = Reader.nextInt();
		seq = new int[101];
		for (int testCase = 0; testCase < n; testCase++) {
			p = Reader.nextInt();
			for (int i = 0; i < p; i++) {
				seq[i] = Reader.nextInt();
			}
			target = Reader.nextInt();
			done = false;
			// System.out.println("dfs");
			visited = new boolean[p][70000];
			dfs(seq[0], 0, Integer.toString(seq[0]));
			if (!done) {
				System.out.println("NO EXPRESSION");
			}
		}
		Reader.close();
	}

	static boolean done;

	static String indent = "";
	static boolean[][] visited;

	static void setVisited(int op, int val) {
		visited[op][val + 32001] = true;
	}

	static boolean getVisited(int op, int val) {
		return visited[op][val + 32001];
	}

	static void dfs(int currentVal, int sp, String thing) {
		if (done)
			return;

		if (currentVal > 32000 || currentVal < -32000) {
			return;
		}

		if (getVisited(sp, currentVal)) {
			return;
		}

		setVisited(sp, currentVal);

		if (sp == p - 1) {
			if (currentVal == target) {
				System.out.println(thing + "=" + target);
				done = true;
			}
			return;
		}

		int index = sp + 1;
		int val = seq[index];

		dfs(currentVal + val, index, thing + "+" + val);
		dfs(currentVal * val, index, thing + "*" + val);
		dfs(currentVal - val, index, thing + "-" + val);
		if (currentVal % val == 0) {
			dfs(currentVal / val, index, thing + "/" + val);
		}
	}
}
