package duwei.p1268;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	static class MyIntList {
		public final LinkedList<Integer> value;

		public MyIntList(LinkedList<Integer> val) {
			value = val;
		}

		@Override
		public int hashCode() {
			long hash = 5381;
			for (Integer i : value) {
				hash = ((hash << 5) + hash) + i;
			}
			return Long.hashCode(hash);
		}

		@Override
		public boolean equals(Object o) {
			assert o instanceof MyIntList;
			return ((MyIntList) o).value.equals(value);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean alike = false;
		HashSet<MyIntList> visited = new HashSet<>();
		String[] tmp;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			tmp = line.split(" ");
			MyIntList l = new MyIntList(new LinkedList<>());

			for (String s : tmp) {
				l.value.add(Integer.parseInt(s));
			}

			if (alike)
				continue;

			if (visited.contains(l)) {
				alike = true;
				continue;
			}

			for (int j = 0; j < 6; j++) {
				visited.add(l);
				l.value.add(l.value.removeFirst());
			}

			String tmp2 = "";
			for (int j = 0; j < line.length(); j++) {
				tmp2 = line.charAt(j) + tmp2;
			}
			line = tmp2;
			tmp = line.split(" ");
			l = new MyIntList(new LinkedList<>());

			for (String s : tmp) {
				l.value.add(Integer.parseInt(s));
			}

			for (int j = 0; j < 6; j++) {
				visited.add(l);
				l.value.add(l.value.removeFirst());
			}

		}
		br.close();
		if (alike)
			System.out.println("Twin snowflakes found.");
		else
			System.out.println("No two snowflakes are alike.");
	}
}
