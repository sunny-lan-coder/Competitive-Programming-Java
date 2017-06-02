package dmoj.dmpg17s;

import java.util.Scanner;

public class dmpg17b6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		double dig = 0;
		for (int i = 0; i < n; i++)
			dig += Math.log(s.nextDouble()) / Math.log(2);

		s.close();
		System.out.println(Math.floor(dig) + 1);
	}

}
