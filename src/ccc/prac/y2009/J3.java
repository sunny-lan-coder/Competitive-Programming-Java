package ccc.prac.y2009;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String time = s.nextLine();
		int hour;
		int min;
		if (time.length() == 3) {
			hour = Integer.parseInt(time.charAt(0) + "");
			min = Integer.parseInt(time.charAt(1) + "" + time.charAt(2));

		} else {
			hour = Integer.parseInt(time.charAt(0) + "" + time.charAt(1));
			min = Integer.parseInt(time.charAt(2) + "" + time.charAt(3));
		}
		s.close();
		System.out.println(getTime(hour, min, 0) + " in Ottawa");
		System.out.println(getTime(hour, min, -180) + " in Victoria");
		System.out.println(getTime(hour, min, -120) + " in Edmonton");
		System.out.println(getTime(hour, min, -60) + " in Winnipeg");
		System.out.println(getTime(hour, min, 0) + " in Toronto");
		System.out.println(getTime(hour, min, 60) + " in Halifax");
		System.out.println(getTime(hour, min, 90) + " in St. John’s");

	}

	static String getTime(int hour, int min, int offset) {
		int minadd = (offset % 60);
		int houradd = Math.floorDiv(offset, 60);

		// System.out.println("min"+minadd+"hour"+houradd);

		if (minadd < 0) {
			minadd += 60;
			houradd--;
		}

		int newmin = min + minadd;

		if (newmin >= 60) {
			newmin -= 60;
			houradd++;
		}

		int newhour = hour + houradd;
		if (newhour < 0) {
			newhour += 24;
		}
		newhour = newhour % 24;

		return "" + (newhour * 100 + newmin);
	}

}
