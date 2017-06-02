package cco;

import java.util.Scanner;

public class cco17p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		s.close();
		int v = 1;
		int e = 0;
		StringBuilder buf = new StringBuilder();
		while (k > 0) {
			int loopSize = (int) Math.floor((Math.sqrt(8 * k + 1) + 1) / 2);
			v++;
			buf.append("1 " + v + "\n");
			e++;
			int loopStart = v;
			for (int i = 1; i < loopSize; i++) {
				buf.append(v + " " + (v + 1) + "\n");
				v++;
				e++;
			}
			buf.append(loopStart + " " + v + "\n");
			e++;
			k -= loopSize * (loopSize - 1) / 2;
		}
		System.out.println(v + " " + e);
		System.out.print(buf.toString());
	}

}
