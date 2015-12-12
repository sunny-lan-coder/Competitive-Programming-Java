package wcipej.woburn;

import java.util.Scanner;

public class wc151j1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String c1 = s.nextLine();
		String c2 = s.nextLine();
		if (c1.equals("RED") && c2.equals("BLUE")) {
			System.out.println("WHITE");
		}
		if (c1.equals("RED") && c2.equals("WHITE")) {
			System.out.println("BLUE");
		}
		if (c1.equals("WHITE") && c2.equals("BLUE")) {
			System.out.println("RED");
		}
		if (c2.equals("RED") && c1.equals("BLUE")) {
			System.out.println("WHITE");
		}
		if (c2.equals("RED") && c1.equals("WHITE")) {
			System.out.println("BLUE");
		}
		if (c2.equals("WHITE") && c1.equals("BLUE")) {
			System.out.println("RED");
		}
		s.close();
	}

}
