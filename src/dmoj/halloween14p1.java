package dmoj;

import java.util.Scanner;

public class halloween14p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long k = s.nextLong();
		s.close();
		long min = Long.MAX_VALUE;
		min = Math.min(min, Math.abs(k - (n % k)));
		if (n > k)
			min = Math.min(min, n % k);
		System.out.println(min);
	}

}
