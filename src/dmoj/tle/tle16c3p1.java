package dmoj.tle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class tle16c3p1 {
	static HashMap<String, Integer> count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		count = new HashMap<>();
		for (int i = 0; i < n; i++) {
			put(br.readLine());
		}
		br.close();
		int res = 0;
		for (String word : count.keySet()) {
			if (count.get(word) == 1)
				res++;
		}
		System.out.println(res);
	}

	static void put(String val) {
		if (!count.containsKey(val))
			count.put(val, 0);
		count.put(val, count.get(val) + 1);
	}

}
