

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();

		if (a == 60 && b == 60 && c == 60)
			System.out.println("Equilateral");
		else {
			if (a + b + c == 180) {
				int i = 0;
				
				if (a == b)
					i++;
				if (b == c)
					i++;
				if (c == a)
					i++;
				
				if (i == 1)
					System.out.println("Isosceles");
				else
					System.out.println("Scalene");
			} else {
				System.out.println("Error");
			}
		}
		s.close();
	}

}
