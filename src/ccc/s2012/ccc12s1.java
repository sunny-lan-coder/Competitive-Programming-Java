package ccc.s2012;

import java.util.Scanner;

public class ccc12s1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int j = s.nextInt();
		s.close();
		int[][] count = new int[j + 1][4];
		for (int i = 1; i <= j; i++) {
			count[i][0] = 1;
		}
		for (int i = 1; i < 4; i++) {
			for (int k = 1; k <= j; k++) {
				for (int l = k + 1; l <= j; l++) {
					count[l][i] += count[k][i-1];
				}
			}
		}
		System.out.println(count[j][3]);
	}

}
