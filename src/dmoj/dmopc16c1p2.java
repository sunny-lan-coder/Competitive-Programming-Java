package dmoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class dmopc16c1p2 {
	static HashMap<Long, HashSet<Long>> lines;
	static HashMap<Long, Long> count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] tmp;
		lines = new HashMap<>();
		count = new HashMap<>();
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			long m = Long.parseLong(tmp[0]);
			long b = Long.parseLong(tmp[1]);
			flag |= add(m, b);
		}
		br.close();
		if (flag) {
			System.out.println("Infinity");
			return;
		}

		long linecount = 0;
		long pointcount = 0;
		for (long slope : count.keySet()) {
			pointcount += count.get(slope) * linecount;
			linecount += count.get(slope);
		}

		System.out.println(pointcount);
	}

	static long get(long m) {
		if (count.containsKey(m))
			return count.get(m);
		else
			return 0;
	}

	static boolean add(long m, long b) {
		if (!lines.containsKey(m))
			lines.put(m, new HashSet<>());
		if (lines.get(m).contains(b))
			return true;
		lines.get(m).add(b);
		count.put(m, get(m) + 1);
		return false;
	}

}