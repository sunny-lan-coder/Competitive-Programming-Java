package dmpg17s;
import java.util.HashSet;
import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		int[][] map = new int[n][m];
		for (int i = 0; i < Math.min(n, m); i++) {
			for (int j = 0; j < m; j++) {
				if (j + i != 0) {
					int num = map[i][i + j - 1];

				}
			}
		}
		in.close();
	}

}
