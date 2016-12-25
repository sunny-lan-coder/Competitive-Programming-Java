package dmoj.tle;

import java.util.Random;
import java.util.Scanner;

public class tle16c4p6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int s = in.nextInt();
		int m = in.nextInt();
		in.close();
		int hash = 1;
		String map = "abcdefghijklmnopqrstuvwxyz";
		Random rng = new Random();
		while (hash != k) {
			int x = rng.nextInt(24) + 1;
			if (k == 0)
				x = 0;
			hash = (((hash * x) % m) * s) % m;
			System.out.print(map.charAt(x));
			if (n != 0) {
				System.out.print(" ");
				n--;
			}
		}
	}

}
