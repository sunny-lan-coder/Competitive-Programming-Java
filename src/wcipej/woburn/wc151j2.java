package wcipej.woburn;

import java.util.Scanner;

public class wc151j2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int remainder = N % M;
		int normalGroup = (N - remainder) / M;
		System.out.println((M - remainder) + " group(s) of " + normalGroup);
		if (remainder != 0)
			System.out.println(remainder + " group(s) of " + (normalGroup + 1));
		s.close();
	}

}
