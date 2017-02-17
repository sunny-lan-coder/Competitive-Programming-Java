package ccc.s2013;

import java.util.Scanner;

public class ccc13s6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		int cost = 0;
		outer: while (n != 1) {
			for (int f = 2; f * f <= n; f++) {
				while (n % f == 0) {

//					System.out.println("n=" + n);
//					System.out.println("divisible by " + f);
					int x=n/f;
					
					n -= x;
					cost=cost+n/x;
					continue outer;
				}

			}

			if (n == 1)
				break;
			
//			System.out.println("undivisible");

			
			n--;
			cost+=n;
		}
		System.out.println(cost);
	}

}