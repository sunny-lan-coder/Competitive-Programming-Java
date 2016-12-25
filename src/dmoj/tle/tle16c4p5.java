package dmoj.tle;

import java.util.Scanner;

public class tle16c4p5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int t = in.nextInt();
		int[][] vals = new int[s][t];
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < t; j++) {
				vals[i][j] = in.nextInt();
			}
		}
		in.close();
		
	}

}
