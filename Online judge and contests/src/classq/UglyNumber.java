package classq;

import java.util.HashMap;

public class UglyNumber {

	public static void main(String[] args) {
		int x = 1000;
		int y = 0;
		int count = 0;
		visited = new HashMap<>();
		visited.put(1, true);
		while (count != x) {
			y++;
			if (isUglyR(y)) {
				System.out.println(count + ":" + y);
				count++;
			}
		}
	}

	static HashMap<Integer, Boolean> visited;

	static boolean isUglyR(int n) {
		if (visited.containsKey(n)) {
			if (visited.get(n)) {
				return true;
			} else {
				return false;
			}
		}
		boolean result = false;
		if (n % 2 == 0) {
			result |= isUglyR(n / 2);
		}
		if (n % 3 == 0) {
			result |= isUglyR(n / 3);
		}
		if (n % 5 == 0) {
			result |= isUglyR(n / 5);
		}
		visited.put(n, result);
		return result;
	}

}
