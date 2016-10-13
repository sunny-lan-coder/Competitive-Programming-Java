package duwei.tmp10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		System.out.println(f(v));
	}

	static String f(int x) {
		if (x == 0)
			return "0";
		StringBuilder bs = new StringBuilder();
		for (int i = 31; i >= 0; i--) {
			if ((1 & (x >> i)) != 0) {
				if (i == 1)
					bs.append("2+");
				else {
					bs.append("2(" + f(i) + ")+");
				}
			}
		}
		if (bs.charAt(bs.length() - 1) == '+')
			bs.deleteCharAt(bs.length() - 1);
		return bs.toString();
	}
}
