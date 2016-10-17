package wcipeg.woburn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class wc161s1 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int d = s.nextInt();
			String r = s.next();
			s.close();
			ArrayList<Integer> roombegin = new ArrayList<>();
			ArrayList<Integer> roomend = new ArrayList<>();
			int roomcount = 0;
			boolean inroom = false;
			for (int i = 0; i < n; i++) {
				char c = r.charAt(i);
				if (c == '.') {
					if (!inroom) {
						roombegin.add(i);
						inroom = true;
						roomcount++;
					}
				} else {
					if (inroom) {
						roomend.add(i - 1);
						inroom = false;
					}
				}
			}
			if (inroom) {
				roomend.add(n);
				inroom = false;
			}

			HashSet<Integer> queued = new HashSet<Integer>();
			int[] val = new int[roomcount];
			for (int i = 0; i < roomcount; i++) {
				Iterator<Integer> it = queued.iterator();
				while (it.hasNext()) {
					int j = it.next();
					if (roombegin.get(i) - roomend.get(j) > d) {
						it.remove();
					} else {
						val[j]++;
					}
				}

				if (!queued.contains(i))
					queued.add(i);
			}

			// for(int i=0;i<roomcount;i++)
			// System.out.println(val[i]);

			int c = 0;
			for (int i = 0; i < roomcount; i++) {
				i += val[i] + val[i + val[i]];
				c++;
			}
			System.out.println(c);
		} catch (

		Exception e) {
			System.out.println(e.toString());
		}
	}

}
