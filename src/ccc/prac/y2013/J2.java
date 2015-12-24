package ccc.prac.y2013;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		String rot = "IOSHZXN";
		Scanner s = new Scanner(System.in);
		String word = s.nextLine();
		s.close();
		for (int i = 0; i < word.length(); i++) {
			if (!rot.contains(word.charAt(i) + "")) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
