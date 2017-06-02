package bssjudge;

import java.util.Scanner;

public class bsspc17p3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String c = s.nextLine();
		String e = s.nextLine();
		s.close();
		if (c.equals("upper"))
			System.out.println(e.toUpperCase());
		else
			System.out.println(e.toLowerCase());
	}
}
