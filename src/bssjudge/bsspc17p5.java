package bssjudge;

import java.util.Scanner;

public class bsspc17p5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		int w = 0;
		if (x == 1)
			for (int i = 0; i < n; i++) {
				w += s.nextInt();
				System.out.print(w + " ");
			}
		else
			for (int i = 0; i < n; i++) {
				int y = s.nextInt();
				System.out.print(y - w + " ");
				w = y;
			}
		s.close();
		System.out.println();
	}
}
