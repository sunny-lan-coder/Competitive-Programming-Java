package ccc.s2009;

import java.util.Arrays;
import java.util.Scanner;

public class ccc09s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int l = s.nextInt();
		int[] rows = new int[r];
		for (int i = r - 1; i >= 0; i--) {
			String total = "";
			for (int j = 0; j < l; j++) {
				total = s.next() + total;
			}
			rows[i] = Integer.parseInt(total, 2);
		}
		s.close();

		boolean[] visited = new boolean[1 << l];

		int count = 0;
		for (int i = 0; i < r; i++) {
			int[] curr = Arrays.copyOf(rows, r);
			for (int j = i - 1; j >= 0; j--) {
				curr[j] ^= curr[j + 1];
			}
			if (!visited[curr[0]]) {
				count++;
				visited[curr[0]] = true;
			}
		}

		System.out.println(count);
	}

}
