package algorithms;

public class Comparisons {
	static boolean g(int a, int b) {
		if (b == -1)
			return false;
		if (a == -1)
			return true;
		return a > b;
	}

	static boolean l(int a, int b) {
		return !e(a, b) && !g(a, b);
	}

	static boolean e(int a, int b) {
		return a == b;
	}

	static int compare(Integer a, Integer b) {

		if (e(a, b))
			return 0;
		if (g(a, b))
			return 1;
		return -1;
	}
}
