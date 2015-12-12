package spoj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PHONELST2 {

	static class Trie {
		public boolean isWord;
		public Trie[] subtries;
		public char num;

		public Trie(boolean isWord, Trie[] subtries, char num) {
			this.isWord = isWord;
			this.subtries = subtries;
			this.num = num;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int testCase = 0; testCase < t; testCase++) {
			boolean flag = false;
			int n = s.nextInt();

			String[] list = new String[n];
			for (int i = 0; i < n; i++) {
				list[i] = s.next();
			}
			Arrays.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});

			Trie top = new Trie(false, new Trie[10], '\u0000');

			s: for (int i = 0; i < n; i++) {
				String thing = list[i];

//				System.out.println("read word " + thing);

				Trie current = top;
				for (int idx = 0; idx < thing.length(); idx++) {
					char letter = thing.charAt(idx);
					int num = Integer.parseInt(letter + "");

					if (current.subtries[num] != null && current.subtries[num].isWord) {
//						System.out.println(" prefix");
						flag = true;
						break s;
					}

//					System.out.println(" current num " + num);

					if (current.subtries[num] == null) {
//						System.out.println("  creating subtrie");
						if (idx == thing.length() - 1) {
//							System.out.println("  setting end true");
							current.subtries[num] = new Trie(true, new Trie[10], letter);
						} else {
//							System.out.println("  setting end false");
							current.subtries[num] = new Trie(false, new Trie[10], letter);
						}
					}

					current = current.subtries[num];
//					System.out.println(" selecting subtrie " + current.num);
				}
			}

			if (flag) {
				System.out.println("NO");
			} else {

				System.out.println("YES");
			}
		}
		s.close();
	}

}
