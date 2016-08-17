//P2

package usaco.gold2015december;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out =  new PrintStream(new FileOutputStream("feast.out"));
		InputStream in = new FileInputStream("feast.in");
		Scanner s = new Scanner(in);
		int t = s.nextInt();
		int a = s.nextInt();
		int b = s.nextInt();
		s.close();
		int[][] dp = new int[t + 1][2];
		dp[0][0] = 1;
		int max = 0;
		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i <= t; i++) {
				if (dp[i][j] == 1) {
					if (j == 0) {
						dp[i / 2][1] = 1;
					}
					if(i+a<=t)
					dp[i + a][j] = 1;
					if(i+b<=t)
					dp[i + b][j] = 1;
					max = Math.max(i, max);
				}
			}
		}
		out.println(max);

		out.close();
	}

}
