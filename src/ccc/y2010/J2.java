package ccc.y2010;

import java.util.Scanner;

public class J2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int s = in.nextInt();
		in.close();
		int nik = 0;
		int bar = 0;

		int nikdir = 1;
		int bardir = 1;

		int nikleft = a;
		int barleft = c;

		for (int i = 0; i < s; i++) {
			// System.out.println("n=" + nik + ", b=" + bar + ", nl=" + nikleft
			// + ", bl=" + barleft + ", nd=" + nikdir
			// + ", bd=" + bardir);
			nik += nikdir;
			bar += bardir;
			nikleft--;
			barleft--;

			if (nikleft == 0) {
				nikdir = -nikdir;
				if (nikdir == -1) {
					nikleft = b;
				} else {
					nikleft = a;
				}
			}

			if (barleft == 0) {
				bardir = -bardir;
				if (bardir == -1) {
					barleft = d;
				} else {
					barleft = c;
				}
			}
		}

		if (nik > bar) {
			System.out.println("Nikky");
		} else if (nik < bar) {
			System.out.println("Byron");
		} else {
			System.out.println("Tied");
		}

	}
}
