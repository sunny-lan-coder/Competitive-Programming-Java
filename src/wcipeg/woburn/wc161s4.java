package wcipeg.woburn;

import java.util.Scanner;

public class wc161s4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		s.close();
		double houses = 0;
		for (int i = 0; i < m; i++) {
			houses += (2 * (n - houses)) / n;
		}
		System.out.println(houses);
	}
}
