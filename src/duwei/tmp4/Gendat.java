package duwei.tmp4;

import java.util.Random;

public class Gendat {

	public static void main(String[] args) {
		Random rng = new Random();
		for (int m = 1; m <= 8; m++) {
			for (int t = 0; t < 3; t++) {
				System.out.print(m);
				for (int i = 0; i < m; i++) {
					System.out.print(" " + rng.nextDouble() * 1000);
				}
				System.out.println();
			}
		}
		System.out.println("0");
	}

}
