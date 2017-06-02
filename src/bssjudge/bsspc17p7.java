package bssjudge;

import java.util.Scanner;

public class bsspc17p7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		s.close();
		int cnt = 0;
		for (int a = 1; a <= k; a++)
			for (int b = a + 1; b <= k; b++) {
				int p = k - (a * b);
				if (p > 0)
					for (int c = b + 1; c <= Math.sqrt(p) + 1; c++)
						if (p % c == 0) {
							int d = p / c;
							if (d > c)
								if (d * c == p)
									cnt++;
						}
			}

		System.out.println(cnt);
	}

}
