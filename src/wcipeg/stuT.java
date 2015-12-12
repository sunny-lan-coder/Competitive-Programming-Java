package wcipeg;

import java.util.Scanner;

public class stuT {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		for (int line = 0; line < n; line++) {
			String lines = s.nextLine();
			int idx = Integer.parseInt(lines.substring(0, lines.indexOf(" ")));
			String in = lines.substring(lines.indexOf(" ") + 1);
			String before = in.substring(0, idx - 1);
			String after = in.substring(idx);
			System.out.println((line + 1) + " " + before + after);
		}
		// mississipi
		// 12345678910
		s.close();
	}
}