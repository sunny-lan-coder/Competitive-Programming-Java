package classq;

import java.util.Arrays;
import java.util.Scanner;

public class Maxsubstr {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.next();
		s.close();
		int max = 1;
		int N = in.length();
		outer: for (int i = 0; i < N; i++) {
			for (int j = i + max; j < N + 1; j++) {
				char[] sort = in.substring(i, j).toCharArray();
				System.out.println(new String(sort));
				Arrays.sort(sort);
				char prev = ' ';
				for (char c : sort) {
					if (c == prev)
						continue outer;
					prev = c;
				}
				max = sort.length;
			}
		}
		System.out.println(max);
	}

}
