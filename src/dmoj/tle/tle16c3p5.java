package dmoj.tle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class tle16c3p5 {

	public static void main(String[] args) throws IOException {
		String[] tmp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tmp = br.readLine().split(" ");
		int r = Integer.parseInt(tmp[0]);
		int c = Integer.parseInt(tmp[1]);

		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			map[i][c] = 1;
		}
		for (int i = 0; i <= c; i++) {
			map[r][i] = 1;
		}

		// for(int[] row:map){
		// for(int num:row){
		// System.out.print(num+" ");
		// }
		// System.out.println();
		// }

		for (int i = 0; i < m; i++) {
			int max = 0;
			tmp = br.readLine().split(" ");
			int u = Integer.parseInt(tmp[0]);
			int v = Integer.parseInt(tmp[1]);

			map[u - 1][v - 1] = 1;

			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (map[j][k] == 0) {
						int sidelen;
						outer: for (sidelen = 1; sidelen < 99999999; sidelen++) {
							for (int x = 0; x < sidelen; x++) {
								for (int y = 0; y < sidelen; y++) {
									if (map[x + j][y + k] == 1)
										break outer;
								}
							}
						}

						max = Math.max(max, sidelen-1);
					}
				}
			}

			System.out.println(max);
		}

		br.close();
	}

}
