package bssjudge;

import java.util.Scanner;

public class bsspc17p2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		long m = s.nextInt();
		s.close();
		long f = 1;
		for (int i = 1; i <= n; i++)
			f *= i;
		System.out.println((long) Math.max(0,f - Math.pow(2, m)));
	}

}
