package ccc.y2011;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t1 = s.nextInt();
		int t2 = s.nextInt();
		s.close();
		int t3;
		int len = 2;
		while (true) {
			t3 = t1 - t2;
			len++;
			if (t2 < t3)
				break;
			t1 = t2;
			t2 = t3;
		}
		System.out.println(len);

	}

}
