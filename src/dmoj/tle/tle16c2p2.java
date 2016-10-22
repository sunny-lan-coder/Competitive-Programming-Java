package dmoj.tle;

import java.util.Scanner;

public class tle16c2p2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double n = s.nextInt();
		// when door facing you
		int x = s.nextInt();// front-back width
		int y = s.nextInt();// side-side width
		int z = s.nextInt();// up-down width
		// when back door facing you
		int a = s.nextInt();// front-back width
		int b = s.nextInt();// side-side width
		int c = s.nextInt();// up-down width
		s.close();

		// counts
		long facefront_o1_frontback = a / x;
		long facefront_o1_leftright = b / y;
		long facefront_o1_updown = c / z;
		long facefront_o1_count = facefront_o1_leftright * facefront_o1_frontback * facefront_o1_updown;

		long facefront_o2_frontback = a / x;
		long facefront_o2_leftright = b / z;
		long facefront_o2_updown = c / y;
		long facefront_o2_count = facefront_o2_leftright * facefront_o2_frontback * facefront_o2_updown;

		long faceside_o1_frontback = a / y;
		long faceside_o1_leftright = b / x;
		long faceside_o1_updown = c / z;
		long faceside_o1_count = faceside_o1_frontback * faceside_o1_leftright * faceside_o1_updown;

		long faceside_o2_frontback = a / z;
		long faceside_o2_leftright = b / x;
		long faceside_o2_updown = c / y;
		long faceside_o2_count = faceside_o2_frontback * faceside_o2_leftright * faceside_o2_updown;

		long faceup_o1_frontback = a / z;
		long faceup_o1_leftright = b / y;
		long faceup_o1_updown = c / x;
		long faceup_o1_count = faceup_o1_frontback * faceup_o1_leftright * faceup_o1_updown;

		long faceup_o2_frontback = a / y;
		long faceup_o2_leftright = b / z;
		long faceup_o2_updown = c / x;
		long faceup_o2_count = faceup_o2_frontback * faceup_o2_leftright * faceup_o2_updown;

		double max = 0;
		max = Math.max(max, facefront_o1_count);
		max = Math.max(max, facefront_o2_count);
		max = Math.max(max, faceside_o1_count);
		max = Math.max(max, faceside_o2_count);
		max = Math.max(max, faceup_o1_count);
		max = Math.max(max, faceup_o2_count);

		if (max == 0)
			System.out.println("SCAMMED");
		else
			System.out.println((long) Math.ceil(n / max));
	}

}
