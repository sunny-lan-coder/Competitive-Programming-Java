package ccc;

import java.util.Scanner;

public class ccc09j1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = "9780921418";
		in += s.next();
		in += s.next();
		in += s.next();

		s.close();
		int sum = 0;
		for (int i = 0; i < 13; i++) {
			sum += ((i % 2) * 2 + 1) * Integer.parseInt(in.charAt(i) + "");
		}
		System.out.println("The 1-3-sum is "+sum);
	}

}
