package codejam.y2017.r2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class AlphabetCake {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		 s= new Scanner(new File("A-large.in"));
//		s = new Scanner(System.in);
		PrintStream out;
		 out = new PrintStream("A_large_output.txt");
//		out = System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int r = s.nextInt();
			int c = s.nextInt();
			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String row = s.next();
				for (int j = 0; j < c; j++) {
					map[i][j] = row.charAt(j);
				}
			}

			boolean[][] visited = new boolean[r][c];

			while (true) {
				boolean flag = false;
				int maxi = -1;
				int maxj = -1;
				int maxie = -1;
				int maxje = -1;
				long max = -1;
				char x = '-';
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (visited[i][j])
							continue;
						if (map[i][j] != '?') {
							for (int is = 0; is < r; is++) {
								for (int js = 0; js < c; js++) {
									for (int ie = 0; ie < r; ie++) {
										outer: for (int je = 0; je < c; je++) {
											if(ie<is)
												continue;
											if(je<js)
												continue;
											if(is>i)
												continue;
											if(js>j)
												continue;
											if(ie<i)
												continue;
											if(je<j)
												continue;
											long dx = Math.abs(is - ie) + 1;
											long dy = Math.abs(js - je) + 1;
											if(map[i][j]=='I' && dx==3 && dy==4)
												System.out.println("ewr");
											for (int k = is; k <= ie; k++) {
												for (int l = js; l <= je; l++) {
													if (map[k][l] != '?' && map[i][j]!=map[k][l] || visited[k][l]) {
														continue outer;
													}
												}
											}

											
											long area = dx * dy;
											if (area >= max) {
												maxi = ie;
												maxj = je;
												maxie = is;
												maxje = js;
												max = area;
												x = map[i][j];
												flag = true;
											}
										}
									}
								}
							}

						}
					}
				}
				System.out.print("i: " + maxi + ",");
				System.out.println(maxie);
				System.out.print("j: " + maxj + ",");
				System.out.println(maxje);
				System.out.println(x);
				for (int k = Math.min(maxi, maxie); k <= Math.max(maxi, maxie); k++) {
					for (int l = Math.min(maxj, maxje); l <= Math.max(maxj, maxje); l++) {
						visited[k][l] = true;
						map[k][l] = x;
					}
				}
				for (int k = 0; k < r; k++) {
					for (int l = 0; l < c; l++) {
						System.out.print(map[k][l]);
						System.out.print(visited[k][l]);
					}
					System.out.println();
				}
				System.out.println();
				flag = true;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j] == '?')
							flag = false;
					}
				}
				if (flag)
					break;
			}
			out.println("Case #" + test + ":");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					out.print(map[i][j]);
				}
				out.println();
			}
		}
		s.close();
		out.close();
	}
}
