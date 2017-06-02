package bssjudge;

import java.util.Scanner;

public class bsspc17p4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double ax = s.nextDouble();
		double ay = s.nextDouble();
		double bx = s.nextDouble();
		double by = s.nextDouble();
		double cx = s.nextDouble();
		double cy = s.nextDouble();
		s.close();
		System.out.println(Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2));
	}

}
