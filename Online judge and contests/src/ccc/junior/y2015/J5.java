package ccc.junior.y2015;

import java.util.Scanner;

public class J5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int pies = s.nextInt();
		int people = s.nextInt();
		lookup = new int[pies + 10][people + 10][pies + 10];
		System.out.println(waysToDistrubute(pies, people, 1));
		s.close();
	}

	static int[][][] lookup;

	static int waysToDistrubute(int pies, int people, int minimumPies) {
		// 1 pie per person
		if (pies == people) {
			lookup[pies][people][minimumPies] = 1;
			return 1;
		}

		// all pies to one person
		if (people == 1) {
			lookup[pies][people][minimumPies] = 1;
			return 1;
		}

		// calculate sub-solution
		int waycount = 0;
		for (int i = minimumPies; i < (pies / people) + 1; i++) {
			waycount += waysToDistrubute(pies - i, people - 1, i);
		}
		lookup[pies][people][minimumPies] = waycount;
		return waycount;
	}
}
