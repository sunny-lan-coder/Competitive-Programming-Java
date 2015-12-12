package classq;

import static java.lang.Math.*;

public class KnapsackDP {

	static int[] W;
	static int[] V;

	public static void main(String[] args) {
		
	}

	static int f(int item, int weight) {
		
		int a = f(item + 1, weight - W[item]) + V[item];
		int b = f(item + 1, weight);
		return min(a, b);
	}

}
