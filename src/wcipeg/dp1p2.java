package wcipeg;

import java.util.Scanner;

public class dp1p2 {

	static int[] v;
	static int[][][][][][][] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		v = new int[N];
		for (int i = 0; i < N; i++) {
			v[i] = s.nextInt();
		}
		s.close();

	}

}
