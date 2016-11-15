package wcipeg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ccc07s2p2 {
	static HashMap<Integer, ArrayList<int[]>> visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new HashMap<>();
		String[] tmp;
		int c;
		String f;
		String b;
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
		int hashcode = Arrays.hashCode(arr);
		if (!visited.containsKey(hashcode))
			return false;
		for (int[] a : visited.get(hashcode)) {
			if (Arrays.equals(arr, a))
				return true;
		}
		return false;
	}

	static void add(int[] arr) {
		if (contains(arr))
			return;
		int hashcode = Arrays.hashCode(arr);
		if (!visited.containsKey(hashcode))
			visited.put(hashcode, new ArrayList<>());
		visited.get(hashcode).add(arr);
	}
}
