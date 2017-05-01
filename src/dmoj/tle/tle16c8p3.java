package dmoj.tle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class tle16c8p3 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		ArrayList<String> lst = new ArrayList<>();
		int i = 1;
		outer: while (lst.size() < 10000) {
			int lim = 1 << i;
			for (int j = 0; j < lim; j++) {
				String bs = Integer.toBinaryString(j);
				while (bs.length() < i) {
					bs = "0" + bs;
				}
				bs = bs.replace("0", "420").replace("1", "69");
				lst.add(bs);
				if (lst.size() >= 10000)
					break outer;
			}
			i++;
		}
		lst.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int cmp = Integer.compare(o1.length(), o2.length());
				// System.out.println("comparing "+o1+" and "+o2);
				if (cmp == 0)
					for (int i = 0; i < o1.length(); i++) {
						int val1 = Integer.parseInt(o1.charAt(i) + "");
						int val2 = Integer.parseInt(o2.charAt(i) + "");
						// System.out.println(" digit "+i+" -> "+val1+",
						// "+val2);
						if (val2 > val1) {
							// System.out.println(" second num bigger");
							cmp = -1;
							break;
						} else if (val1 > val2) {
							// System.out.println(" first num bigger");
							cmp = 1;
							break;
						}
					}
				// System.out.println(" res:"+cmp);
				return cmp;
			}
		});
		int lastlen = 2;
		int lencnt = 0;
		for (int j = 0; j < 1000; j++) {
			if (lst.get(j).length() == lastlen) {
				lencnt++;

			} else {
				System.out.println("len=" + lastlen + ", cnt=" + lencnt);
				lastlen = lst.get(j).length();
				lencnt = 1;

			}
		}

		for (int c = 0; c < t; c++) {
			int n = s.nextInt() - 1;
			System.out.println(lst.get(n));
		}
		s.close();
	}

}
