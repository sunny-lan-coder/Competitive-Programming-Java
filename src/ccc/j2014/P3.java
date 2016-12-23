package ccc.j2014;

import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a = 100;
		int b = 100;
		for (int i = 0; i < n; i++) {
			int ar = s.nextInt();
			int br = s.nextInt();
			if (ar > br)
				b -= ar;

			if (br > ar)
				a -= br;
		}

		System.out.println(a);
		System.out.println(b);

		s.close();
	}

}
