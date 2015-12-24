package ccc.prac.y2015;

import java.util.Scanner;

public class J3 {
	public static void main(String[] args) {
		String vowels = "aeiou";
		String alpha = "abcdefghijklmnopqrstuvwxyz";

		Scanner s = new Scanner(System.in);
		String eng = s.nextLine();
		s.close();
		String out = "";
		for (int idx = 0; idx < eng.length(); idx++) {
			char c = eng.charAt(idx);
			if (vowels.contains(c + "")) {
				out = out + c;
			} else {
				out = out + c;

				char max = ' ';
				int p = alpha.indexOf(c);
				for (int i = 0; i < alpha.length(); i++) {
					char a = ' ';
					char b = ' ';
					if (p - i >= 0) {
						a = alpha.charAt(p - i);
						if (!vowels.contains(a + ""))
							a = ' ';
					}
					if (p + i < alpha.length()) {
						b = alpha.charAt(p + i);
						if (!vowels.contains(b + ""))
							b = ' ';
					}
					if (a != ' ' && b != ' ') {
						max = a;
						break;
					}
					if (a != ' ') {
						max = a;
						break;
					}
					if (b != ' ') {
						max = b;
						break;
					}
				}
				out = out + max;

				max = c;
				for (int i = p+1; i < alpha.length(); i++) {
					if (!vowels.contains(alpha.charAt(i) + "")) {
						max = alpha.charAt(i);
						break;
					}
				}
				out = out + max;
			}
		}
		System.out.println(out);
	}
}
