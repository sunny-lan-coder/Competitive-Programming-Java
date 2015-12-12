package uva;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P136_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			boolean[][] matrix = new boolean[26][26];

			int[] degrees = new int[26];

			boolean[] used = new boolean[26];

			String str1 = s.next();
			String str2 = "";

			while (true) {
				str2 = s.next();

				if (str2.equals("#"))
					break;

				// System.out.println("cmp " + str1 + " " + str2);

				int i = 0;
				char c1 = ' ';
				char c2 = ' ';
				boolean flag = true;
				while (true) {
					// System.out.println(" idx=" + i);
					if (i >= str1.length() || i >= str2.length()) {
						flag = false;
						break;
					}

					c1 = str1.charAt(i);
					c2 = str2.charAt(i);
					// System.out.println(" cmp " + c1 + " " + c2);
					if (c1 != c2)
						break;
					i++;
				}

				if (flag) {
					int i1 = c1 - 'A';
					int i2 = c2 - 'A';
					// System.out.println(c1 + "<" + c2);
					matrix[i1][i2] = true;
					used[i1] = true;
					used[i2] = true;
					degrees[i1]++;
				}
				str1 = str2;
			}

			// System.out.println("topbegin");

			String L = "";
			Queue<Integer> S = new LinkedList<>();
			for (int i = 0; i < 26; i++) {
				if (used[i] && degrees[i] == 0)
					S.add(i);
			}
			while (!S.isEmpty()) {
				int n = S.remove();
				L = ((char) (n + 'A')) + L;
				for (int m = 0; m < 26; m++) {
					if (used[m] && matrix[m][n]) {
						matrix[m][n] = false;
						degrees[m]--;
						if (degrees[m] == 0) {
							S.add(m);
						}
					}
				}
			}
			System.out.println(L);
		}
		s.close();
	}

}
