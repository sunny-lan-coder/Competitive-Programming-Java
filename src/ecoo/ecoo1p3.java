package ecoo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ecoo1p3 {

	public static void main(String[] args) {
		long[] monthlens = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		long yearlen = 365;
		long leapyearblocklen = yearlen * 4 + 1;

		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String in = s.next();
			String[] line = in.split(Pattern.quote("."));

			long days = Long.parseLong(line[0]);

			double frac = 0;
			if (line.length == 2)
				frac = Double.parseDouble(0 + "." + line[1]);

			double seconds = frac * 1440 * 60;
			long hours = (long) (seconds / 3600);
			seconds = seconds % 3600;
			long minutes = (long) (seconds / 60);
			seconds = Math.ceil(seconds % 60);


			if (hours == 24) {
				hours = 0;
				days++;
			}

			long leapyearblocks = days / leapyearblocklen;
			days = days % leapyearblocklen;

			long yearsafterleap = days / yearlen;
			if (yearsafterleap == 0) {
				monthlens[1] = 29;
			} else {
				days = days - 366;
			}
			days = days % yearlen;

			long years = leapyearblocks * 4 + yearsafterleap + 1904;

			int month;
			for (month = 0; month < 12; month++) {
				if (monthlens[month] > days)
					break;
				days -= monthlens[month];
			}
			monthlens[1] = 28;
			month++;
			
			System.out.println("year = " + years + " month = " + month + " day = " + (days + 1));

			System.out.printf("time is: %2d:%2d:%2d\n", hours, minutes, (long) seconds);
			System.out.println();
		}
		s.close();
	}

}
