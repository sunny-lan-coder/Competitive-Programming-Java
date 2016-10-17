package wcipeg.woburn;

import java.util.ArrayList;
import java.util.Scanner;

public class wc161s1 {

	public static void main(String[] args) {
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
		// int[] dp = new int[roomcount + 1];
		// for (int i = 0; i <= roomcount; i++) {
		// dp[i] = Integer.MAX_VALUE / 2;
		// // System.out.println(roombegin.get(i) + ", " + roomend.get(i));
		// }
		// dp[0] = 0;
		//
		// for (int i = 0; i < roomcount; i++) {
		// int end = roomend.get(i);
		// for (int j = i; j < roomcount; j++) {
		// int begin = roombegin.get(j);
		// if (begin - end > d) {
		//
		// break;
		// }
		// dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
		// }
		// }
		//
		// System.out.println(dp[roomcount]);
		int currentroom = 0;
		int lastroom = 0;
		int count = 0;
		outer: while (lastroom < roomcount) {
			if (currentroom + 1 >= roomcount || roombegin.get(currentroom + 1) - roomend.get(lastroom) > d) {
				lastroom = currentroom + 1;
				for (int i = currentroom; i <= roomcount; i++) {
					if (i >= roomcount)
						break outer;
					if (roombegin.get(i) - roombegin.get(currentroom) > d) {
						lastroom = i;
						currentroom = lastroom;
						count++;
						break;
					}
				}

			} else {
				currentroom++;
			}

		}
		System.out.println(count);
	}

}
