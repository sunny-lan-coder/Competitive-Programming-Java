package ecoo;

import java.util.Scanner;

public class ecoo1p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int t = 0; t < 5; t++) {
			String l = s.nextLine();
			int N = l.length();
			for (int x = 0; x < N - 1; x++) {
				System.out.print(" ");
			}
			System.out.println(l.charAt(0));
			for (int i = 1; i < N; i++) {
				int j = N - i - 1;
				int k = i * 2 - 1;
				for (int x = 0; x < j; x++) {
					System.out.print(" ");
				}
				System.out.print(l.charAt(i));
				for (int x = 0; x < k; x++) {
					System.out.print(" ");
				}
				System.out.println(l.charAt(i));
			}
			for (int i = N - 2; i > 0; i--) {
				int j = N - i - 1;
				int k = i * 2 - 1;
				for (int x = 0; x < j; x++) {
					System.out.print(" ");
				}
				System.out.print(l.charAt(i));
				for (int x = 0; x < k; x++) {
					System.out.print(" ");
				}
				System.out.println(l.charAt(i));
			}
			for (int x = 0; x < N - 1; x++) {
				System.out.print(" ");
			}
			System.out.println(l.charAt(0));
		}
		s.close();
	}

}
