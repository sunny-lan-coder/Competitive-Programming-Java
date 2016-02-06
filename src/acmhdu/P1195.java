package acmhdu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1195 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int testCase = 0; testCase < testCases; testCase++) {
			int in = s.nextInt();
			int out = s.nextInt();

			int len = 8;

			boolean[] visited = new boolean[(int) Math.pow(10, len)];
			Queue<Integer> states = new LinkedList<>();
			Queue<Integer> levels = new LinkedList<>();
			states.add(in);
			levels.add(0);
			while (!levels.isEmpty()) {
				int current = states.remove();
				int level = levels.remove();

				if (visited[current])
					continue;

				if (current == out) {
					System.out.println(level);
					break;
				}

				for (int i = 0; i < len; i++) {
					if (i < len - 1) {
						states.add(swap(i, current));
						levels.add(level + 1);
					}
					states.add(incr(i, current));
					levels.add(level + 1);
					states.add(decr(i, current));
					levels.add(level + 1);
				}

				visited[current] = true;
			}
		}
		s.close();
	}

	static int swap(int idx, int v) {
		char[] tmp = ("" + v).toCharArray();
		char tmpl = tmp[idx];
		tmp[idx] = tmp[idx + 1];
		tmp[idx + 1] = tmpl;
		return Integer.parseInt(new String(tmp));
	}

	static String map = "123456789";

	static int incr(int idx, int v) {
		char[] tmp = ("" + v).toCharArray();
		tmp[idx] = map.charAt((map.indexOf(tmp[idx]) + 1) % 9);
		return Integer.parseInt(new String(tmp));
	}

	static int decr(int idx, int v) {
		char[] tmp = ("" + v).toCharArray();
		int i = (map.indexOf(tmp[idx]) - 1) % 9;
		if (i < 0)
			i += 9;
		tmp[idx] = map.charAt(i);
		return Integer.parseInt(new String(tmp));
	}

}
