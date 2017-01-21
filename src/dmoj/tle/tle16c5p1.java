package dmoj.tle;

import java.util.Scanner;

public class tle16c5p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while (s.hasNext()) {
			String word = s.next();

			int vc = 0;
			int cc = 0;
			for (int i = 0; i < word.length(); i++) {
				switch (word.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vc++;
					break;
				default:
					cc++;
					break;
				}
			}

			if (word.length() == 1) {
				if (vc != 1)
					flag = false;
			}

			else if (Math.abs(vc - cc) > 1)
				flag = false;
		}
		s.close();
		if (flag)
			System.out.println("readable");
		else
			System.out.println("not readable");
	}

}
