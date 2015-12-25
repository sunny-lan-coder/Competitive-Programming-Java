package ccc.prac.y2012;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the speed limit:");
		int lmt = s.nextInt();
		System.out.print("Enter the recorded speed of the car:");
		int spd = s.nextInt();
		s.close();
		if (spd <= lmt) {
			System.out.println("Congratulations, you are within the speed limit!");
		} else {
			int fine = 999999999;
			int over = spd - lmt;
			if (over >= 1 && over <= 20)
				fine = 100;
			if (over >= 21 && over <= 30)
				fine = 270;
			if (over >= 31)
				fine = 500;
			System.out.println("You are speeding and your fine is $" + fine + ".");
		}
	}

}
