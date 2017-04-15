package codejam.y2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class TidyNumbers {

	static boolean isTidy(long n) {
		long currmax = 10;
		while (n > 0) {
			long dig = n % 10;
			if (dig > currmax)
				return false;
			currmax = Math.min(dig, currmax);
			n /= 10;
		}
		return true;
	}

	static int len;
	static int[] digits;

	static void check(int idx) {
		if (digits[idx - 1] > digits[idx]) {
			borrow(idx - 1);
		}
	}

	static void borrow(int idx) {
		digits[idx]--;
		for (int i = idx + 1; i <= len; i++)
			digits[i] = 9;
		check(idx);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc;
//		 sc= new Scanner(new File("B-large.in"));
		sc = new Scanner(System.in);
		PrintStream out;
//		 out = new PrintStream("B_large_output2.txt");
		out = System.out;
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			String n = sc.next();
			len = n.length();
			digits = new int[len + 1];
			for (int i = 0; i < len; i++) {
				digits[i + 1] = Integer.parseInt(n.charAt(i) + "");
			}
			for (int i = 1; i <= len; i++) {
				check(i);
			}
			out.print("Case #" + test + ": ");
			boolean flag = false;
			for (int dig : digits) {
				if (dig != 0)
					flag = true;
				if (flag)
					out.print(dig);
			}
			out.println();
		}
		sc.close();
		out.close();
	}

}
