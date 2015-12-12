package ccc.junior.y2014;

import java.util.Scanner;

public class J1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = new int[3];
		a[0] = s.nextInt();
		a[1] = s.nextInt();
		a[2] = s.nextInt();
		int tot = 0;
		for (int i = 0; i < 3; i++) {
			tot += a[i];
		}
		if (tot != 180) {
			System.out.println("Error");
			s.close();
			return;
		}
		boolean eq = true;
		for (int i = 0; i < 3; i++) {
			eq &= (a[i] == 60);
		}
		if (eq)
			System.out.println("Equilateral");
		for (int i = 0; i < 3; i++) {
			eq |= (a[i] == a[(i + 1) % 3]);
		}
		if (eq)
			System.out.println("Isosceles");
		else
			System.out.println("Scalene");
		s.close();
	}
}
