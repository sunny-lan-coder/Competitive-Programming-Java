package ccc.prac.y2010;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {

		int[] m = new int[2];
		Scanner s = new Scanner(System.in);
		while (true) {
			String[] ins = s.nextLine().split(" ");
			int code = Integer.parseInt(ins[0]);
			if (code == 7)
				break;
			int X = -1;
			int Y = -1;
			if (ins[1].equals("A")) {
				X = 0;
			} else {
				X = 1;
			}
			if (ins.length == 3) {
				if (ins[2].equals("A")) {
					Y = 0;
				} else if (ins[2].equals("B")) {
					Y = 1;
				} else {
					Y = Integer.parseInt(ins[2]);
				}
			}
			switch (code) {
			case 1:
				m[X] = Y;
				break;
			case 2:
				System.out.println(m[X]);
				break;
			case 3:
				m[X] = m[X] + m[Y];
				break;
			case 4:
				m[X] = m[X] * m[Y];
				break;
			case 5:
				m[X] = m[X] - m[Y];
				break;
			case 6:
				m[X] = Math.floorDiv(m[X], m[Y]);
				break;
			}
		}
		s.close();
	}

}
