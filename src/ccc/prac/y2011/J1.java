package ccc.prac.y2011;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("How many antennas?");
		int ant = s.nextInt();
		System.out.println("How many eyes?");
		int eye = s.nextInt();
		if (ant >= 3 && eye <= 4)
			System.out.println("TroyMartian");
		if (ant <= 6 && eye >= 2)
			System.out.println("VladSaturnian");
		if (ant <= 2 && eye <= 3)
			System.out.println("GraemeMecurian");
		s.close();
	}

}
