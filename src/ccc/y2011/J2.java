package ccc.y2011;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int M = s.nextInt();
		for (int t = 1; t <= M; t++) {
			int A = 0;
			A += -6 * (t * t * t * t);
			A += h * (t * t * t);
			A += 2 * (t * t);
			A += t;
			if (A <= 0) {
				System.out.println("The balloon first touches ground at hour: ");
				System.out.println(t);
				s.close();
				return;
			}
		}
		System.out.println("The balloon does not touch ground in the given time.");

		s.close();
	}

}
