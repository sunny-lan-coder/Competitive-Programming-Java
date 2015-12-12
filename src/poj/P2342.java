package poj;

import java.util.Scanner;

public class P2342 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] rating = new int[N];
		for (int i = 0; i < N; i++) {
			rating[i] = in.nextInt();
		}
		
		while (true) {
			int L = in.nextInt();
			int K = in.nextInt();
			if (L == 0 & K == 0)
				break;
			
			
		}
		in.close();
	}

}
