package ccc.prac.y2010;

import java.util.Scanner;
import static java.lang.Math.*;

public class J1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		boolean[][] visited = new boolean[n + 1][n + 1];
		int count = 0;
		for (int hand2 = 0; hand2 <= min(5, n); hand2++) {
			int hand1 = n - hand2;

			if (hand1 >= 0 && hand1 <= 5)
				if (hand1 + hand2 == n && !visited[hand1][hand2]) {
					visited[hand1][hand2] = true;
					visited[hand2][hand1] = true;
					count++;
				}
		}
		System.out.println(count);
	}

}
