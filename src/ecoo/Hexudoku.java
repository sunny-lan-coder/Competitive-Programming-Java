package ecoo;

import java.util.Scanner;

public class Hexudoku {
	public static void main(String[] main) {
		String convert = "0123456789ABCDEF";
		Scanner s = new Scanner(System.in);
		for (int t = 0; t < 5; t++) {
			char[][] map = new char[16][16];
			for (int i = 0; i < 16; i++) {
				String line = s.nextLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			int cnt = 0;

			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {

					if (map[i][j] != '-')
						continue;
//					System.out.println("filling in "+i+", "+j);
					boolean[] avail = new boolean[16];
					for (int k = 0; k < 16; k++) {
						if (map[i][k] != '-') {
//							System.out.println("block "+map[i][k]+"row");
							avail[convert.indexOf(map[i][k])] = true;
						}
						if (map[k][j] != '-') {
//							System.out.println("block "+map[k][j]+"col");
							avail[convert.indexOf(map[k][j])] = true;
						}
					}
					for (int k = 0; k < 4; k++) {
						for (int l = 0; l < 4; l++) {
							if (map[(i / 4) * 4 + k][(j / 4) * 4 + l] != '-') {
//								System.out.println("block "+map[(i / 4) * 4 + k][(j / 4) * 4 + l]+"quad");
								avail[convert.indexOf(map[(i / 4) * 4 + k][(j / 4) * 4 + l])] = true;
							}
						}
					}

					for (int k = 0; k < 16; k++) {
						if (!avail[k]) {
							map[i][j] = convert.charAt(k);
							cnt++;
							break;
						}
					}
				}
				
			}
//			for (int i = 0; i < 16; i++) {
//				for (int j = 0; j < 16; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			System.out.println(cnt);
		}
	}
}
