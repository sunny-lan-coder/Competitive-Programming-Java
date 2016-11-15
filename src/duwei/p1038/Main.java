package duwei.p1038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static ArrayList<String> results = new ArrayList<>();
	static ArrayList<Character> chars = new ArrayList<>();
	static ArrayList<Integer> charCnt = new ArrayList<>();
	static HashMap<Character, Integer> mapping = new HashMap<>();
	static int k;
	static HashSet<String> resultsH = new HashSet<>();
	static int n;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		String next;
		int idx = 0;
		int res = n;
		while (!(next = s.next()).equals("Q")) {
			chars.add(next.charAt(0));
			int c = s.nextInt();
			res -= c;
			charCnt.add(c);
			mapping.put(next.charAt(0), idx);
			idx++;
		}
		s.close();
		chars.add('E');
		charCnt.add(res);
		mapping.put('E', idx);
		k = charCnt.size();
		count = new int[k];
		seen = new boolean[k];
		traverse("");
		Collections.sort(results);
		Collections.reverse(results);
		System.out.println(results.size());
		for (String result : results)
			System.out.println(result);

	}

	static int[] count;
	static boolean[] seen;

	static void traverse(String s) {
		if (s.length() == n) {
			if (resultsH.contains(s))
				return;
			Arrays.fill(count, 0);
			Arrays.fill(seen, false);
			for (int i = 0; i < n; i++) {
				int mapped = mapping.get(s.charAt(i));

				count[mapped]++;

				if (seen[mapped])
					return;

				if (i > 0 && s.charAt(i) == 'E' && s.charAt(i - 1) != 'E')
					seen[mapping.get(s.charAt(i - 1))] = true;
			}
			for (int i = 0; i < k; i++) {
				if (count[i] != charCnt.get(i))
					return;
			}
			results.add(s);
			resultsH.add(s);
		} else {
			for (Character c : chars) {
				if (s.length() == 0)
					traverse(s + c);
				else {
					char b = s.charAt(s.length() - 1);
					if (b == 'E')
						traverse(s + c);

					else if (c == 'E')
						traverse(s + c);

					else if (b == c)
						traverse(s + c);
				}

			}
		}
	}

}
