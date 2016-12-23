package ccc.j2009;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Digit 11?");
		int a = s.nextInt();
		System.out.print("Digit 12?");
		int b = s.nextInt();
		System.out.print("Digit 13?");
		int c = s.nextInt();
		s.close();
		System.out.println("The 1-3 sum is " + (91 + a * 1 + b * 3 + c * 1));
	}

}
