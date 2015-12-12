package dmoj.contest.y2015.december;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();
		if ((c < b && a < d) || (d < a && b < c)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		s.close();
	}

}
