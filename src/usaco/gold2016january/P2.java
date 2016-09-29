package usaco.gold2016january;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class P2 {

	static int n;
	static int m;
	static int[] johnX;
	static int[] johnY;
	static int[] bessieX;
	static int[] bessieY;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream("radio.in"));
		PrintStream out = new PrintStream(new FileOutputStream("radio.out"));
		n = s.nextInt();
		m = s.nextInt();
		johnX = new int[n + 1];
		johnY = new int[n + 1];
		bessieX = new int[m + 1];
		bessieY = new int[m + 1];
		johnX[0] = s.nextInt();
		johnY[0] = s.nextInt();
		bessieX[0] = s.nextInt();
		bessieY[0] = s.nextInt();
		String tmp = s.next();
		for (int i = 0; i < n; i++) {
			int deltaX = 0;
			int deltaY = 0;
			switch (tmp.charAt(i)) {
			case 'N':
				deltaY = 1;
				break;
			case 'W':
				deltaX = -1;
				break;
			case 'S':
				deltaY = -1;
				break;
			case 'E':
				deltaX = 1;
				break;
			}
			johnX[i + 1] = johnX[i] + deltaX;
			johnY[i + 1] = johnY[i] + deltaY;
//			System.out.println(johnX[i]+","+johnY[i]);
		}

//		System.out.println(johnX[n]+","+johnY[n]+"|");
		tmp = s.next();
		for (int i = 0; i < m; i++) {
			int deltaX = 0;
			int deltaY = 0;
			switch (tmp.charAt(i)) {
			case 'N':
				deltaY = 1;
				break;
			case 'W':
				deltaX = -1;
				break;
			case 'S':
				deltaY = -1;
				break;
			case 'E':
				deltaX = 1;
				break;
			}
			bessieX[i + 1] = bessieX[i] + deltaX;
			bessieY[i + 1] = bessieY[i] + deltaY;
//			System.out.println(bessieX[i]+","+bessieY[i]);
		}
//		System.out.println(bessieX[m]+","+bessieY[m]+"|");
		s.close();
		int[][] dp = new int[n+1][m+1];

		dp[0][0] = 0;
		for (int sum = 1; sum <= n + m; sum++) {
			
			int nmin=sum-Math.min(sum, m);
			int nmax=Math.min(sum, n);
			
			
			int nI;
			for(nI=nmin;nI<=nmax;nI++){
			int mI=sum-nI;
			
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
				int c = Integer.MAX_VALUE;
				if (nI > 0) {
					a = dp[nI - 1][mI];
				}
				if (mI > 0) {
					b = dp[nI][mI - 1];
				}
				if (nI > 0 && mI > 0) {
					c = dp[nI - 1][mI - 1];
				}
				dp[nI][mI] = Math.min(a, Math.min(b, c)) + e(mI, nI);
			}
			
//			printarr(dp);
//			System.out.println("---");
		}
		
		

		out.println(dp[n ][m ]);

		out.close();

	}

	static int e(int a, int b) {
		int xdif = Math.abs(bessieX[a] - johnX[b]);
		int ydif = Math.abs(bessieY[a] - johnY[b]);
		return xdif * xdif + ydif * ydif;
	}

	static void printarr(int[][] arr){
		for(int[] row: arr){
		 for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();
		}
	}
}
