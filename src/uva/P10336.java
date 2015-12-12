package uva;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class P10336 {

	static class LetterEntry {
		public char letter;

		public LetterEntry(char letter) {
			this.letter = letter;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof LetterEntry) {
				LetterEntry instance = (LetterEntry) o;
				return letter == instance.letter;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return new Character(letter).hashCode();
		}
	}

	static char[][] map;
	static int H;
	static int W;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int testCase = 0; testCase < N; testCase++) {
			H = s.nextInt();
			W = s.nextInt();
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = s.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			// System.out.println("iterating");

			Map<LetterEntry, Integer> letters = new HashMap<LetterEntry, Integer>();

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '-')
						continue;

					LetterEntry tmpInst = new LetterEntry(map[i][j]);
					if (!letters.containsKey(tmpInst)) {
						letters.put(tmpInst, 0);
						// System.out.println("putting "+tmpInst.letter+"="+0);
					}

					letters.put(tmpInst, letters.get(tmpInst) + 1);
					// System.out.println("put
					// "+tmpInst.letter+"="+letters.get(tmpInst));

					bfsfill(i, j);
				}
			}

			// sort:
			TreeMap<LetterEntry, Integer> sortedLetters = new TreeMap<LetterEntry, Integer>(
					new ValueComparator(letters));

			sortedLetters.putAll(letters);

			System.out.println("World #" + (testCase + 1));
			for (Entry<LetterEntry, Integer> entry : sortedLetters.entrySet()) {
				System.out.println(entry.getKey().letter + ": " + entry.getValue());
			}
		}
		s.close();
	}

	static class State {
		public int i;
		public int j;

		public State(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void bfsfill(int i, int j) {
		// System.out.println("bfs");
		Queue<State> toExpand = new LinkedList<State>();
		toExpand.add(new State(i, j));
		char letter = map[i][j];
		while (!toExpand.isEmpty()) {
			State currentNode = toExpand.remove();

			// for(State s:toExpand){
			// System.out.print("("+s.i+","+s.j+"), ");
			// }
			// System.out.println();

			// check node:
			// bounds
			if (currentNode.i < 0 || currentNode.j < 0 || currentNode.i >= H || currentNode.j >= W)
				continue;

			// diff languagge
			if (map[currentNode.i][currentNode.j] != letter)
				continue;

			// System.out.println("expanding
			// "+currentNode.i+","+currentNode.j+"="+map[][]);

			map[currentNode.i][currentNode.j] = '-';

			// expand:
			toExpand.add(new State(currentNode.i + 1, currentNode.j));
			toExpand.add(new State(currentNode.i - 1, currentNode.j));
			toExpand.add(new State(currentNode.i, currentNode.j + 1));
			toExpand.add(new State(currentNode.i, currentNode.j - 1));
		}
	}

	static class ValueComparator implements Comparator<LetterEntry> {
		Map<LetterEntry, Integer> base;

		public ValueComparator(Map<LetterEntry, Integer> base) {
			this.base = base;
		}

		// Note: this comparator imposes orderings that are inconsistent with
		// equals.
		public int compare(LetterEntry a, LetterEntry b) {
			int bVal = base.get(b);
			int aVal = base.get(a);
			if (aVal > bVal) {
				return -1;
			} else if (aVal < bVal) {
				return 1;
			} else {
				if (a.letter < b.letter) {
					return -1;
				} else if (a.letter > b.letter) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

}
