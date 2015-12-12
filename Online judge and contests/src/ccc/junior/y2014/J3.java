package ccc.junior.y2014;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p1P = 100;
		int p2P = 100;
		for (int roll = 0; roll < n; roll++) {
			int p1R = s.nextInt();
			int p2R = s.nextInt();
			if (p1R > p2R) {
				p2P -= p1R;
			} else if (p1R < p2R) {
				p1P -= p2R;
			}
		}
		System.out.println(p1P);
		System.out.println(p2P);
		s.close();
	}

}
