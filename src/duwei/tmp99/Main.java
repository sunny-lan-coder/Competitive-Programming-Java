package duwei.tmp99;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[] johnX;
	static int[] johnY;
	static int[] bessieX;
	static int[] bessieY;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PrintStream out = System.out;
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
				deltaY = -1;
			case 'W':
				deltaX = -1;
			case 'S':
				deltaY = 1;
			case 'E':
				deltaX = 1;
			}
			johnX[i+1]=johnX[i]+deltaX;
			johnY[i+1]=johnY[i]+deltaY;
		}
		tmp = s.next();
		for (int i = 0; i < n; i++) {
			int deltaX = 0;
			int deltaY = 0;
			switch (tmp.charAt(i)) {
			case 'N':
				deltaY = -1;
			case 'W':
				deltaX = -1;
			case 'S':
				deltaY = 1;
			case 'E':
				deltaX = 1;
			}
			bessieX[i+1]=bessieX[i]+deltaX;
			bessieY[i+1]=bessieY[i]+deltaY;
		}
		s.close();
		int[][] dp=new int[n+1][m+1];
		
		
		out.close();

	}

}
