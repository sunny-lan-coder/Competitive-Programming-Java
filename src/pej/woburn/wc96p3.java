package pej.woburn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wc96p3 {

	public static void main(String[] args) {
		String[] provinces = { "British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario", "Quebec",
				"Nova Scotia", "Newfoundland", "New Brunswick", "PEI" };

		Pattern[] patterns = new Pattern[provinces.length];

		for (int idx = 0; idx < provinces.length; idx++) {
			String tmp = provinces[idx].replace(" ", "").toLowerCase();
			String result = "^.*";
			for (int i = 0; i < tmp.length(); i++) {
				result = result + tmp.charAt(i) + ".*";
			}
			result = result + "$";
			System.out.println(result);
			patterns[idx] = Pattern.compile(result);
		}

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		outer: for (int testcase = 0; testcase < 5; testcase++) {
			String input = s.nextLine().toLowerCase();
			for (int idx = 0; idx < patterns.length; idx++) {
				Matcher m = patterns[idx].matcher(input);
				if (m.matches()) {
					System.out.println(provinces[idx]);
					continue outer;
				}
			}
			System.out.println("NO PROVINCE FOUND");
		}
		s.close();
	}

}
