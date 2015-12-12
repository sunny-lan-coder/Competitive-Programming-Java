package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P567 {

	/** Class for buffered reading int and double values */
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/**
		 * call this method to initialize reader for InputStream
		 * 
		 * @throws IOException
		 */
		static void init(InputStream input) throws IOException {
			reader = new BufferedReader(new InputStreamReader(input));
			StringBuilder s = new StringBuilder();
			String t;
			while ((t = reader.readLine()) != null) {
				s.append(t + "\n");
			}
			tokenizer = new StringTokenizer(s.toString());
		}

		/** get next word */
		static String next() throws IOException {
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

	static class State {
		public int countryNumber;
		public int level;

		public State(int countryNumber, int level) {
			this.countryNumber = countryNumber;
			this.level = level;
		}
	}

	public static void main(String[] args) {
		try {
			Reader.init(System.in);
			int[][] adjmatrix = new int[20][20];
			boolean[] visited = new boolean[20];
			for (int testSet = 1; Reader.tokenizer.hasMoreTokens(); testSet++) {
				for (int i = 0; i < 20; i++) {
					for (int j = 0; j < 20; j++) {
						adjmatrix[i][j] = 0;
					}
				}
				for (int i = 0; i < 19; i++) {
					int X = Reader.nextInt();
					for (int border = 0; border < X; border++) {
						int j = Reader.nextInt() - 1;
						adjmatrix[i][j] = 1;
						adjmatrix[j][i] = 1;
					}
				}
				System.out.println("Test Set #" + testSet);
				int N = Reader.nextInt();
				for (int countryPairIndex = 0; countryPairIndex < N; countryPairIndex++) {
					for (int i = 0; i < 20; i++) {
						visited[i] = false;
					}
					int a = Reader.nextInt() - 1;
					int b = Reader.nextInt() - 1;
					Queue<State> toExpand = new LinkedList<State>();
					toExpand.add(new State(a, 0));

					while (!toExpand.isEmpty()) {
						State currentNode = toExpand.remove();

						if (currentNode.countryNumber == b) {
							System.out.format("%2s to %2s: %1d%n", (a + 1), (b + 1), currentNode.level);
							break;
						}

						for (int j = 0; j < 20; j++) {
							if (adjmatrix[currentNode.countryNumber][j] == 1) {
								if (!visited[j]) {
									if (!(j < 0 || j >= 20)) {
										toExpand.add(new State(j, currentNode.level + 1));
										visited[currentNode.countryNumber] = true;
									}
								}
							}
						}

					}
				}
				System.out.println();
			}
		} catch (IOException e) {
			return;
		}
	}

}
