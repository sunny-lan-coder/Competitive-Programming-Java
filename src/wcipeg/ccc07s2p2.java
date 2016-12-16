package wcipeg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ccc07s2p2 {
	static HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>>> visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>>>();
		String[] tmp;
		int c;
		int[] arr = new int[6];
		boolean flag = false;
		int[] forward = new int[6];
		int[] backward = new int[6];
		int[] t = new int[6];
		outer: for (int i = 0; i < n; i++) {

			tmp = br.readLine().split(" ");

			if (flag)
				continue;

			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 6; j++) {
				c = Integer.parseInt(tmp[j]);
				arr[j] = c;
				if (c < min) {
					min = c;
				}
			}

			for (int idx = 0; idx < 6; idx++) {
				if (arr[idx] == min) {

					forward[0] = arr[idx];
					backward[0] = arr[idx];
					for (int k = 1; k < 6; k++) {

						forward[k] = arr[(idx + k) % 6];
						backward[k] = arr[(idx - k + 6) % 6];
					}

					if (contains(forward) || contains(backward)) {
						flag = true;
						continue outer;
					}

					t = forward;
				}
			}
			add(t);

		}
		br.close();

		if (flag) {
			System.out.println("Twin snowflakes found.");
		} else {
			System.out.println("No two snowflakes are alike.");
		}
	}

	static boolean contains(int[] arr) {
		if (!visited.containsKey(arr[0]))
			return false;
		if (!visited.get(arr[0]).containsKey(arr[1]))
			return false;
		if (!visited.get(arr[0]).get(arr[1]).containsKey(arr[2]))
			return false;
		if (!visited.get(arr[0]).get(arr[1]).get(arr[2]).containsKey(arr[3]))
			return false;
		if (!visited.get(arr[0]).get(arr[1]).get(arr[2]).get(arr[3]).containsKey(arr[4]))
			return false;
		if (visited.get(arr[0]).get(arr[1]).get(arr[2]).get(arr[3]).get(arr[4]) != arr[5])
			return false;
		return true;
	}

	static void add(int[] arr) {
		if (!visited.containsKey(arr[0]))
			visited.put(arr[0], new HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>>());
		if (!visited.get(arr[0]).containsKey(arr[1]))
			visited.get(arr[0]).put(arr[1], new HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>());
		if (!visited.get(arr[0]).get(arr[1]).containsKey(arr[2]))
			visited.get(arr[0]).get(arr[1]).put(arr[2], new HashMap<Integer, HashMap<Integer, Integer>>());
		if (!visited.get(arr[0]).get(arr[1]).get(arr[2]).containsKey(arr[3]))
			visited.get(arr[0]).get(arr[1]).get(arr[2]).put(arr[3], new HashMap<Integer, Integer>());
		if (!visited.get(arr[0]).get(arr[1]).get(arr[2]).get(arr[3]).containsKey(arr[4]))
			visited.get(arr[0]).get(arr[1]).get(arr[2]).get(arr[3]).put(arr[4], arr[5]);
	}
}
