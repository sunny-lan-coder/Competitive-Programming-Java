package ecoo;

import java.util.Scanner;

public class ecoo1p4 {

	static int cols;
	static int rows;
	static boolean[][] mat;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int t = 1; t <= 5; t++) {
			cols = s.nextInt();
			rows = s.nextInt();
			mat = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				String line = s.next();
				for (int j = 0; j < cols; j++) {
					if (line.charAt(j) == 'X')
						mat[i][j] = true;
					else
						mat[i][j] = false;
				}
			}

			int count = 0;

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (mat[i][j]) {
						count++;
						dfs(i, j);
//						for (int k = 0; k < rows; k++) {
//							for (int l = 0; l < cols; l++) {
//								if (mat[k][l]) {
//									System.out.print("X");
//								} else {
//									System.out.print(".");
//								}
//							}
//							System.out.println();
//						}
//
//						System.out.println();
					}
				}
			}
			System.out.println("In rectangle #" + t + " are " + count + " shapes");
		}
		s.close();
	}

	static void dfs(int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= cols)
			return;

		if (!mat[i][j])
			return;

		mat[i][j] = false;

		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j + 1);
		dfs(i, j - 1);
	}

}
