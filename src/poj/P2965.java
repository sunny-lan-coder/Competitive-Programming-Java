package poj;

import java.util.Scanner;

public class P2965 {

	static int[][] timesSet;
	static int i, j, k;
	static Scanner in;
	static char[] line;

	static void spin(int i, int j) {
		// set row and col
		for (k = 0; k < 4; k++) {
			timesSet[i][k]++;
			timesSet[k][j]++;
		}
		// but since intersect reverses, add one again
		timesSet[i][j]--;
	}

	public static void main(String[] args) {
		// set each one seven times (some may be reversed (so cancel out))
		timesSet = new int[4][4];
		in = new Scanner(System.in);
		for (i = 0; i < 4; i++) {
			line = in.next().toCharArray();
			for (j = 0; j < 4; ++j) {
				if (line[j] == '+')
					spin(i, j);
			}
		}

		// count number of sets actually needed
		int setsTaken = 0;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if (timesSet[i][j] % 2 == 1) {
					setsTaken++;
				}
			}
		}

		// output sets
		System.out.println(setsTaken);
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if (timesSet[i][j] % 2 == 1) {
					System.out.println((i + 1) + " " + (j + 1));
				}
			}
		}
	}
}
