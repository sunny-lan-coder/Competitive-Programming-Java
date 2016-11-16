package codeforces.canadacup2016;

import java.util.Scanner;

public class FoodPlane {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		long n = Long.parseLong(input.substring(0, input.length() - 1)) - 1;
		long s = "fedabc".indexOf(input.charAt(input.length() - 1));

		long total = 0;

		long moved = (((n / 4) * 4)) + (n % 2);
		// System.out.println("times moved: " + moved);

		total += ((n / 4) * 12) + ((n % 2) * 6);

		total += moved;

		total += s;

		System.out.println(total + 1);

	}

}
