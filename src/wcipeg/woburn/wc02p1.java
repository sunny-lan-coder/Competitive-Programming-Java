package wcipeg.woburn;

import java.util.Scanner;

public class wc02p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		outer: for (int testCase = 0; testCase < T; testCase++) {
			String time = s.next();
			String[] mlpiscool = time.split(":");
			int h = Integer.parseInt(mlpiscool[0]);
			int m = Integer.parseInt(mlpiscool[1]);

			int N = s.nextInt();

			// if (N > 1 + 2 + 5 + 9) {
			// System.out.println("Infinite");
			// continue;
			// }

			int currentSum = h * 60 + m;

			for (int increase = 1; increase < 781; increase++) {
				int total = currentSum + increase;
				int minutes = total % 60;
				int hours = ((total - minutes) / 60) % 12;

				if (hours == 0)
					hours = 12;

				int m1 = minutes % 10;
				int m2 = (minutes - m1) / 10;
				int h1 = hours % 10;
				int h2 = (hours - h1) / 10;

				System.out.println(h2 + "" + h1 + ":" + m2 + "" + m1);

				int sum = m1 + m2 + h1 + h2;
				if (sum == N) {
					System.out.println(increase);
					continue outer;
				}
			}

			System.out.println("Infinite");
		}
		s.close();
	}

}
