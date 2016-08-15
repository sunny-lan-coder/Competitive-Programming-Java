package ecoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ecoo12r2p4 {

	public static void main(String[] args) throws IOException {
		int[][][] magic = new int[8][][];

		magic[0] = new int[][] { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };

		magic[1] = new int[][] { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };

		magic[2] = new int[][] { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } };

		magic[3] = new int[][] { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } };

		magic[4] = new int[][] { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };

		magic[5] = new int[][] { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } };

		magic[6] = new int[][] { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } };

		magic[7] = new int[][] { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 5; t++) {
			int[][] board = new int[9][9];
			int[][] ans = new int[3][3];
			for (int i = 0; i < 9; i++) {
				String line = br.readLine();
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(line.charAt(j) + "");
					if (board[i][j] == 0)
						ans[i / 3][j / 3]++;
				}
			}

			// go through each block
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {

					// go through each magic square
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < 8; k++) {
						int moves = 0;
						// find missing numbers
						boolean[] v = new boolean[10];
						for (int r = 0; r < 3; r++)
							for (int c = 0; c < 3; c++)
								v[board[i + r][j + c]] = true;

						// fill in missing numbers optimally
						for (int r = 0; r < 3; r++)
							for (int c = 0; c < 3; c++)
								if (!v[magic[k][r][c]] && board[i + r][j + c] == 0) {
									v[magic[k][r][c]] = true;
									board[i + r][j + c] = magic[k][r][c];
								}

						// fill in rest of numbers randomly
						for (int l = 1; l <= 9; l++)
							if (!v[l])
								for (int r = 0; r < 3; r++)
									for (int c = 0; c < 3; c++)
										if (board[i + r][j + c] == 0)
											board[i + r][j + c] = l;

						// swap
						for (int r = 0; r < 3; r++)
							for (int c = 0; c < 3; c++)
								if (board[i+r][j+c]!=666 && board[i + r][j + c] != magic[k][r][c]){
									
								}


						min = Math.min(min, moves);
					}
					ans[i / 3][j / 3] += min;
				}
			}
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					System.out.print(ans[r][c]);

				}
				System.out.println();
			}
		}
	}

}
